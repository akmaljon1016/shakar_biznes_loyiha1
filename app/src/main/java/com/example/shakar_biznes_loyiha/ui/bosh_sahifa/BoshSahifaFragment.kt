package com.example.shakar_biznes_loyiha.ui.bosh_sahifa

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ScrollView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.adapters.BoshSahifaAdapter
import com.example.shakar_biznes_loyiha.adapters.SkladdagiQoldiqRecAdapter
import com.example.shakar_biznes_loyiha.databinding.FragmentBoshsahifaBinding
import com.example.shakar_biznes_loyiha.models.boshSahifa.Client
import com.example.shakar_biznes_loyiha.utils.NetworkListener
import com.example.shakar_biznes_loyiha.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent

@AndroidEntryPoint
class BoshSahifaFragment :
    BaseFragment<FragmentBoshsahifaBinding>(),
    AdapterView.OnItemSelectedListener,
    SearchView.OnQueryTextListener {
    private val adapterBosh by lazy { BoshSahifaAdapter(requireActivity()) }
    private val adapterSklad by lazy { SkladdagiQoldiqRecAdapter() }
    val boshSahifaViewModel: BoshSahifaViewModel by viewModels()
    private lateinit var networkListener: NetworkListener
    var boshSahifaDataList = arrayListOf<Client>()
    private var filteredList = arrayListOf<Client>()

    private val spinnner1Array = arrayOf("Barchasi", "Klient", "Investor", "Zavod", "Firma")
    private val spinner2Array = arrayOf(
        "Boshlang'ich",
        "ismi o'sish",
        "ismi kamayish",
        "Puli o'sish",
        "Puli kamayish",
        "Haqdorlar",
        "Qarzdorlar"
    )
    private val spinner3Array = arrayOf("20", "50", "100", "200", "500", "1000", "barchasi")

    @ExperimentalCoroutinesApi
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
                    requestApiData()
                    binding.spinner1.setSelection(0)
                    binding.spinner2.setSelection(0)
                } else {
                    Toast.makeText(requireContext(), "No Internet Connection", Toast.LENGTH_SHORT)
                        .show()
                    binding.swipeToRefresh.isRefreshing = false
                }
            }

        })
        if (hasInternetConnection()) {
            requestApiData()
        } else {
            readDatabase()
        }
        //binding.recSkladdagiQoldiq.isNestedScrollingEnabled=false
        val adapter1 = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnner1Array)

        val adapter2 =
            ArrayAdapter(requireContext(), R.layout.spinner_item, spinner2Array)

        val adapter3 =
            ArrayAdapter(requireContext(), R.layout.spinner_item, spinner3Array)

        binding.spinner1.adapter = adapter1
        binding.spinner2.adapter = adapter2
        binding.spinner3.adapter = adapter3

        binding.spinner1.onItemSelectedListener = this
        binding.spinner2.onItemSelectedListener = this
        binding.btnDeafult.setOnClickListener {
            binding.spinner1.setSelection(0)
            binding.spinner2.setSelection(0)

            binding.searchview.setOnClickListener {
                //binding.nestedScrollView.smoothScrollTo(0, 450, 1000)
                ///Toast.makeText(requireContext(), "sasasasas", Toast.LENGTH_SHORT).show()
            }
        }
        KeyboardVisibilityEvent.setEventListener(
            requireActivity(),
            viewLifecycleOwner,
            { isOpen ->
                if (isOpen) {
                    binding.nestedScrollView.smoothScrollTo(0, 470, 2000)
                }
            })
        //Recyclerview1

        //binding.recBoshSahifa.isNestedScrollingEnabled = false
        binding.recBoshSahifa.adapter = adapterBosh

        //Recyclerview2
        binding.recSkladdagiQoldiq.adapter = adapterSklad
        binding.searchview.setOnQueryTextListener(this)


    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun requestApiData() {
        boshSahifaViewModel.getBoshSahifaData()
        boshSahifaViewModel.boshSahifaData.observe(requireParentFragment().viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> {
                    readDatabase()
                    binding.swipeToRefresh.isRefreshing = false
                }
                is NetworkResult.Error -> {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                    binding.swipeToRefresh.isRefreshing = false
                }
            }
        })
    }

    fun readDatabase() {
        lifecycleScope.launch {
            boshSahifaViewModel.readBoshSahifaData.observe(viewLifecycleOwner, {
                adapterBosh.setDataList(it.data.data.clients)
                adapterSklad.setDataList(it.data.data.sklad)
                binding.txtUmumiy.text = it.data!!.data.kassa.umumiyHisob.toString()
                binding.txtKassaSum.text = it.data!!.data.kassa.kassaSum.toString()
                binding.txtKassaDollor.text = it.data!!.data.kassa.kassaDollar.toString()
                binding.txtBank.text = it.data!!.data.kassa.kassaBank.toString()
                boshSahifaDataList = it.data.data.clients as ArrayList<Client>
                filteredList.clear()
                filteredList.addAll(boshSahifaDataList)
                binding.nestedScrollView.fullScroll(ScrollView.FOCUS_UP)

//                Log.d("CURRENT",filter("Zavod").toString())
            })
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (p0!!.id == R.id.spinner1) {
            adapterBosh.setDataList(filter(spinnner1Array[p2]))
            adapterBosh.notifyDataSetChanged()
            binding.recBoshSahifa.layoutManager?.scrollToPosition(0)
            binding.spinner2.setSelection(0)
        } else if (p0!!.id == R.id.spinner2) {
            Toast.makeText(requireContext(), spinner2Array[p2], Toast.LENGTH_SHORT).show()
            if (p2 == 0) {
                adapterBosh.setDataList(filteredList)
                adapterBosh.notifyDataSetChanged()
                binding.recBoshSahifa.layoutManager?.scrollToPosition(0)
            }
            if (p2 == 1) {
                adapterBosh.setDataList(sortListWithNameAsc(filteredList))
                for (item in filteredList) {
                    Log.d("FILTER", item.name)
                }
                Log.d("FILTER", "------------------------")
                for (item in sortListWithNameAsc(filteredList)) {
                    Log.d("FILTER", item.name)
                }
                adapterBosh.notifyDataSetChanged()
                binding.recBoshSahifa.layoutManager?.scrollToPosition(0)
            }
            if (p2 == 2) {
                adapterBosh.setDataList(sortListWithNameDesc(filteredList))
                adapterBosh.notifyDataSetChanged()
                binding.recBoshSahifa.layoutManager?.scrollToPosition(0)
            }
            if (p2 == 3) {
                adapterBosh.setDataList(sortListWithPuliDesc(filteredList))
                adapterBosh.notifyDataSetChanged()
                binding.recBoshSahifa.layoutManager?.scrollToPosition(0)
            }
            if (p2 == 4) {
                adapterBosh.setDataList(sortListWithPulAsc(filteredList))
                adapterBosh.notifyDataSetChanged()
                binding.recBoshSahifa.layoutManager?.scrollToPosition(0)
            }

        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        searchviewFilter(newText.toString())
        return false
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        val search = menu.findItem(R.id.menu_search)
        val searchview = search?.actionView as? SearchView
        searchview?.isSubmitButtonEnabled = true
    }

    //BaseFragment
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBoshsahifaBinding = FragmentBoshsahifaBinding.inflate(inflater, container, false)

    override fun onDestroyView() {
        super.onDestroyView()
        binding == null
    }

    override fun onResume() {
        super.onResume()
        binding.recBoshSahifa.layoutManager?.scrollToPosition(0)

    }

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

    fun filter(data: String): List<Client> {
//        var filteredList: ArrayList<Client> = arrayListOf()
        filteredList.clear()
        if (data == "Barchasi") {
            filteredList.addAll(boshSahifaDataList)
            // filteredList=boshSahifaDataList
        } else {
            for (item in boshSahifaDataList) {
                if (item.typeName.equals(data)) {
                    filteredList.add(item)
                }
            }
        }
        return filteredList
    }

    fun sortListWithNameAsc(list: List<Client>): List<Client> {
//        var sortedList = list.sortedWith(compareBy {
//            it.name
//        })
//        return sortedList
        var sortedList=list.sortedBy {
            it.name
        }
        return sortedList
    }

    fun sortListWithNameDesc(list: List<Client>): List<Client> {
        var sortedList = list.sortedWith(compareByDescending {
            it.name
        })
        return sortedList
    }

    fun sortListWithPuliDesc(list: List<Client>): List<Client> {
        var sortedList = list.sortedWith(compareByDescending {
            it.finishAccount
        })
        return sortedList
    }

    fun sortListWithPulAsc(list: List<Client>): List<Client> {
        var sortedList = list.sortedWith(compareBy {
            it.finishAccount
        })
        return sortedList
    }

    fun searchviewFilter(text: String) {
        val filteredList: ArrayList<Client> = arrayListOf()
        for (item in boshSahifaDataList) {
            if (item.name.lowercase().contains(text.lowercase())) {
                filteredList.add(item)
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(requireContext(), "No Data Found", Toast.LENGTH_SHORT).show()
        } else {
            adapterBosh.setDataList(filteredList)
        }
    }
}