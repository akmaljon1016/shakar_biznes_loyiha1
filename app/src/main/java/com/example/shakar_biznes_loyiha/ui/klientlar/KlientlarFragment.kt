package com.example.shakar_biznes_loyiha.ui.klientlar

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ScrollView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.adapters.KlientRecAdapter
import com.example.shakar_biznes_loyiha.databinding.FragmentKlientlarBinding
import com.example.shakar_biznes_loyiha.model.RecKlient
import com.example.shakar_biznes_loyiha.models.klient.Item
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class KlientlarFragment : BaseFragment<FragmentKlientlarBinding>() {

    val adapterRec by lazy { KlientRecAdapter(requireActivity()) }
    val pagerAdapter by lazy { KlientlarPagerAdapter(requireActivity()) }
    private val spinnerArray = arrayOf("20", "50", "100", "200", "500", "1000", "barchasi")
    val klinetViewModel: KlientlarViewModel by viewModels()
    val klientArray = arrayListOf<RecKlient>(
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod")
    )

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            delay(1)
            binding.nestedScrollView.fullScroll(ScrollView.FOCUS_UP)
        }
        binding.swipeToRefresh.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                if (hasInternetConnection()) {
                    loadingData()

                } else {

                }
            }

        })
        binding.btnKlientEdit.setOnClickListener {
            Toast.makeText(requireContext(), "btn Klient qo'shish", Toast.LENGTH_SHORT).show()
        }
        binding.btnKlientEdit.setOnClickListener {
            Toast.makeText(requireContext(), "btn Klient edit", Toast.LENGTH_SHORT).show()
        }
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnerArray)
        binding.rowNumberSpinner.adapter = adapter
        adapterRec.setDataList(klientArray)
        binding.recyclerview.adapter = pagerAdapter
        binding.btnKlientQoshish.setOnClickListener {
            findNavController().navigate(R.id.action_nav_klientlar_to_klientQoshishFragment)
        }
//        klinetViewModel.getKlientData(2)
//        klinetViewModel.readKlientData.observe(viewLifecycleOwner,{
//            Toast.makeText(requireActivity(),it.data?.data.toString(), Toast.LENGTH_SHORT).show()
//        })
//        adapterRec.setOnItemClickListenr(object : KlientRecAdapter.OnClickItemListener {
//            override fun onClickItemListener(data: RecKlient) {
//                val popUpMenu: PopupMenu = PopupMenu(requireContext(), binding.recyclerview)
//                popUpMenu.menuInflater.inflate(R.menu.pup_up_menu, popUpMenu.menu)
//                popUpMenu.show()
//            }
//        })
        pagerAdapter.setOnKlientItemClickListener(object :
            KlientlarPagerAdapter.onKlientItemClickListener {
            override fun onItemClick(klient: Item?) {
                val action = KlientlarFragmentDirections.actionNavKlientlarToKorishFragment(klient)
                findNavController().navigate(action)
            }
        })
        loadingData()
    }

    fun loadingData() {
        viewLifecycleOwner.lifecycleScope.launch {
            klinetViewModel.listData.collectLatest {
                pagerAdapter.submitData(it)
                delay(1)
                binding.nestedScrollView.fullScroll(ScrollView.FOCUS_UP)
                binding.swipeToRefresh.isRefreshing = false
            }
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentKlientlarBinding = FragmentKlientlarBinding.inflate(inflater, container, false)

    @RequiresApi(Build.VERSION_CODES.M)
    private fun hasInternetConnection(): Boolean {
        val connectivityManager =
            requireActivity().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}