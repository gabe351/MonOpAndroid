package com.gabe.monop.application.modules.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gabe.monop.R
import com.gabe.monop.application.modules.adapter.ConstructionAdapter
import com.gabe.monop.model.Construction
import kotlinx.android.synthetic.main.activity_search_by_text.*

class SearchByTextActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_by_text)

        val actionBar = supportActionBar
        actionBar?.let {
            it.title = "Buscar obras"
        }

        searchByTextRecyclerView.adapter = ConstructionAdapter(getFakeConstructions(), this)
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        searchByTextRecyclerView.layoutManager = layoutManager
    }

    private fun getFakeConstructions(): List<Construction> {
        return listOf(
            Construction("Obras"),
            Construction("Minha obra com grande titulo"),
            Construction("Terceira obra não finalizada"),
            Construction("É triste ver o dinheiro publico indo embora para o bolso de quem já é rico"),
            Construction("O pior de tudo é que a gente paga duas vezes por tudo, saúde, educação, segurança e eles ficam ricos"),
            Construction("Essa gente não quer nada, quer pagar sem precedente, o problema do imposto é que ele é cobra pelo impostor"),
            Construction("Frases"),
            Construction("Pequena obra"),
            Construction("Veremos o fim desta obra um dia"),
            Construction("Talvez ")
        )
    }
}