package com.gabe.monop.application.modules.search.searchByUF

import com.gabe.monop.model.Construction

class SearchByUFContracts {

    interface View {
        fun loadConstructions(constructions: List<Construction>)
    }

    interface Presenter {
        fun loadConstructions(uf: String)
    }

}