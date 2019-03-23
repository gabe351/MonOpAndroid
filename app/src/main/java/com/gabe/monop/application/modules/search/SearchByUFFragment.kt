package com.gabe.monop.application.modules.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gabe.monop.R
import com.gabe.monop.application.modules.adapter.ConstructionAdapter
import com.gabe.monop.model.Construction
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.android.synthetic.main.fragment_search.*

class SearchByUFFragment: Fragment() {

    private lateinit var searchByTextButton: Button
    private lateinit var ufSpinner: MaterialSpinner
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_search, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerView = search_uf_recycler
        recyclerView.adapter = context?.let { ConstructionAdapter(getFakeConstructions(), it) }
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        searchByTextButton = search_by_text_button
        ufSpinner = uf_spinner
        setSpinnerItems()

        searchByTextButton.setOnClickListener {
            activity?.let { fragmentActivity ->
                val intent = Intent(context, SearchByTextActivity::class.java)
                fragmentActivity.startActivity(intent)
            }
        }

        ufSpinner.setOnItemSelectedListener { view, position, id, item ->
            Toast.makeText(context, item.toString(), Toast.LENGTH_SHORT).show()
        }
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

    private fun setSpinnerItems() {
        ufSpinner.setItems(
            " ",
            "Acre",
            "Alagoas",
            "Amapá",
            "Amazonas",
            "Bahia",
            "Ceará",
            "Distrito Federal",
            "Espírito Santo",
            "Goiás",
            "Maranhão",
            "Mato Grosso",
            "Mato Grosso do Sul",
            "Minas Gerais",
            "Pará",
            "Paraíba",
            "Paraná",
            "Pernambuco",
            "Piauí",
            "Rio de Janeiro",
            "Rio Grande do Norte",
            "Rio Grande do Sul",
            "Rondônia",
            "Roraima",
            "Santa Catarina",
            "São Paulo",
            "Sergipe",
            "Tocantins"
        )
    }
}