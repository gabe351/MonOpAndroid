package com.gabe.monop.application.modules.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.gabe.monop.R
import com.gabe.monop.model.Construction
import kotlinx.android.synthetic.main.construction_cell.view.*

class ConstructionAdapter(private val constructions: List<Construction>,
                          private val context: Context): Adapter<ConstructionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.construction_cell, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return constructions.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val construction = constructions[position]
        holder.title.text = construction.title
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.construction_cell_title_text_view
    }
}

