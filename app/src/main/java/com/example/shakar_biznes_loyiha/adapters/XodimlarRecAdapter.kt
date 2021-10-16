package com.example.shakar_biznes_loyiha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.databinding.XodimlarRecItemBinding
import com.example.shakar_biznes_loyiha.model.RecXodimlar

class XodimlarRecAdapter : RecyclerView.Adapter<XodimlarRecAdapter.MyViewHolder>() {

    var list = emptyList<RecXodimlar>()

    inner class MyViewHolder(val binding: XodimlarRecItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            XodimlarRecItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        tableColorXodimlar(holder)
    }

    override fun getItemCount(): Int = list.size
    fun setDataList(dataList: List<RecXodimlar>) {
        this.list = dataList
        notifyDataSetChanged()
    }

    fun tableColorXodimlar(holder: MyViewHolder) {
        val rowPosition = holder.adapterPosition
        if (rowPosition == 0) {
            with(holder) {
                binding.apply {
                    xodimOrderNumber.setBackgroundResource(R.drawable.table_style_header)
                    xodimLogin.setBackgroundResource(R.drawable.table_style_header)
                    xodimIsm.setBackgroundResource(R.drawable.table_style_header)
                    xodimFamiliya.setBackgroundResource(R.drawable.table_style_header)
                    xodimStatus.setBackgroundResource(R.drawable.table_style_header)
                    xodimYaratildi.setBackgroundResource(R.drawable.table_style_header)
                    actionLayout.setBackgroundResource(R.drawable.table_style_header)
                }
            }
        } else {
            if (rowPosition==1){
                holder.binding.imgXodimlarOchirish.visibility = View.INVISIBLE
            }
            holder.binding.actionTextview.visibility = View.GONE
            if (rowPosition % 2 == 0) {
                with(holder) {
                    binding.apply {
                        xodimOrderNumber.setBackgroundResource(R.drawable.table_style_row_juft)
                        xodimLogin.setBackgroundResource(R.drawable.table_style_row_juft)
                        xodimIsm.setBackgroundResource(R.drawable.table_style_row_juft)
                        xodimFamiliya.setBackgroundResource(R.drawable.table_style_row_juft)
                        xodimStatus.setBackgroundResource(R.drawable.table_style_row_juft)
                        xodimYaratildi.setBackgroundResource(R.drawable.table_style_row_juft)
                        actionLayout.setBackgroundResource(R.drawable.table_style_row_juft)
                    }
                }
            } else {
                with(holder) {
                    binding.apply {
                        xodimOrderNumber.setBackgroundResource(R.drawable.table_style_rows_toq)
                        xodimLogin.setBackgroundResource(R.drawable.table_style_rows_toq)
                        xodimIsm.setBackgroundResource(R.drawable.table_style_rows_toq)
                        xodimFamiliya.setBackgroundResource(R.drawable.table_style_rows_toq)
                        xodimStatus.setBackgroundResource(R.drawable.table_style_rows_toq)
                        xodimYaratildi.setBackgroundResource(R.drawable.table_style_rows_toq)
                        actionLayout.setBackgroundResource(R.drawable.table_style_rows_toq)
                    }
                }
            }
            with(holder) {
                val singleItem = list[rowPosition - 1]
                binding.apply {
                    xodimOrderNumber.text = rowPosition.toString()
                    singleItem.apply {
                        xodimLogin.text = this.login
                        xodimIsm.text = this.ism
                        xodimFamiliya.text = this.familiya
                        xodimStatus.text = this.status
                        xodimYaratildi.text = this.yaratildi
                    }
                }
            }
        }
    }
}