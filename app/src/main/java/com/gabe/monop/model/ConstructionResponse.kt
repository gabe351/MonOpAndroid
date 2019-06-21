package com.gabe.monop.model


data class ConstructionListResponse(val Obras: List<ConstructionResponse>)

data class ConstructionResponse(val id: Int,
                                val tipo_id: Int,
                                val nome: String,
                                val total_investido: Float,
                                val uf: String,
                                val municipios: String,
                                val executor: String,
                                val estagio_id: Int,
                                val monitorador: String,
                                val data_ciclo: String,
                                val data_selecao: String,
                                val data_conclusao_revisada: String,
                                val longitude: String,
                                val latitude: String,
                                val emblematica: String,
                                val observacao: String,
                                val estagio: EstagioResponse,
                                val tipo: TipoResponse)

class EstagioResponse (
    val id: Int,
    val nome: String,
    val descricao: String
)

class TipoResponse (
    val id: Int,
    val nome: String,
    val subeixo: String
)