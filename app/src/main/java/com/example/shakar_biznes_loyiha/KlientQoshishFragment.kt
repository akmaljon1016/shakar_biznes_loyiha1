package com.example.shakar_biznes_loyiha

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ScrollView
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.databinding.FragmentKlientQoshishBinding
import com.example.shakar_biznes_loyiha.databinding.KlientQoshishItemBinding
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.klient_qoshish_item.view.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class KlientQoshishFragment : BaseFragment<FragmentKlientQoshishBinding>() {

    var list: ArrayList<Vaqincha> = arrayListOf()
    private val spinnner1Array = arrayOf("Barchasi", "Klient", "Investor", "Zavod", "Firma")
    val adapter1 by lazy {
        ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            spinnner1Array
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val adapter1 = ArrayAdapter(requireContext(), R.layout.spinner_item, spinnner1Array)
        addView()
        binding.btnAddClient.setOnClickListener {
            addView()
            lifecycleScope.launch {
                delay(2)
                binding.nestedScrollView.fullScroll(ScrollView.FOCUS_DOWN)
            }
            binding.btnSaqlash.setOnClickListener {
                checkIfValidAndRead()
                val string = StringBuilder()
                for (item in list) {
                    string.append(item)
                }
                Toast.makeText(requireContext(), "$string", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addView() {
        val view: View = layoutInflater.inflate(R.layout.klient_qoshish_item, null, false)
        val spinner = view.findViewById<Spinner>(R.id.spinnerKlientTuri)
        spinner.adapter = adapter1
        view.btn_x.setOnClickListener {
            removeView(view)
        }
        binding.layoutList.addView(view)
    }

    private fun removeView(view: View) {
        binding.layoutList.removeView(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun checkIfValidAndRead() {
        list.clear()
        for (i in 0 until binding.layoutList.childCount) {
            Log.d("SON",i.toString())
            val view: View = binding.layoutList.getChildAt(i)
            val editIsm: TextInputEditText = view.findViewById(R.id.editIsm)
            val spinner: Spinner = view.findViewById(R.id.spinnerKlientTuri)
            val editBoshlangichQarz: TextInputEditText = view.findViewById(R.id.editBoshlangichQarz)
            if (editIsm.text.toString().isNotEmpty() && editBoshlangichQarz.text.toString()
                    .isNotEmpty()
            ) {
                val vaqtincha = Vaqincha(
                    editIsm.text.toString(),
                    spinner.selectedItem.toString(),
                    editBoshlangichQarz.text.toString().toInt()
                )
                list.add(vaqtincha)
            }
        }
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentKlientQoshishBinding =
        FragmentKlientQoshishBinding.inflate(inflater, container, false)
}


data class Vaqincha(
    var ism: String,
    var turi: String,
    var qarzi: Int
)