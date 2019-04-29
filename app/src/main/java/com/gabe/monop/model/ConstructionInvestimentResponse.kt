package com.gabe.monop.model

data class ConstructionInvestimentResponse(val id_empreendimento: String,
                                           val id_digs: String,
                                           val titulo: String,
                                           val investimento_total: String,
                                           val sig_uf: String,
                                           val txt_municipios: String,
                                           val txt_executores: String,
                                           val dsc_orgao: String,
                                           val idn_estagio: String,
                                           val dat_ciclo: String,
                                           val dat_selecao: String,
                                           val dat_conclusao_revisada: String,
                                           val obra_latitude: String,
                                           val obra_longitude: String,
                                           val emblematica: String,
                                           val observacao: String)