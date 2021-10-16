package com.example.shakar_biznes_loyiha.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.model.RecBoshSohifa
import kotlinx.android.synthetic.main.bosh_sahifa_items.view.*

class BoshSahifaAdapter(val context: Context) :
    RecyclerView.Adapter<BoshSahifaAdapter.MyViewHolder>() {
    var list = emptyList<RecBoshSohifa>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layout = LayoutInflater.from(parent.context)
                val layoutInflater = layout.inflate(R.layout.bosh_sahifa_items, parent, false)
                return MyViewHolder(layoutInflater)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder.from(parent)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rowPosition = holder.adapterPosition
        if (rowPosition == 0) {
            holder.itemView.order_number.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.name.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.summa.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.order_number.text = "#"
            holder.itemView.name.text = "Ism"
            holder.itemView.summa.text = "Summa"
        } else {
            val singleItems = list[rowPosition - 1]
            if (rowPosition % 2 == 0) {
                holder.itemView.order_number.setBackgroundResource(R.drawable.table_style_row_juft)
                holder.itemView.name.setBackgroundResource(R.drawable.table_style_row_juft)
                holder.itemView.summa.setBackgroundResource(R.drawable.table_style_row_juft)
            } else {
                holder.itemView.order_number.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.name.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.summa.setBackgroundResource(R.drawable.table_style_rows_toq)
            }
            holder.itemView.order_number.text = rowPosition.toString()
            holder.itemView.name.text = singleItems.name
            holder.itemView.summa.text = singleItems.summa.toString()
            holder.itemView.setOnClickListener {
                Toast.makeText(context, singleItems.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int = list.size
    fun setDataList(dataList: List<RecBoshSohifa>) {
        this.list = dataList
        notifyDataSetChanged()
    }
}