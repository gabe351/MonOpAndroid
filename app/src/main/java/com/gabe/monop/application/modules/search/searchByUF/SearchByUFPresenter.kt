package com.gabe.monop.application.modules.search.searchByUF

import com.gabe.monop.datasources.BaseApiDataSource
import com.gabe.monop.datasources.BaseRemoteDataSource
import com.gabe.monop.datasources.apidatasource.ConstructionApiDataSource
import com.gabe.monop.datasources.remotedatasource.ConstructionRemoteDataSourceImpl
import com.gabe.monop.model.Construction

class SearchByUFPresenter(private val view: SearchByUFContracts.View): SearchByUFContracts.Presenter {

    override fun loadConstructions(uf: String) {
        val remoteDataSource = ConstructionRemoteDataSourceImpl.getInstance(
            BaseApiDataSource.createService(
                ConstructionApiDataSource::class.java
            )
        )

        remoteDataSource.getConstructionsByUf(uf, object: BaseRemoteDataSource.RemoteDataSourceCallback<List<Construction>> {
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