package com.gabe.monop.application.modules.search

import com.gabe.monop.datasources.BaseApiDataSource
import com.gabe.monop.datasources.BaseRemoteDataSource
import com.gabe.monop.datasources.apidatasource.ConstructionApiDataSource
import com.gabe.monop.datasources.remotedatasource.ConstructionRemoteDataSourceImpl
import com.gabe.monop.model.Construction

class SearchConstructionsPresenter(private val view: SearchConstructionsContracts.View):
    SearchConstructionsContracts.Presenter {

    override fun loadConstructionsByUF(filter: String) {
        val remoteDataSource = ConstructionRemoteDataSourceImpl.getInstance(
            BaseApiDataSource.createService(
                ConstructionApiDataSource::class.java
            )
        )

        remoteDataSource.getConstructionsByUf(filter, object: BaseRemoteDataSource.RemoteDataSourceCallback<List<Construction>> {
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

    override fun loadConstructionsByName(filter: String) {
        val remoteDataSource = ConstructionRemoteDataSourceImpl.getInstance(
            BaseApiDataSource.createService(
                ConstructionApiDataSource::class.java
            )
        )

        remoteDataSource.getConstructionsByName(filter, object: BaseRemoteDataSource.RemoteDataSourceCallback<List<Construction>> {
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