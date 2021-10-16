package com.example.shakar_biznes_loyiha.ui.foydalanuvchilar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.repository.Repository
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.adapters.XodimlarRecAdapter
import com.example.shakar_biznes_loyiha.databinding.FoydalanuvchilarFragmentBinding
import com.example.shakar_biznes_loyiha.model.RecXodimlar

class FoydalanuvchilarFragment :
    BaseFragment<FoydalanuvchilarViewModel, FoydalanuvchilarFragmentBinding, Repository>() {
    val adapterRec by lazy { XodimlarRecAdapter() }
    val arrayRec = arrayListOf<RecXodimlar>(
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24"),
        RecXodimlar("anvar", "anvar", "G'aniyev", "faol", "2021.03.24")
    )
    private val spinnerArray = arrayOf("20", "50", "100", "200", "500", "1000", "barchasi")


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnerArray)
        binding.rowNumberSpinner.adapter = adapter
        binding.btnXodimQoshish.setOnClickListener {
            findNavController().navigate(R.id.action_nav_foydalanuvchilar_to_xodimQoshishFragment)
        }
        binding.btnAdminQoshish.setOnClickListener {
            findNavController().navigate(R.id.action_nav_foydalanuvchilar_to_adminQoshishFragment)
        }
        adapterRec.setDataList(arrayRec)
        binding.recyclerview.adapter = adapterRec
    }


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FoydalanuvchilarFragmentBinding =
        FoydalanuvchilarFragmentBinding.inflate(inflater, container, false)

    override fun getViewModel(): Class<FoydalanuvchilarViewModel> =
        FoydalanuvchilarViewModel::class.java

    override fun getFragmentRepository(): Repository = Repository()
}