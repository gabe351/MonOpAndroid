package com.gabe.monop.application.modules.constructiondetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gabe.monop.R
import com.gabe.monop.model.Construction
import kotlinx.android.synthetic.main.activity_construction_detail.*

class ConstructionDetailActivity: AppCompatActivity() {

    companion object {
        const val CONSTRUCTION_OBJECT = "constructionObject"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_construction_detail)
        val actionBar = supportActionBar
        actionBar?.let {
            it.title = "Detalhe da obra"
        }

        setupText()
    }

    fun setupText() {
        val construction = intent.getSerializableExtra(CONSTRUCTION_OBJECT) as? Construction

        val title = construction?.title ?: ""
        val investment = construction?.totalInvestiment ?: "Não informado"
        val responsible = construction?.responsible ?: "Não informado"
        val responsibleCompany = construction?.responsibleCompany ?: "Não informado"
        val dateLimit = construction?.dateLimit ?: "Não informado"
        val ufs = construction?.ufs ?: "Não informado"
        val cities = construction?.cities ?: "Não informado"
        val observations = construction?.observation ?: "Não informado"

        constructionTitle.text = title
        constructionTotalInvestiment.text = "investimento total: R$ $investment"
        constructionResponsibleCompany.text = "Órgão responsável: $responsibleCompany"
        constructionResponsible.text = "Executores: $responsible"
        constructionDateLimit.text = "Data limite: $dateLimit"
        constructionUFs.text = "Estados onde a obra ocorre: $ufs"
        constructionCities.text = "Municipios: $cities"
        constructionObservations.text = "Observações $observations"
    }
}

