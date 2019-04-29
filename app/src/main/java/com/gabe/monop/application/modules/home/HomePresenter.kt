package com.gabe.monop.application.modules.home

import com.gabe.monop.datasources.BaseApiDataSource
import com.gabe.monop.datasources.BaseRemoteDataSource
import com.gabe.monop.datasources.apidatasource.ConstructionApiDataSource
import com.gabe.monop.datasources.remotedatasource.ConstructionRemoteDataSourceImpl
import com.gabe.monop.model.Construction
import com.gabe.monop.model.InvestimentResponse

class HomePresenter(private val view: HomeContracts.View): HomeContracts.Presenter {

    override fun loadInvestments() {
        val remoteDataSource = ConstructionRemoteDataSourceImpl.getInstance(
            BaseApiDataSource.createService(
                ConstructionApiDataSource::class.java
            )
        )

        remoteDataSource.loadHighAndLow(object: BaseRemoteDataSource.RemoteDataSourceCallback<InvestimentResponse> {
            override fun isLoading(isLoading: Boolean) {
                print("loading")
            }

            override fun onSuccess(response: InvestimentResponse) {
                view.loadInvestments(Construction.buildFromInvestiment(response.max), Construction.buildFromInvestiment(response.min))
            }

            override fun onError(errorMessage: String) {
                print("error")
            }
        })
    }

    override fun loadConstructions() {
        val remoteDataSource = ConstructionRemoteDataSourceImpl.getInstance(
            BaseApiDataSource.createService(
                ConstructionApiDataSource::class.java
            )
        )

        remoteDataSource.getConstructionsByUf("AL", object: BaseRemoteDataSource.RemoteDataSourceCallback<List<Construction>> {
            override fun onSuccess(response: List<Construction>) {
                view.loadConstructions(response)
            }

            override fun onError(errorMessage: String) {
                print("Error")
            }

            override fun isLoading(isLoading: Boolean) {
                print("Loading")
            }
        })
    }
}