package com.gabe.monop.datasources.apidatasource

import com.gabe.monop.model.InvestimentResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ConstructionApiDataSource {

    @GET("http://monop.com.br/gerenciador-de-obras/obras/get_investment")
    fun getInvestment() : Observable<InvestimentResponse>

}