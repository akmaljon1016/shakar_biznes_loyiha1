package com.example.shakar_biznes_loyiha.ui.klientlar

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.adapters.KlientRecAdapter
import com.example.shakar_biznes_loyiha.databinding.FragmentKlientlarBinding
import com.example.shakar_biznes_loyiha.model.RecKlient
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class KlientlarFragment : BaseFragment<FragmentKlientlarBinding>() {

    val adapterRec by lazy { KlientRecAdapter(requireActivity()) }
    val pagerAdapter by lazy{KlientlarPagerAdapter(requireActivity())}
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
        loadingData()
    }

    fun loadingData() {
        viewLifecycleOwner.lifecycleScope.launch {
           klinetViewModel.listData.collectLatest {
               pagerAdapter.submitData(it)
               Toast.makeText(requireContext(),it.toString(), Toast.LENGTH_SHORT).show()
               Log.d("KLIENT",it.toString())
           }
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentKlientlarBinding = FragmentKlientlarBinding.inflate(inflater, container, false)
}