package com.example.shakar_biznes_loyiha.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.data.database.Entity.BoshSahifaEntity
import com.example.shakar_biznes_loyiha.models.boshSahifa.BoshSahifa
import com.example.shakar_biznes_loyiha.models.boshSahifa.Client
import com.example.shakar_biznes_loyiha.utils.GenericDiffUtill
import kotlinx.android.synthetic.main.bosh_sahifa_items.view.*

class BoshSahifaAdapter(val context: Context) :
    RecyclerView.Adapter<BoshSahifaAdapter.MyViewHolder>() {
    var list = emptyList<Client>()

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

        val singleItems = list[rowPosition]
        if (rowPosition % 2 == 0) {
            holder.itemView.order_number.setBackgroundResource(R.drawable.table_style_row_juft)
            holder.itemView.name.setBackgroundResource(R.drawable.table_style_row_juft)
            holder.itemView.summa.setBackgroundResource(R.drawable.table_style_row_juft)
        } else {
            holder.itemView.order_number.setBackgroundResource(R.drawable.table_style_rows_toq)
            holder.itemView.name.setBackgroundResource(R.drawable.table_style_rows_toq)
            holder.itemView.summa.setBackgroundResource(R.drawable.table_style_rows_toq)
        }
        holder.itemView.order_number.text = ((rowPosition + 1).toString())
        holder.itemView.name.text = singleItems.name
        holder.itemView.summa.text = singleItems.finishAccount.toString()
        holder.itemView.setOnClickListener {
            Toast.makeText(context, singleItems.toString(), Toast.LENGTH_SHORT).show()
        }
    }


    override fun getItemCount(): Int = list.size

    fun setDataList(newDataList: List<Client>) {
        val genericDiffUtil = GenericDiffUtill(list, newDataList)
        val diffUtilResult = DiffUtil.calculateDiff(genericDiffUtil)
        list = newDataList
        diffUtilResult.dispatchUpdatesTo(this)
    }
}