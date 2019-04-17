package com.gabe.monop.model

data class ConstructionResponse(val idn_empreendimento: String,
                                val id_digs: IdDigsResponse,
                                val titulo: String,
                                val investimento_total: String,
                                val sig_uf: String,
                                val txt_municipios: String,
                                val txt_executores: String,
                                val dsc_orgao: String,
                                val id_estagio: IdnEstagioResponse,
                                val dat_ciclo: String,
                                val dat_selecao: String,
                                val dat_conclusao_revisada: String,
                                val obra_latitude: String,
                                val obra_longitude: String,
                                val emblematica: String,
                                val observacao: String)