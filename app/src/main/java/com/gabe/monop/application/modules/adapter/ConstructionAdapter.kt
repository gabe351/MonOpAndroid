package com.gabe.monop.application.modules.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.gabe.monop.R
import com.gabe.monop.application.modules.constructiondetail.ConstructionDetailActivity
import com.gabe.monop.model.Construction
import io.reactivex.CompletableOnSubscribe
import kotlinx.android.synthetic.main.construction_cell.view.*

class ConstructionAdapter(private var constructions: List<Construction>,
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

        holder.card.setOnClickListener {
            val intent = Intent(context, ConstructionDetailActivity::class.java)
            intent.putExtra(ConstructionDetailActivity.CONSTRUCTION_OBJECT, construction)
            context.startActivity(intent)
        }

        holder.title.text = construction.title
    }

    fun reloadData(constructions: List<Construction>) {
        this.constructions = constructions
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card: CardView = itemView.construction_cell_card_view
        val title: TextView = itemView.construction_cell_title_text_view

    }
}

