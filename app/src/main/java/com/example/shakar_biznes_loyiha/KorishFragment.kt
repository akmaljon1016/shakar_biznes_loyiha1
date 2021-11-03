package com.example.shakar_biznes_loyiha

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.databinding.FragmentKorishBinding

class KorishFragment : BaseFragment<FragmentKorishBinding>() {
    private val args by navArgs<KorishFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data=args.klientToKorish?.name
        Toast.makeText(requireContext(), "$data", Toast.LENGTH_SHORT).show()
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentKorishBinding = FragmentKorishBinding.inflate(inflater, container, false)

}