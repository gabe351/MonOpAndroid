package com.gabe.monop.application.modules.search.searchByText

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gabe.monop.R
import com.gabe.monop.application.MonopApplication
import com.gabe.monop.application.modules.adapter.ConstructionAdapter
import com.gabe.monop.application.modules.search.searchByUF.SearchByUFContracts
import com.gabe.monop.application.modules.search.searchByUF.SearchByUFPresenter
import com.gabe.monop.model.Construction
import kotlinx.android.synthetic.main.activity_search_by_text.*

class SearchByTextActivity: AppCompatActivity(), SearchByUFContracts.View {

    private lateinit var presenter: SearchByUFContracts.Presenter
    private lateinit var adapter: ConstructionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_by_text)

        presenter = SearchByUFPresenter(this)
        adapter = ConstructionAdapter(emptyList(), applicationContext)
        presenter.loadConstructions("PE")

        val actionBar = supportActionBar
        actionBar?.let {
            it.title = "Buscar obras"
        }

        searchByTextRecyclerView.adapter = adapter
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        searchByTextRecyclerView.layoutManager = layoutManager
    }

    override fun loadConstructions(constructions: List<Construction>) {
        adapter.reloadData(constructions)
    }
}