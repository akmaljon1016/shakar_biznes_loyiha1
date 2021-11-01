package com.example.shakar_biznes_loyiha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.databinding.KassaRecItemBinding
import com.example.shakar_biznes_loyiha.model.RecKassa
import kotlinx.android.synthetic.main.kassa_rec_item.view.*
import kotlin.math.sin

class KassaRecAdapter : RecyclerView.Adapter<KassaRecAdapter.MyViewHolder>() {

    var list = emptyList<RecKassa>()

    class MyViewHolder(binding: KassaRecItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder(
            KassaRecItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rowPosition = holder.adapterPosition
        tableColorKassa(holder)
    }

    override fun getItemCount(): Int = list.size
    fun setDataList(dataList: List<RecKassa>) {
        this.list = dataList
        notifyDataSetChanged()
    }

    fun tableColorKassa(holder: MyViewHolder) {
        val rowPosition = holder.adapterPosition
        if (rowPosition == 0) {
            holder.itemView.apply {
                checkboxKassa.setBackgroundResource(R.drawable.table_style_header)
                txtKassaOrderNumber.setBackgroundResource(R.drawable.table_style_header)
                txtKassaIsm.setBackgroundResource(R.drawable.table_style_header)
                txtKassaTuri.setBackgroundResource(R.drawable.table_style_header)
                txtKassaSana.setBackgroundResource(R.drawable.table_style_header)
                txtKassaJami.setBackgroundResource(R.drawable.table_style_header)
                txtKassaSom.setBackgroundResource(R.drawable.table_style_header)
                txtKassaDollor.setBackgroundResource(R.drawable.table_style_header)
                txtKassaDollorKursi.setBackgroundResource(R.drawable.table_style_header)
                txtKassaDollorSumda.setBackgroundResource(R.drawable.table_style_header)
                txtKassaBank.setBackgroundResource(R.drawable.table_style_header)
                actionLayout.setBackgroundResource(R.drawable.table_style_header)

                txtKassaOrderNumber.text = "#"
                txtKassaIsm.text = "Klient"
                txtKassaTuri.text = "Turi"
                txtKassaSana.text = "Sana"
                txtKassaJami.text = "Jami"
                txtKassaSom.text = "So'm"
                txtKassaDollor.text = "Dollor"
                txtKassaDollorKursi.text = "Dollor Kursi"
                txtKassaDollorSumda.text = "Dollor Sumda"
                txtKassaBank.text = "Bank"
                actionTextview.text = "Actions"
            }

        } else {
            val rowPosition = holder.adapterPosition
            holder.itemView.actionTextview.visibility = View.GONE
            if (rowPosition % 2 == 0) {
                holder.itemView.apply {
                    checkboxKassa.setBackgroundResource(R.drawable.table_style_row_juft)
                    txtKassaOrderNumber.setBackgroundResource(R.drawable.table_style_row_juft)
                    txtKassaIsm.setBackgroundResource(R.drawable.table_style_row_juft)
                    txtKassaTuri.setBackgroundResource(R.drawable.table_style_row_juft)
                    txtKassaSana.setBackgroundResource(R.drawable.table_style_row_juft)
                    txtKassaJami.setBackgroundResource(R.drawable.table_style_row_juft)
                    txtKassaSom.setBackgroundResource(R.drawable.table_style_row_juft)
                    txtKassaDollor.setBackgroundResource(R.drawable.table_style_row_juft)
                    txtKassaDollorKursi.setBackgroundResource(R.drawable.table_style_row_juft)
                    txtKassaDollorSumda.setBackgroundResource(R.drawable.table_style_row_juft)
                    txtKassaBank.setBackgroundResource(R.drawable.table_style_row_juft)
                    actionLayout.setBackgroundResource(R.drawable.table_style_row_juft)
                }

            } else {
                holder.itemView.apply {
                    checkboxKassa.setBackgroundResource(R.drawable.table_style_rows_toq)
                    txtKassaOrderNumber.setBackgroundResource(R.drawable.table_style_rows_toq)
                    txtKassaIsm.setBackgroundResource(R.drawable.table_style_rows_toq)
                    txtKassaTuri.setBackgroundResource(R.drawable.table_style_rows_toq)
                    txtKassaSana.setBackgroundResource(R.drawable.table_style_rows_toq)
                    txtKassaJami.setBackgroundResource(R.drawable.table_style_rows_toq)
                    txtKassaSom.setBackgroundResource(R.drawable.table_style_rows_toq)
                    txtKassaDollor.setBackgroundResource(R.drawable.table_style_rows_toq)
                    txtKassaDollorKursi.setBackgroundResource(R.drawable.table_style_rows_toq)
                    txtKassaDollorSumda.setBackgroundResource(R.drawable.table_style_rows_toq)
                    txtKassaBank.setBackgroundResource(R.drawable.table_style_rows_toq)
                    actionLayout.setBackgroundResource(R.drawable.table_style_rows_toq)

                }
            }
            holder.itemView.apply {
                val singleItems = list[rowPosition - 1]
                txtKassaOrderNumber.text = rowPosition.toString()
                singleItems.apply {
                    txtKassaIsm.text = ism
                    txtKassaTuri.text = tur
                    txtKassaSana.text = sana
                    txtKassaJami.text = jami.toString()
                    txtKassaSom.text = som.toString()
                    txtKassaDollor.text = dollor.toString()
                    txtKassaDollorKursi.text = dollorKursi.toString()
                    txtKassaDollorSumda.text = dollorSumda.toString()
                    txtKassaBank.text = bank.toString()
                }
            }
        }
    }
}