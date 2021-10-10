package com.example.shakar_biznes_loyiha.ui.kunlik_hisobotlar


import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.databinding.FragmentKunlikHisobotlarBinding
import java.util.*


class KunlikHisobotlarFragment : Fragment() {

    private var _binding: FragmentKunlikHisobotlarBinding? = null
    val binding get() = _binding!!

    var datePicker: DatePicker? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentKunlikHisobotlarBinding.inflate(inflater)
        datePicker = view?.findViewById(R.id.txt_calendarView)
        binding.btnCalendar.setOnClickListener {
            val fragment: DialogFragment = CustomDatePickerFragment()
            fragment.show(requireFragmentManager(), "DatePicker")
        }
        return binding.root
    }

    class CustomDatePickerFragment : DialogFragment(),DatePickerDialog.OnDateSetListener {

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val calendar: Calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONDAY)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val datePicker =
                DatePickerDialog(
                    requireContext(),
                    AlertDialog.THEME_HOLO_LIGHT,
                    this,
                    year,
                    month,
                    day
                )
            val textview = TextView(requireActivity())
            val layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
            )
            textview.layoutParams = layoutParams
            textview.setPadding(20, 20, 20, 20)
            textview.gravity = Gravity.CENTER
            textview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25f)
            textview.setText("This is Custom TItle")
            textview.setTextColor(Color.parseColor("#ffffff"))
            textview.setBackgroundColor(Color.parseColor("#FF000000"))
            datePicker.setCustomTitle(textview)
            return datePicker
        }

        override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {

        }
    }
}
