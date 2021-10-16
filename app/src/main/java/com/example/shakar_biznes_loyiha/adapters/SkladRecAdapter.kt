package com.example.shakar_biznes_loyiha.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.databinding.SkladRecItemBinding
import com.example.shakar_biznes_loyiha.model.RecKassa
import com.example.shakar_biznes_loyiha.model.SkladRec

class SkladRecAdapter : RecyclerView.Adapter<SkladRecAdapter.MyViewHolder>() {

    var list = emptyList<SkladRec>()

    inner class MyViewHolder(val binding: SkladRecItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            SkladRecItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        tableColorSklad(holder)
    }

    override fun getItemCount(): Int = list.size
    fun setDataList(dataList: List<SkladRec>) {
        this.list = dataList
        notifyDataSetChanged()
    }

    fun tableColorSklad(holder: MyViewHolder) {
        val rowPosition = holder.adapterPosition
        if (rowPosition == 0) {
            with(holder) {
                binding.apply {
                    txtSkladOrderNumber.setBackgroundResource(R.drawable.table_style_header)
                    txtSkladShakarTuri.setBackgroundResource(R.drawable.table_style_header)
                    txtSkladQoldiqQop.setBackgroundResource(R.drawable.table_style_header)
                    txtSkladNarxi.setBackgroundResource(R.drawable.table_style_header)
                    txtSkladUmimirSumma.setBackgroundResource(R.drawable.table_style_header)
                    txtSkladOlindiQop.setBackgroundResource(R.drawable.table_style_header)
                    txtSkladSotildiQop.setBackgroundResource(R.drawable.table_style_header)
                    txtSkladBoshlangichMiqdori.setBackgroundResource(R.drawable.table_style_header)
                    skladActionLayout.setBackgroundResource(R.drawable.table_style_header)

                    txtSkladOrderNumber.text = "#"
                    txtSkladShakarTuri.text = "Shakar turi"
                    txtSkladQoldiqQop.text = "Qoldiq(Qop)"
                    txtSkladNarxi.text = "Narxi(1 qop)"
                    txtSkladUmimirSumma.text = "Umumiy Summa"
                    txtSkladOlindiQop.text = "Olindi(qop)"
                    txtSkladSotildiQop.text = "Sotildi(qop)"
                    txtSkladBoshlangichMiqdori.text = "Boshlang'ich miqdori"
                    actionTextview.text = "Actions"
                }
            }
        } else {
            holder.binding.actionTextview.visibility = View.GONE
            if (rowPosition % 2 == 0) {
                with(holder) {
                    binding.apply {
                        txtSkladOrderNumber.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtSkladShakarTuri.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtSkladQoldiqQop.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtSkladNarxi.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtSkladUmimirSumma.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtSkladOlindiQop.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtSkladSotildiQop.setBackgroundResource(R.drawable.table_style_row_juft)
                        txtSkladBoshlangichMiqdori.setBackgroundResource(R.drawable.table_style_row_juft)
                        skladActionLayout.setBackgroundResource(R.drawable.table_style_row_juft)
                    }
                }
            } else {
                with(holder) {
                    binding.apply {
                        txtSkladOrderNumber.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtSkladShakarTuri.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtSkladQoldiqQop.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtSkladNarxi.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtSkladUmimirSumma.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtSkladOlindiQop.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtSkladSotildiQop.setBackgroundResource(R.drawable.table_style_rows_toq)
                        txtSkladBoshlangichMiqdori.setBackgroundResource(R.drawable.table_style_rows_toq)
                        skladActionLayout.setBackgroundResource(R.drawable.table_style_rows_toq)
                    }
                }
            }
            with(holder) {
                val singleItem = list[rowPosition - 1]
                binding.txtSkladOrderNumber.text = rowPosition.toString()
                with(singleItem) {
                    binding.txtSkladShakarTuri.text = this.shakarTuri
                    binding.txtSkladQoldiqQop.text = this.qoldiqQop.toString()
                    binding.txtSkladNarxi.text = this.narx.toString()
                    binding.txtSkladUmimirSumma.text = this.ummumiySumma.toString()
                    binding.txtSkladOlindiQop.text = this.olindiQop.toString()
                    binding.txtSkladSotildiQop.text = this.sotildiQop.toString()
                    binding.txtSkladBoshlangichMiqdori.text = this.boshlangichMiqdoriQop.toString()
                }
            }
        }
    }
}