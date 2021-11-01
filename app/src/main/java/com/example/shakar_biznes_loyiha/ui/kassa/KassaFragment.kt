package com.example.shakar_biznes_loyiha.ui.kassa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.repository.Repository
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.adapters.KassaRecAdapter
import com.example.shakar_biznes_loyiha.databinding.KassaFragmentBinding
import com.example.shakar_biznes_loyiha.model.RecKassa

class KassaFragment : BaseFragment<KassaFragmentBinding>() {

    val kassaRecAdapter by lazy { KassaRecAdapter() }

    val spinnerArray = arrayOf("20", "50", "100", "200", "500", "1000", "barchasi")
    val spinnerArray1 =
        arrayOf("barchasi", "Abdulloh", "Salohiddin", "Eshonali", "AbuBakr", "G'ulom", "Tohir")
    val recArray= arrayListOf<RecKassa>(
        RecKassa("Akmaljon","Xorazm","12.3.2012",300000,12,10000,20000000.0,1212121212.0,230.0),
        RecKassa("Akmaljon","Xorazm","12.3.2012",300000,12,10000,20000000.0,1212121212.0,230.0)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnerArray)
        val adapter1 = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnerArray1)
        binding.rowNumberSpinner.adapter = adapter
        binding.searchSpinner.adapter = adapter1
        kassaRecAdapter.setDataList(recArray)
        binding.recyclerview.adapter=kassaRecAdapter
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): KassaFragmentBinding = KassaFragmentBinding.inflate(inflater, container, false)
}