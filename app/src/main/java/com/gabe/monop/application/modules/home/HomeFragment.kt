package com.gabe.monop.application.modules.home

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import com.gabe.monop.R
import com.gabe.monop.application.modules.constructiondetail.ConstructionDetailActivity
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
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

        val yEntries = listOf(
            PieEntry(22f, "Em Execução"),
            PieEntry(45f, "Em Obras"),
            PieEntry(42f, "Em contratação"),
            PieEntry(52f, "Em licitação"),
            PieEntry(32f, "Concluido")
        )
        @ColorInt val mopa: Int = 0xFFFFA516.toInt();

        val colors: List<Int> = listOf(
            Color.GRAY,
            Color.YELLOW,
            mopa,
            Color.MAGENTA,
            Color.GREEN
        )



        val chart = pieChart
        chart.isRotationEnabled = true
        val description = Description()
        description.text = ""
        chart.description = description
        chart.holeRadius = 40f
        chart.setEntryLabelColor(Color.BLACK)
        chart.setTransparentCircleAlpha(0)
        chart.centerText = "Status das obras"
        chart.setCenterTextSize(10f)
        chart.setDrawEntryLabels(true)

        val dataSet = PieDataSet(yEntries, "Status das obras")
        dataSet.sliceSpace = 2f
        dataSet.valueTextSize = 12f




        dataSet.colors = colors

        val legend = chart.legend
        legend.form = Legend.LegendForm.CIRCLE

        val data = PieData(dataSet)
        chart.data = data
        chart.invalidate()
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