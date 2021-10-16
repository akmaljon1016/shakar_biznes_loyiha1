package com.example.shakar_biznes_loyiha.ui.sklad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.repository.Repository
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.adapters.SkladRecAdapter
import com.example.shakar_biznes_loyiha.databinding.SkladFragmentBinding
import com.example.shakar_biznes_loyiha.model.SkladRec

class SkladFragment : BaseFragment<SkladViewModel, SkladFragmentBinding, Repository>() {
    val spinnerArray = arrayOf("20", "50", "100", "200", "500", "1000", "barchasi")

    val arrayRec = arrayListOf<SkladRec>(
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21),
        SkladRec("xorazm", 12, 15000.0, 3400000.0, 323, 45, 21)
    )
    val adapterRec by lazy { SkladRecAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnerArray)
        binding.rowNumberSpinner.adapter = adapter
        adapterRec.setDataList(arrayRec)
        binding.recyclerview.adapter = adapterRec
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): SkladFragmentBinding = SkladFragmentBinding.inflate(inflater, container, false)

    override fun getViewModel(): Class<SkladViewModel> = SkladViewModel::class.java

    override fun getFragmentRepository(): Repository = Repository()

}