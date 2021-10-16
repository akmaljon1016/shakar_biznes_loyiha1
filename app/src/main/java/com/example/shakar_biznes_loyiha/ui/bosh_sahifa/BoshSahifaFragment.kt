package com.example.shakar_biznes_loyiha.ui.bosh_sahifa

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.repository.Repository
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.adapters.BoshSahifaAdapter
import com.example.shakar_biznes_loyiha.adapters.SkladdagiQoldiqRecAdapter
import com.example.shakar_biznes_loyiha.databinding.FragmentBoshsahifaBinding
import com.example.shakar_biznes_loyiha.model.RecBoshSohifa
import com.example.shakar_biznes_loyiha.model.RecSkladdagiQoldiq
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent

class BoshSahifaFragment :
    BaseFragment<BoshSahifaViewModel, FragmentBoshsahifaBinding, Repository>(),
    AdapterView.OnItemSelectedListener,
    SearchView.OnQueryTextListener {
    private val adapterBosh by lazy { BoshSahifaAdapter(requireActivity()) }
    private val adapterSklad by lazy { SkladdagiQoldiqRecAdapter() }

    val boshSahifaItem = arrayListOf<RecBoshSohifa>(
        RecBoshSohifa("Akmaljon", 1221212121),
        RecBoshSohifa("Sobirjon", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
    )
    private val skladdagiQoldiqItem = arrayListOf<RecSkladdagiQoldiq>(
        RecSkladdagiQoldiq("Angren", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Rossiya", 282, 385, 108570),
        RecSkladdagiQoldiq("Xorazm", 282, 385, 108570),
        RecSkladdagiQoldiq("Xorazm", 282, 385, 108570),
        RecSkladdagiQoldiq("Xorazm", 282, 385, 108570),
        RecSkladdagiQoldiq("Xorazm", 282, 385, 108570),
        RecSkladdagiQoldiq("Xorazm", 282, 385, 108570),
        RecSkladdagiQoldiq("Xorazm", 282, 385, 108570),
        RecSkladdagiQoldiq("Xorazm", 282, 385, 108570),
        RecSkladdagiQoldiq("Xorazm", 282, 385, 108570),
        RecSkladdagiQoldiq("Xorazm", 282, 385, 108570),
        RecSkladdagiQoldiq("Xorazm", 282, 385, 108570),
        RecSkladdagiQoldiq("Xorazm", 282, 385, 108570),
        RecSkladdagiQoldiq("Angren", 282, 385, 108570),
        RecSkladdagiQoldiq("Angren", 282, 385, 108570),
        RecSkladdagiQoldiq("Angren", 282, 385, 108570)
    )
    private val spinnner1Array = arrayOf("Barchasi", "Klient", "invesrtor", "Zavod", "firma")
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
                Toast.makeText(requireContext(), "sasasasas", Toast.LENGTH_SHORT).show()
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
        adapterBosh.setDataList(boshSahifaItem)
        //Recyclerview1

        //binding.recBoshSahifa.isNestedScrollingEnabled = false
        binding.recBoshSahifa.layoutManager = LinearLayoutManager(requireActivity())
        binding.recBoshSahifa.adapter = adapterBosh

        //Recyclerview2
        adapterSklad.setDataList(skladdagiQoldiqItem)
        binding.recSkladdagiQoldiq.layoutManager = LinearLayoutManager(requireActivity())
        binding.recSkladdagiQoldiq.adapter = adapterSklad
        binding.searchview.setOnQueryTextListener(this)

        CoroutineScope(Dispatchers.Main).launch {
            binding.nestedScrollView.scrollTo(0, -2000)
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (p0!!.id == R.id.spinner1) {
            //Toast.makeText(requireContext(), spinnner1Array[p2], Toast.LENGTH_SHORT).show()
        } else if (p0!!.id == R.id.spinner2) {
            //Toast.makeText(requireContext(), spinner2Array[p2], Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        filter(newText)
        return false
    }

    private fun filter(newText: String?) {
        val fiteredList = arrayListOf<RecBoshSohifa>()
        for (item in boshSahifaItem) {
            if (item.name.lowercase().contains(newText!!.lowercase())) {
                fiteredList.add(item)
            }
            if (fiteredList.isEmpty()) {
                // Toast.makeText(requireContext(), "No data found", Toast.LENGTH_SHORT).show()
            } else {
                adapterBosh.setDataList(fiteredList)
            }
        }
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

    override fun getViewModel(): Class<BoshSahifaViewModel> = BoshSahifaViewModel::class.java

    override fun getFragmentRepository(): Repository = Repository()
}