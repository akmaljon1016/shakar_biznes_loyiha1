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
import com.example.shakar_biznes_loyiha.repository.Repository
import com.example.shakar_biznes_loyiha.adapters.BaseFragment
import com.example.shakar_biznes_loyiha.adapters.BoshSahifaAdapter
import com.example.shakar_biznes_loyiha.databinding.FragmentKunlikHisobotlarBinding
import com.example.shakar_biznes_loyiha.model.RecBoshSohifa
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


class KunlikHisobotlarFragment :
    BaseFragment<KunlikHisobotlarViewModel, FragmentKunlikHisobotlarBinding, Repository>() {

    var datePicker: DatePicker? = null
    private val adapter by lazy { BoshSahifaAdapter(requireActivity()) }
    val boshSahifaItem = arrayListOf<RecBoshSohifa>(
        RecBoshSohifa("Akmaljon", 1221212121),
        RecBoshSohifa("Sobirjon", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
        RecBoshSohifa("Azamat", 1221212121),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtCalendarView.setOnClickListener {
            val fragment: DialogFragment = CustomDatePickerFragment()
            fragment.show(requireFragmentManager(), "DatePicker")
        }
        adapter.setDataList(boshSahifaItem)
        binding.recyclerview.adapter = adapter
        CoroutineScope(Dispatchers.Main).launch {
            binding.nestedScrollView.scrollTo(0,-2000)
        }
    }


    class CustomDatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
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

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentKunlikHisobotlarBinding =
        FragmentKunlikHisobotlarBinding.inflate(inflater, container, false)

    override fun getViewModel(): Class<KunlikHisobotlarViewModel> =
        KunlikHisobotlarViewModel::class.java

    override fun getFragmentRepository(): Repository = Repository()
}
