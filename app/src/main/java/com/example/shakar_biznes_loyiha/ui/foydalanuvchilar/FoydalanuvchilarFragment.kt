package com.example.shakar_biznes_loyiha.ui.foydalanuvchilar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.shakar_biznes_loyiha.R

class FoydalanuvchilarFragment : Fragment() {

    companion object {
        fun newInstance() = FoydalanuvchilarFragment()
    }

    private lateinit var viewModel: FoydalanuvchilarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.foydalanuvchilar_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FoydalanuvchilarViewModel::class.java)
        // TODO: Use the ViewModel
    }

}