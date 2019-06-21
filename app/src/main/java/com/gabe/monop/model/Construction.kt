package com.gabe.monop.model

import java.io.Serializable

class Construction(val title: String?,
                   val totalInvestment: String?,
                   val responsible: String?,
                   val responsibleCompany: String?,
                   val dateLimit: String?,
                   val ufs: String?,
                   val cities: String?,
                   val observation: String?): Serializable {

    companion object  {
        fun buildFromResponse(response: ConstructionResponse) : Construction =
            Construction(
                response.nome,
                "${response.total_investido}",
                response.executor,
                response.monitorador,
                response.data_conclusao_revisada,
                response.uf,
                response.municipios,
                response.observacao)

        fun buildFromInvestiment(response: ConstructionInvestimentResponse): Construction =
            Construction(
                response.titulo,
                response.investimento_total,
                response.txt_executores,
                response.dsc_orgao,
                response.dat_conclusao_revisada,
                response.sig_uf,
                response.txt_municipios,
                response.observacao)
    }
}
