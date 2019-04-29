package com.gabe.monop.datasources.remotedatasource

import com.gabe.monop.datasources.BaseRemoteDataSource
import com.gabe.monop.model.Construction
import com.gabe.monop.model.ConstructionInvestimentResponse
import com.gabe.monop.model.ConstructionResponse
import com.gabe.monop.model.InvestimentResponse

interface ConstructionRemoteDataSource {

    fun loadHighAndLow(callback: BaseRemoteDataSource.RemoteDataSourceCallback<InvestimentResponse>)

    fun getConstructionsByUf(uf: String, callback: BaseRemoteDataSource.RemoteDataSourceCallback<List<Construction>>)
}