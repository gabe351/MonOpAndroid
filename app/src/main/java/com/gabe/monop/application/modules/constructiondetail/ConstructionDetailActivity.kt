package com.gabe.monop.application.modules.constructiondetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gabe.monop.R
import kotlinx.android.synthetic.main.activity_construction_detail.*

class ConstructionDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_construction_detail)
        val ss: String = intent.getStringExtra("TEXT")

        tital.setText(ss)
    }
}