package com.gabe.monop.datasources.apidatasource

import com.gabe.monop.model.ConstructionResponse
import com.gabe.monop.model.InvestimentResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ConstructionApiDataSource {

    @GET("http://monop.com.br/gerenciador-de-obras/obras/get_investment")
    fun getInvestment() : Observable<InvestimentResponse>

    @GET("http://monop.com.br/gerenciador-de-obras/obras/index/sig_uf:{uf}")
    fun getConstructionsByUf(@Path("uf")uf: String): Observable<List<ConstructionResponse>>

}