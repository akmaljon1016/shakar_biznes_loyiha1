package com.example.shakar_biznes_loyiha.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.shakar_biznes_loyiha.data.network.RemoteDataSource

abstract class BaseFragment<B : ViewBinding> : Fragment() {
    protected lateinit var binding: B
    lateinit var remoteDataSource: RemoteDataSource

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)
        return binding.root
    }


    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B
}