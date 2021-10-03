package com.example.shakar_biznes_loyiha.ui.sklad

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shakar_biznes_loyiha.R

class SkladFragment : Fragment() {

    companion object {
        fun newInstance() = SkladFragment()
    }

    private lateinit var viewModel: SkladViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sklad_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SkladViewModel::class.java)
        // TODO: Use the ViewModel
    }

}