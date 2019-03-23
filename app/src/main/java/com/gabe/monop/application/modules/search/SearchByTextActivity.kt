package com.gabe.monop.application.modules.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gabe.monop.R

class SearchByTextActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_by_text)

        val actionBar = supportActionBar
        actionBar?.let {
            it.title = "Buscar obras"
        }
    }
}