package com.gabe.monop.application.modules.search

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.gabe.monop.R
import com.jaredrummler.materialspinner.MaterialSpinner
import kotlinx.android.synthetic.main.fragment_search.*

class SearchByUFFragment: Fragment() {

    private lateinit var searchByTextButton: Button
    private lateinit var ufSpinner: MaterialSpinner

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_search, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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