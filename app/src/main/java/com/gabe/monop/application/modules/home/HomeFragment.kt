package com.gabe.monop.application.modules.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.gabe.monop.R
import com.gabe.monop.application.modules.constructiondetail.ConstructionDetailActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment() {

    private lateinit var higherInvestmentButton: Button
    private lateinit var lowerInvestmentButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_home, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lowerInvestmentButton = lower_investment_button
        higherInvestmentButton = higher_investment_button

        goToConstructionDetail()
    }

    private fun goToConstructionDetail() {
        val intent = Intent(context, ConstructionDetailActivity::class.java)

        lowerInvestmentButton.setOnClickListener {
            activity?.let { fragmentActivity ->
                intent.putExtra("TEXT", "MENOR")
                fragmentActivity.startActivity(intent)
            }
        }

        higherInvestmentButton.setOnClickListener {
            activity?.let { fragmentActivity ->
                intent.putExtra("TEXT", "MAIOR")
                fragmentActivity.startActivity(intent)
            }
        }
    }
}