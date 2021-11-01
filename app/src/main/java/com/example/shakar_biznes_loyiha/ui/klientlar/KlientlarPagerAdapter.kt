package com.example.shakar_biznes_loyiha.ui.klientlar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.view.ContextThemeWrapper
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.databinding.KlientRecyclerItemBinding
import com.example.shakar_biznes_loyiha.models.klient.Item
import kotlinx.android.synthetic.main.klient_recycler_item.view.*

class KlientlarPagerAdapter(val context: Context) :
    PagingDataAdapter<Item, KlientlarPagerAdapter.MyViewHolder>(diffCallback) {
    inner class MyViewHolder(binding: KlientRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        tableColor(holder,position)
        val rowPosition = holder.adapterPosition
        holder.itemView.actionLayout.setOnClickListener {
            //listener?.onClickItemListener(list[rowPosition - 1])
            Toast.makeText(context, rowPosition.toString(), Toast.LENGTH_SHORT).show()
            popupMenus(it)
            holder.itemView.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            KlientRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem == newItem
            }

        }
    }

    fun popupMenus(v: View) {
        val ctw: ContextThemeWrapper = ContextThemeWrapper(context, R.style.CustomPopupTheme)
        val popupMenus = PopupMenu(ctw, v)
        popupMenus.inflate(R.menu.pup_up_menu)
        popupMenus.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.btnKorish -> {
                    Toast.makeText(context, "ko'rish", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.btnTahrirlash -> {
                    Toast.makeText(context, "tahrirlash", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    true
                }
            }
        }
        popupMenus.show()
        val popup = PopupMenu::class.java.getDeclaredField("mPopup")
        popup.isAccessible = true
        val menu = popup.get(popupMenus)
        menu.javaClass.getDeclaredMethod("setForceShowIcon", Boolean::class.java)
            .invoke(menu, true)
    }

    fun tableColor(holder: MyViewHolder, position: Int) {

        val rowPosition = holder.bindingAdapterPosition
        if (rowPosition == 0) {
            holder.itemView.txtKlientOrderNumber.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.txtKlientIsm.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.txtKlientYakuniyXisob.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.txtKlientPulOldiBerdi.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.txtKlientYukOldiBerdi.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.txtKlientZavod.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.actionLayout.setBackgroundResource(R.drawable.table_style_header)
            holder.itemView.img_down.visibility = View.INVISIBLE
            holder.itemView.txtKlientOrderNumber.text = "#"
            holder.itemView.txtKlientIsm.text = "Ism"
            holder.itemView.txtKlientYakuniyXisob.text = "Xisob"
            holder.itemView.txtKlientPulOldiBerdi.text = "Pul oldi berdi"
            holder.itemView.txtKlientYukOldiBerdi.text = "Yuk oldi berdi"
            holder.itemView.txtKlientZavod.text = "Zavod"
            holder.itemView.txtKlientAction.text = "Actions"
        } else {
            val currentItem = getItem(position - 1)
            if (rowPosition % 2 == 0) {
                holder.itemView.txtKlientOrderNumber.setBackgroundResource(R.drawable.table_style_row_juft)
                holder.itemView.txtKlientIsm.setBackgroundResource(R.drawable.table_style_row_juft)
                holder.itemView.txtKlientYakuniyXisob.setBackgroundResource(R.drawable.table_style_row_juft)
                holder.itemView.txtKlientPulOldiBerdi.setBackgroundResource(R.drawable.table_style_row_juft)
                holder.itemView.txtKlientYukOldiBerdi.setBackgroundResource(R.drawable.table_style_row_juft)
                holder.itemView.txtKlientZavod.setBackgroundResource(R.drawable.table_style_row_juft)
                holder.itemView.actionLayout.setBackgroundResource(R.drawable.table_style_row_juft)
            } else {
                holder.itemView.txtKlientOrderNumber.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.txtKlientIsm.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.txtKlientOrderNumber.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.txtKlientYakuniyXisob.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.txtKlientPulOldiBerdi.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.txtKlientYukOldiBerdi.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.txtKlientZavod.setBackgroundResource(R.drawable.table_style_rows_toq)
                holder.itemView.actionLayout.setBackgroundResource(R.drawable.table_style_rows_toq)
            }
            holder.itemView.txtKlientOrderNumber.text = rowPosition.toString()
            holder.itemView.txtKlientIsm.text = currentItem?.name
            holder.itemView.txtKlientYakuniyXisob.text = currentItem?.yakuniyHisob.toString()
            holder.itemView.txtKlientPulOldiBerdi.text = currentItem?.pulOldiBerdi.toString()
            holder.itemView.txtKlientYukOldiBerdi.text = currentItem?.yukOldiBerdi.toString()
            holder.itemView.txtKlientZavod.text = currentItem?.typeName
            holder.itemView.txtKlientAction.text = "Actions"
        }
    }
}