package com.example.shakar_biznes_loyiha.ui.klientlar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.Repository
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.databinding.FragmentKlientlarBinding

class KlientlarFragment : BaseFragment<KlientlarViewModel, FragmentKlientlarBinding, Repository>() {


    private val spinnerArray = arrayOf("20", "50", "100", "200", "500", "1000", "barchasi")


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnKlientEdit.setOnClickListener {
            Toast.makeText(requireContext(), "btn Klient qo'shish", Toast.LENGTH_SHORT).show()
        }
        binding.btnKlientEdit.setOnClickListener {
            Toast.makeText(requireContext(), "btn Klient edit", Toast.LENGTH_SHORT).show()
        }
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnerArray)
        binding.rowNumberSpinner.adapter = adapter

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentKlientlarBinding = FragmentKlientlarBinding.inflate(inflater, container, false)

    override fun getViewModel(): Class<KlientlarViewModel> = KlientlarViewModel::class.java

    override fun getFragmentRepository(): Repository = Repository()


}