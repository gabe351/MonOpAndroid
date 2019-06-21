package com.gabe.monop.application.modules.search.searchByUF

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gabe.monop.R
import com.gabe.monop.application.modules.adapter.ConstructionAdapter
import com.gabe.monop.application.modules.search.SearchConstructionsContracts
import com.gabe.monop.application.modules.search.SearchConstructionsPresenter
import com.gabe.monop.application.modules.search.searchByText.SearchByTextActivity
import com.gabe.monop.model.Construction
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.android.synthetic.main.fragment_search.*

class SearchByUFFragment: Fragment(), SearchConstructionsContracts.View {

    private lateinit var searchByTextButton: Button
    private lateinit var ufSpinner: MaterialSpinner
    private lateinit var recyclerView: RecyclerView
    private lateinit var presenter: SearchConstructionsContracts.Presenter
    private lateinit var adapter: ConstructionAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_search, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = SearchConstructionsPresenter(this)

        recyclerView = searchUfRecycler

        adapter = ConstructionAdapter(emptyList(), context!!)

        recyclerView.adapter = adapter
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



        ufSpinner.setOnItemSelectedListener { _, position, _, _ ->
            val ufs = resources.getStringArray(R.array.ufs)

            val selectedUf = ufs.get(position)

            if (selectedUf.isNotBlank()) {
                adapter.reloadData(emptyList())
                presenter.loadConstructionsByUF(selectedUf)
            }
        }
    }

    override fun loadConstructions(constructions: List<Construction>) {
        adapter.reloadData(constructions)
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