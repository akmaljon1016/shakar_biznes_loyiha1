package com.example.shakar_biznes_loyiha.ui.XodimQoshish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.repository.Repository
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.databinding.XodimQoshishFragmentBinding
import com.google.android.material.slider.Slider

class XodimQoshishFragment :
    BaseFragment<XodimQoshishViewModel, XodimQoshishFragmentBinding, Repository>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            binding.radioGroup.setOnCheckedChangeListener { p0, p1 ->
                when (p1) {
                    R.id.rbFaol -> {
                        Toast.makeText(requireContext(), "Faol", Toast.LENGTH_SHORT).show()

                    }
                    R.id.rbNoaFaol -> {
                        Toast.makeText(requireContext(), "NoFaol", Toast.LENGTH_SHORT).show()


                    }
                }
            }

    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): XodimQoshishFragmentBinding = XodimQoshishFragmentBinding.inflate(inflater, container, false)

    override fun getViewModel(): Class<XodimQoshishViewModel> = XodimQoshishViewModel::class.java

    override fun getFragmentRepository(): Repository = Repository()


}