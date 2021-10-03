package com.example.shakar_biznes_loyiha.ui.sotilgan_yuklar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shakar_biznes_loyiha.R

class SotilganYuklarFragment : Fragment() {

    companion object {
        fun newInstance() = SotilganYuklarFragment()
    }

    private lateinit var viewModel: SotilganYuklarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sotilgan_yuklar_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SotilganYuklarViewModel::class.java)
        // TODO: Use the ViewModel
    }

}