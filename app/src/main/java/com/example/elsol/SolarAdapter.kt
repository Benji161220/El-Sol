package com.example.elsol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class SolarAdapter(
    private val solarList: MutableList<SolarItem>
) : RecyclerView.Adapter<SolarAdapter.SolarViewHolder>() {

    inner class SolarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewSolar: ImageView = itemView.findViewById(R.id.imageViewSolar)
        val toolbarSolar: Toolbar = itemView.findViewById(R.id.toolbarSolar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_solar, parent, false)
        return SolarViewHolder(view)
    }

    override fun onBindViewHolder(holder: SolarViewHolder, position: Int) {
        val item = solarList[position]


        holder.imageViewSolar.setImageResource(item.imageResId)
        holder.toolbarSolar.title = item.name


        holder.toolbarSolar.menu.clear()
        holder.toolbarSolar.inflateMenu(R.menu.menu_solar_item)
        holder.toolbarSolar.setOnMenuItemClickListener { menuItem ->
            val pos = holder.bindingAdapterPosition
            if (pos == RecyclerView.NO_POSITION) return@setOnMenuItemClickListener false

            when (menuItem.itemId) {
                R.id.action_copy -> {
                    val original = solarList[pos]
                    val copied = SolarItem("${original.name} (Copia)", original.imageResId)
                    solarList.add(pos + 1, copied)
                    notifyItemInserted(pos + 1)
                    true
                }
                R.id.action_delete -> {
                    solarList.removeAt(pos)
                    notifyItemRemoved(pos)
                    true
                }
                else -> true
            }
        }
    }

    override fun getItemCount(): Int = solarList.size
}