package com.example.shakar_biznes_loyiha.adapters

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.app.Fragment
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.ui.kunlik_hisobotlar.KunlikHisobotlarFragment
import java.lang.ClassCastException
import java.lang.IllegalStateException

class CalendarViewAdapter : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.calendar_view, null)
            val dataPicker = view.findViewById<DatePicker>(R.id.datePicker)
            builder.setView(view)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                dataPicker.setOnDateChangedListener(object : DatePicker.OnDateChangedListener {
                    override fun onDateChanged(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                    }
                })
            }
            builder.create()
        } ?: throw IllegalStateException("sasasasa")
    }
}