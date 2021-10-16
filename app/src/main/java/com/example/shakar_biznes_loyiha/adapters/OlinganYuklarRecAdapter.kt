package com.example.shakar_biznes_loyiha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.databinding.OlinganYuklarRecItemBinding
import com.example.shakar_biznes_loyiha.model.RecOlinganYuk
import com.example.shakar_biznes_loyiha.model.SkladRec
import kotlinx.android.synthetic.main.olingan_yuklar_rec_item.view.*

class OlinganYuklarRecAdapter : RecyclerView.Adapter<OlinganYuklarRecAdapter.MyViewHolder>() {

    var list = emptyList<RecOlinganYuk>()

    inner class MyViewHolder(val binding: OlinganYuklarRecItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            OlinganYuklarRecItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        tableColorOlinganYuklar(holder)
    }

    override fun getItemCount(): Int = list.size

    fun setDataList(dataList: List<RecOlinganYuk>) {
        this.list = dataList
        notifyDataSetChanged()
    }

    fun tableColorOlinganYuklar(holder: MyViewHolder) {
        val rowPosition = holder.adapterPosition

        if (rowPosition == 0) {
            with(holder) {
                binding.apply {
                    txtOlinganYukOrderNumber.setBackgroundResource(R.drawable.table_style_header)
                    txtOlinganKlient.setBackgroundResource(R.drawable.table_style_header)
                    txtOlinganShakarTuri.setBackgroundResource(R.drawable.table_style_header)
                    txtOlinganSana.setBackgroundResource(R.drawable.table_style_header)
                    txtOlinganYukMiqdori.setBackgroundResource(R.drawable.table_style_header)
                    txtOlinganBirlikNarx.setBackgroundResource(R.drawable.table_style_header)
                    txtOlinganUmumiyNarx.setBackgroundResource(R.drawable.table_style_header)
                    actionLayout.setBackgroundResource(R.drawable.table_style_header)

                    txtOlinganYukOrderNumber.text = "#"
                    txtOlinganKlient.text = "Klient"
                    txtOlinganShakarTuri.text = "Shakar Turi"
                    txtOlinganSana.text = "Sana"
                    txtOlinganYukMiqdori.text = "Yuk miqdori"
                    txtOlinganBirlikNarx.text = "Birlik Narx"
                    txtOlinganUmumiyNarx.text = "Umumiy Narx"
                    actionTextview.text = "Actions"
                }
            }
        } else {
            holder.binding.actionTextview.visibility = View.GONE
            if (rowPosition % 2 == 0) {
                with(holder) {
                    binding.apply {
                        txtOlinganYukOrderNumber.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtOlinganKlient.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtOlinganShakarTuri.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtOlinganSana.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtOlinganYukMiqdori.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtOlinganBirlikNarx.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtOlinganUmumiyNarx.setBackgroundResource(R.drawable.table_style_row_juft)
                        actionLayout.setBackgroundResource(R.drawable.table_style_row_juft)
                    }
                }
            } else {
                with(holder) {
                    binding.apply {
                        txtOlinganYukOrderNumber.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtOlinganKlient.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtOlinganShakarTuri.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtOlinganSana.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtOlinganYukMiqdori.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtOlinganBirlikNarx.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtOlinganUmumiyNarx.setBackgroundResource(R.drawable.table_style_rows_toq)
                        actionLayout.setBackgroundResource(R.drawable.table_style_rows_toq)
                    }
                }
            }
            with(holder) {
                val singleItem = list[rowPosition - 1]
                binding.txtOlinganYukOrderNumber.text = rowPosition.toString()
                with(singleItem) {
                    binding.txtOlinganKlient.text = this.klient
                    binding.txtOlinganShakarTuri.text = this.shakarTuri
                    binding.txtOlinganSana.text = this.sana
                    binding.txtOlinganYukMiqdori.text = this.yukMiqdori.toString()
                    binding.txtOlinganBirlikNarx.text = this.birlikNarx.toString()
                    binding.txtOlinganUmumiyNarx.text = this.umumiyNarx.toString()
                }
            }
        }
    }
}