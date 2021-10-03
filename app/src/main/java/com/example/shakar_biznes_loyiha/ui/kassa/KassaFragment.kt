package com.example.shakar_biznes_loyiha.ui.kassa

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shakar_biznes_loyiha.R

class KassaFragment : Fragment() {

    companion object {
        fun newInstance() = KassaFragment()
    }

    private lateinit var viewModel: KassaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.kassa_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(KassaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}