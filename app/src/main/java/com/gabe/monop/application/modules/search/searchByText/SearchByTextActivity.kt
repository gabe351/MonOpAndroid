package com.gabe.monop.application.modules.search.searchByText

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gabe.monop.R
import com.gabe.monop.application.modules.adapter.ConstructionAdapter
import com.gabe.monop.application.modules.search.SearchConstructionsContracts
import com.gabe.monop.application.modules.search.SearchConstructionsPresenter
import com.gabe.monop.model.Construction
import kotlinx.android.synthetic.main.activity_search_by_text.*

class SearchByTextActivity: AppCompatActivity(), SearchConstructionsContracts.View {

    private lateinit var presenter: SearchConstructionsContracts.Presenter
    private lateinit var adapter: ConstructionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_by_text)

        presenter = SearchConstructionsPresenter(this)
        adapter = ConstructionAdapter(emptyList(), applicationContext)

        val actionBar = supportActionBar
        actionBar?.let {
            it.title = "Buscar obras"
        }

        constructionsSearchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { presenter.loadConstructionsByName(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })



        searchByTextRecyclerView.adapter = adapter
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        searchByTextRecyclerView.layoutManager = layoutManager
    }

    override fun loadConstructions(constructions: List<Construction>) {
        adapter.reloadData(constructions)
    }
}