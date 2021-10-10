package com.example.shakar_biznes_loyiha.ui.kassa

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.Repository
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.databinding.KassaFragmentBinding
import com.example.shakar_biznes_loyiha.ui.klientlar.KlientlarViewModel

class KassaFragment : BaseFragment<KassaViewModel, KassaFragmentBinding, Repository>() {

    val spinnerArray = arrayOf("20", "50", "100", "200", "500", "1000", "barchasi")
    val spinnerArray1 = arrayOf("barchasi","Abdulloh", "Salohiddin", "Eshonali", "AbuBakr", "G'ulom", "Tohir")

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnerArray)
        val adapter1 = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnerArray1)
        binding.rowNumberSpinner.adapter=adapter
        binding.searchSpinner.adapter = adapter1
    }


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): KassaFragmentBinding = KassaFragmentBinding.inflate(inflater, container, false)
    override fun getViewModel(): Class<KassaViewModel> = KassaViewModel::class.java
    override fun getFragmentRepository(): Repository = Repository()
}