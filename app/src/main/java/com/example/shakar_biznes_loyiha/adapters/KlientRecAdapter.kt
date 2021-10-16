package com.example.shakar_biznes_loyiha.adapters

import android.content.Context
import android.content.ContextWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.view.ContextThemeWrapper
import androidx.recyclerview.widget.RecyclerView
import com.example.shakar_biznes_loyiha.R
import com.example.shakar_biznes_loyiha.model.RecBoshSohifa
import com.example.shakar_biznes_loyiha.model.RecKlient
import kotlinx.android.synthetic.main.klient_recycler_item.view.*

class KlientRecAdapter(val context: Context) :
    RecyclerView.Adapter<KlientRecAdapter.MyViewHolder>() {
    var listener: OnClickItemListener? = null
    var list = emptyList<RecKlient>()

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layout = LayoutInflater.from(parent.context)
                val layoutInflater = layout.inflate(R.layout.klient_recycler_item, parent, false)
                return MyViewHolder(layoutInflater)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
        MyViewHolder.from(parent)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val rowPosition = holder.adapterPosition
        tableColor(holder)
        holder.itemView.actionLayout.setOnClickListener {
            //listener?.onClickItemListener(list[rowPosition - 1])
            Toast.makeText(context, rowPosition.toString(), Toast.LENGTH_SHORT).show()
            popupMenus(it)
            holder.itemView.setOnClickListener {

            }
        }
    }

    override fun getItemCount(): Int = list.size

    fun setDataList(dataList: List<RecKlient>) {
        this.list = dataList
        notifyDataSetChanged()
    }

    interface OnClickItemListener {
        fun onClickItemListener(data: RecKlient)
    }

    fun setOnItemClickListenr(onItemClickItemListener: OnClickItemListener) {
        this.listener = onItemClickItemListener
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

    fun tableColor(holder: MyViewHolder) {
        val rowPosition = holder.adapterPosition
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
            val singleItems = list[rowPosition - 1]
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
            holder.itemView.txtKlientIsm.text = singleItems.ism
            holder.itemView.txtKlientYakuniyXisob.text = singleItems.hisob.toString()
            holder.itemView.txtKlientPulOldiBerdi.text = singleItems.pulOldiBerdi.toString()
            holder.itemView.txtKlientYukOldiBerdi.text = singleItems.yukOldiBerdi.toString()
            holder.itemView.txtKlientZavod.text = singleItems.zavod.toString()
            holder.itemView.txtKlientAction.text = "Actions"
        }
    }
}