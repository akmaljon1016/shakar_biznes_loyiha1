package com.example.shakar_biznes_loyiha.ui.sklad

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.Repository
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.databinding.SkladFragmentBinding

class SkladFragment : BaseFragment<SkladViewModel, SkladFragmentBinding, Repository>() {
    val spinnerArray = arrayOf("20", "50", "100", "200", "500", "1000", "barchasi")

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnerArray)
        binding.rowNumberSpinner.adapter = adapter
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): SkladFragmentBinding = SkladFragmentBinding.inflate(inflater, container, false)

    override fun getViewModel(): Class<SkladViewModel> = SkladViewModel::class.java

    override fun getFragmentRepository(): Repository = Repository()

}