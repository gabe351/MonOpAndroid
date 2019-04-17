package com.gabe.monop.model

import java.io.Serializable

class Construction(val title: String,
                   val totalInvestiment: String,
                   val responsible: String,
                   val responsibleCompany: String,
                   val dateLimit: String,
                   val ufs: String,
                   val cities: String,
                   val observation: String): Serializable {

    fun buildFromResponse(response: ConstructionResponse) : Construction {
        return Construction(
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
