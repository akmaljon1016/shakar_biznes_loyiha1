package com.example.shakar_biznes_loyiha.ui.olingan_yuklar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.repository.Repository
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.adapters.OlinganYuklarRecAdapter
import com.example.shakar_biznes_loyiha.databinding.OlinganYuklarFragmentBinding
import com.example.shakar_biznes_loyiha.model.RecOlinganYuk

class OlinganYuklarFragment :
    BaseFragment<OlinganYuklarFragmentBinding>() {
    val adapterRec by lazy { OlinganYuklarRecAdapter() }
    private val spinnerArray = arrayOf("20", "50", "100", "200", "500", "1000", "barchasi")
    private val spinnerArrayCity = arrayOf("---", "Angren", "Rossiya", "Xorazm")
    val spinnerKlient =
        arrayOf("barchasi", "Abdulloh", "Salohiddin", "Eshonali", "AbuBakr", "G'ulom", "Tohir")
    val arrayRec = arrayListOf<RecOlinganYuk>(
        RecOlinganYuk("Adham", "Xorazm", "2021.10.10", "10 tonna", 9500, 17000000),
        RecOlinganYuk("Adham", "Xorazm", "2021.10.10", "10 tonna", 9500, 17000000),
        RecOlinganYuk("Adham", "Xorazm", "2021.10.10", "10 tonna", 9500, 17000000),
        RecOlinganYuk("Adham", "Xorazm", "2021.10.10", "10 tonna", 9500, 17000000),
        RecOlinganYuk("Adham", "Xorazm", "2021.10.10", "10 tonna", 9500, 17000000),
        RecOlinganYuk("Adham", "Xorazm", "2021.10.10", "10 tonna", 9500, 17000000),
        RecOlinganYuk("Adham", "Xorazm", "2021.10.10", "10 tonna", 9500, 17000000),
        RecOlinganYuk("Adham", "Xorazm", "2021.10.10", "10 tonna", 9500, 17000000)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnerArray)
        binding.rowNumberSpinner.adapter = adapter

        val adapterCity = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnerArrayCity)
        binding.citySpinner.adapter = adapterCity

        val adapterName = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnerKlient)
        binding.searchSpinner.adapter = adapterName
        adapterRec.setDataList(arrayRec)
        binding.recyclerview.adapter = adapterRec
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): OlinganYuklarFragmentBinding =
        OlinganYuklarFragmentBinding.inflate(inflater, container, false)
}