package com.gabe.monop.application.modules.home

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.gabe.monop.R
import com.gabe.monop.application.MonopApplication
import com.gabe.monop.application.modules.adapter.ConstructionAdapter
import com.gabe.monop.application.modules.constructiondetail.ConstructionDetailActivity
import com.gabe.monop.datasources.BaseApiDataSource.Companion.createService
import com.gabe.monop.datasources.BaseRemoteDataSource
import com.gabe.monop.datasources.apidatasource.ConstructionApiDataSource
import com.gabe.monop.datasources.remotedatasource.ConstructionRemoteDataSourceImpl
import com.gabe.monop.model.Construction
import com.gabe.monop.model.InvestimentResponse
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment: Fragment(), HomeContracts.View {

    private lateinit var homePresenter: HomeContracts.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_home, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        homePresenter = HomePresenter(this)

        homePresenter.loadInvestments()

        setupChart()

        setupRecyclerView()
    }

    @SuppressLint("SetTextI18n")
    override fun loadInvestments(max: Construction, min: Construction) {

        higherInvestmentButton.text = "Maior: R$ ${max.totalInvestment}"
        lowerInvestmentButton.text = "Menor: R$ ${min.totalInvestment}"

        val intent = Intent(context, ConstructionDetailActivity::class.java)

        lowerInvestmentButton.setOnClickListener {
            activity?.let { fragmentActivity ->
                intent.putExtra(ConstructionDetailActivity.CONSTRUCTION_OBJECT, min)
                fragmentActivity.startActivity(intent)
            }
        }

        higherInvestmentButton.setOnClickListener {
            activity?.let { fragmentActivity ->
                intent.putExtra(ConstructionDetailActivity.CONSTRUCTION_OBJECT, max)
                fragmentActivity.startActivity(intent)
            }
        }
    }

    private fun setupChart() {

        @ColorInt val executionColor: Int = 0xFFCCCCCC.toInt()
        @ColorInt val hiringColor: Int = 0xFFBF7C11.toInt()
        @ColorInt val inValuationColor: Int = 0xFFFFFF00.toInt()
        @ColorInt val inConstructionColor: Int = 0xFFFFA516.toInt()
        @ColorInt val completedColor: Int = 0xFF00FF00.toInt()

        val colors: List<Int> = listOf(
            inValuationColor,
            inConstructionColor,
            hiringColor,
            executionColor,
            completedColor
        )

        val entries = listOf(
            PieEntry(20f, "Em licitação"),
            PieEntry(5f, "Em contratação"),
            PieEntry(45f, "Em Obras"),
            PieEntry(35f, "Em Execução"),
            PieEntry(8f, "Concluido")
        )

        val description = Description()
        description.text = ""

        val dataSet = PieDataSet(entries, "Status das obras")
        dataSet.sliceSpace = 2f
        dataSet.valueTextSize = 12f
        dataSet.colors = colors

        val data = PieData(dataSet)

        val chart = pieChart
        chart.isRotationEnabled = false
        chart.description = description
        chart.holeRadius = 40f
        chart.setEntryLabelColor(Color.BLACK)
        chart.setTransparentCircleAlpha(0)
        chart.centerText = "Status das obras"
        chart.setCenterTextSize(10f)
        chart.setDrawEntryLabels(true)
        chart.data = data
        chart.invalidate()

        val legend = chart.legend
        legend.form = Legend.LegendForm.CIRCLE
    }


    private fun setupRecyclerView() {
        homeFragmentRecycler.adapter = context?.let { ConstructionAdapter(MonopApplication().getFakeConstructions(), it) }
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        homeFragmentRecycler.layoutManager = layoutManager
        homeFragmentRecycler.isNestedScrollingEnabled = false
    }
}