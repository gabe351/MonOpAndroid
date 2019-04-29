package com.gabe.monop.datasources.remotedatasource

import com.gabe.monop.datasources.BaseRemoteDataSource
import com.gabe.monop.model.InvestimentResponse

interface ConstructionRemoteDataSource {

    fun loadHighAndLow(callback: BaseRemoteDataSource.RemoteDataSourceCallback<InvestimentResponse>)
}