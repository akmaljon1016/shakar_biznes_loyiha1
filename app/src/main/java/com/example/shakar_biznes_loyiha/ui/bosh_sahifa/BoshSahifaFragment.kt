package com.example.shakar_biznes_loyiha.ui.bosh_sahifa

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.collection.arraySetOf
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.databinding.FragmentBoshsahifaBinding
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener


class BoshSahifaFragment : Fragment(), AdapterView.OnItemSelectedListener {

    var _binding: FragmentBoshsahifaBinding? = null
    val binding get() = _binding!!
    val spinnner1Array = arrayOf("Barchasi", "Klient", "invesrtor", "Zavod", "firma")
    val spinner2Array = arrayOf(
        "Boshlang'ich",
        "ismi o'sish",
        "ismi kamayish",
        "Puli o'sish",
        "Puli kamayish",
        "Haqdorlar",
        "Qarzdorlar"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBoshsahifaBinding.inflate(inflater)
        val adapter1 =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, spinnner1Array)
        val adapter2 =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, spinner2Array)

        //adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner1.adapter = adapter1
        binding.spinner2.adapter = adapter2
        binding.spinner1.onItemSelectedListener = this
        binding.spinner2.onItemSelectedListener = this
        binding.btnDeafult.setOnClickListener {
            binding.spinner1.setSelection(0)
            binding.spinner2.setSelection(0)

            binding.searchview.setOnClickListener {
                //binding.nestedScrollView.smoothScrollTo(0, 450, 1000)
                Toast.makeText(requireContext(), "sasasasas", Toast.LENGTH_SHORT).show()
            }
        }
        KeyboardVisibilityEvent.setEventListener(
            requireActivity(),
            viewLifecycleOwner,
            object : KeyboardVisibilityEventListener {
                override fun onVisibilityChanged(isOpen: Boolean) {
                    if (isOpen) {
                        binding.nestedScrollView.smoothScrollTo(0, 470, 2000)
                    }
                }

            })
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if (p0!!.id == R.id.spinner1) {
            //Toast.makeText(requireContext(), spinnner1Array[p2], Toast.LENGTH_SHORT).show()
        } else if (p0!!.id == R.id.spinner2) {
            //Toast.makeText(requireContext(), spinner2Array[p2], Toast.LENGTH_SHORT).show()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }


}