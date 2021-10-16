package com.example.shakar_biznes_loyiha.ui.klientlar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.repository.Repository
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.adapters.KlientRecAdapter
import com.example.shakar_biznes_loyiha.databinding.FragmentKlientlarBinding
import com.example.shakar_biznes_loyiha.model.RecKlient

class KlientlarFragment : BaseFragment<KlientlarViewModel, FragmentKlientlarBinding, Repository>() {

    val adapterRec by lazy { KlientRecAdapter(requireActivity()) }
    private val spinnerArray = arrayOf("20", "50", "100", "200", "500", "1000", "barchasi")

    val klientArray = arrayListOf<RecKlient>(
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod"),
        RecKlient("Adham", 21212121, 232323232, 21212121, "zavod")
    )

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
        binding.recyclerview.adapter = adapterRec
//        adapterRec.setOnItemClickListenr(object : KlientRecAdapter.OnClickItemListener {
//            override fun onClickItemListener(data: RecKlient) {
//                val popUpMenu: PopupMenu = PopupMenu(requireContext(), binding.recyclerview)
//                popUpMenu.menuInflater.inflate(R.menu.pup_up_menu, popUpMenu.menu)
//                popUpMenu.show()
//            }
//        })
    }
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentKlientlarBinding = FragmentKlientlarBinding.inflate(inflater, container, false)

    override fun getViewModel(): Class<KlientlarViewModel> = KlientlarViewModel::class.java

    override fun getFragmentRepository(): Repository = Repository()


}