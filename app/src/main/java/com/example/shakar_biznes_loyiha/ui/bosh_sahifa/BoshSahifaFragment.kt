package com.example.shakar_biznes_loyiha.ui.bosh_sahifa

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.adapters.BoshSahifaAdapter
import com.example.shakar_biznes_loyiha.databinding.FragmentBoshsahifaBinding
import com.example.shakar_biznes_loyiha.model.RecBoshSohifa
import kotlinx.android.synthetic.main.fragment_boshsahifa.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent

class BoshSahifaFragment : Fragment(), AdapterView.OnItemSelectedListener,
    SearchView.OnQueryTextListener {
    private val adapter by lazy { BoshSahifaAdapter(requireActivity()) }
    private var _binding: FragmentBoshsahifaBinding? = null
    val binding get() = _binding!!
    private val boshSahifaItem = arrayListOf<RecBoshSohifa>(
//        RecBoshSohifa("Akmaljon", 1221212121),
//        RecBoshSohifa("Sobirjon", 1221212121),
//        RecBoshSohifa("Azamat", 1221212121),
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBoshsahifaBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        adapter.setDataList(boshSahifaItem)
        binding.recBoshSahifa.layoutManager = LinearLayoutManager(requireActivity())
        binding.recBoshSahifa.adapter = adapter
        binding.searchview.setOnQueryTextListener(this)
        CoroutineScope(Dispatchers.Main).launch {
            binding.nestedScrollView.scrollTo(0, -500)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
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
                adapter.setDataList(fiteredList)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)
        val search = menu.findItem(R.id.menu_search)
        val searchview = search?.actionView as? SearchView
        searchview?.isSubmitButtonEnabled = true
    }
}