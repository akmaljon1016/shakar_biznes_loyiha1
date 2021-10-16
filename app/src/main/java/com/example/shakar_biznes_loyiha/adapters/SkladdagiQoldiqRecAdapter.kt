package com.example.shakar_biznes_loyiha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.model.RecSkladdagiQoldiq
import kotlinx.android.synthetic.main.skladdagi_qoldiq_rec_item.view.*

class SkladdagiQoldiqRecAdapter :
    RecyclerView.Adapter<SkladdagiQoldiqRecAdapter.MyViewHolder>() {

    var list = emptyList<RecSkladdagiQoldiq>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): SkladdagiQoldiqRecAdapter.MyViewHolder {
                val layout = LayoutInflater.from(parent.context)
                val layoutInflater =
                    layout.inflate(R.layout.skladdagi_qoldiq_rec_item, parent, false)
                return SkladdagiQoldiqRecAdapter.MyViewHolder(layoutInflater)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rowPosition = holder.adapterPosition
        if (rowPosition == 0) {
            holder.itemView.txtSkladOrderNumber.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.txtSkladShakarTuri.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.txtSladQoldiq.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.txtSladNarxi.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.txtSkladUmumiySumma.setBackgroundResource(R.drawable.table_style_header)
        } else {
            val singleItems = list[rowPosition - 1]
            if (rowPosition%2==0){
            holder.itemView.txtSkladOrderNumber.setBackgroundResource(R.drawable.table_style_row_juft)
            holder.itemView.txtSkladShakarTuri.setBackgroundResource(R.drawable.table_style_row_juft)
            holder.itemView.txtSladQoldiq.setBackgroundResource(R.drawable.table_style_row_juft)
            holder.itemView.txtSladNarxi.setBackgroundResource(R.drawable.table_style_row_juft)
            holder.itemView.txtSkladUmumiySumma.setBackgroundResource(R.drawable.table_style_row_juft)
            }
            else{
                holder.itemView.txtSkladOrderNumber.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.txtSkladShakarTuri.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.txtSladQoldiq.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.txtSladNarxi.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.txtSkladUmumiySumma.setBackgroundResource(R.drawable.table_style_rows_toq)
            }

            holder.itemView.txtSkladOrderNumber.text = rowPosition.toString()
            holder.itemView.txtSkladShakarTuri.text = singleItems.shakarTuri
            holder.itemView.txtSladQoldiq.text = singleItems.qoldiqQop.toString()
            holder.itemView.txtSladNarxi.text = singleItems.narxQop.toString()
            holder.itemView.txtSkladUmumiySumma.text = singleItems.umumiySumma.toString()
        }
    }

    override fun getItemCount(): Int = list.size
    fun setDataList(dataList: List<RecSkladdagiQoldiq>) {
        this.list = dataList
        notifyDataSetChanged()
    }
}