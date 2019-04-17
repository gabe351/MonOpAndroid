package com.gabe.monop.application.modules.search.searchByText

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gabe.monop.R
import com.gabe.monop.application.MonopApplication
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

        searchByTextRecyclerView.adapter = ConstructionAdapter(MonopApplication().getFakeConstructions(), this)
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        searchByTextRecyclerView.layoutManager = layoutManager
    }
}