package com.gabe.monop.datasources.remotedatasource

import android.annotation.SuppressLint
import androidx.annotation.NonNull
import com.gabe.monop.datasources.BaseRemoteDataSource
import com.gabe.monop.datasources.apidatasource.ConstructionApiDataSource
import com.gabe.monop.model.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ConstructionRemoteDataSourceImpl(private val apiDataSource: ConstructionApiDataSource): ConstructionRemoteDataSource {

    companion object {

        @Volatile
        private var INSTANCE: ConstructionRemoteDataSourceImpl? = null

        fun getInstance(@NonNull apiDataSource: ConstructionApiDataSource): ConstructionRemoteDataSourceImpl =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: ConstructionRemoteDataSourceImpl(apiDataSource).also {
                    INSTANCE = it
                }
            }
    }

    @SuppressLint("CheckResult")
    override fun loadHighAndLow(callback: BaseRemoteDataSource.RemoteDataSourceCallback<InvestimentResponse>) {
        apiDataSource.getInvestment()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.isLoading(true) }
            .doAfterTerminate { callback.isLoading(false) }
            .subscribe({
                    callback.onSuccess(it)
                },
                { throwable ->
                    callback.onError(throwable.localizedMessage)
                })
    }

    @SuppressLint("CheckResult")
    override fun getAllConstructions(callback: BaseRemoteDataSource.RemoteDataSourceCallback<List<Construction>>) {
        apiDataSource.getAllConstructions()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.isLoading(true) }
            .doAfterTerminate { callback.isLoading(false) }
            .subscribe({response ->
                print("Success")

                callback.onSuccess(response.Obras.map { Construction.buildFromResponse(it)})

            },
                { throwable ->
                    callback.onError(throwable.localizedMessage)
                })
    }

    @SuppressLint("CheckResult")
    override fun getConstructionsByUf(uf: String, callback: BaseRemoteDataSource.RemoteDataSourceCallback<List<Construction>>) {
        apiDataSource.getConstructionsByUf(uf)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.isLoading(true) }
            .doAfterTerminate { callback.isLoading(false) }
            .subscribe({response ->
                print("Success")

                callback.onSuccess(response.Obras.map { Construction.buildFromResponse(it)})

                },
                { throwable ->
                    callback.onError(throwable.localizedMessage)
                })
    }

    @SuppressLint("CheckResult")
    override fun getConstructionsByName(
        name: String,
        callback: BaseRemoteDataSource.RemoteDataSourceCallback<List<Construction>>) {
        apiDataSource.getConstructionsByName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { callback.isLoading(true) }
            .doAfterTerminate { callback.isLoading(false) }
            .subscribe({response ->
                print("Success")
                callback.onSuccess(response.Obras.map { Construction.buildFromResponse(it)})
            },
                { throwable ->
                    callback.onError(throwable.localizedMessage)
                })

    }
}

