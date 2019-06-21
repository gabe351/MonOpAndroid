package com.gabe.monop.application.modules.search

import com.gabe.monop.model.Construction

class SearchConstructionsContracts {

    interface View {
        fun loadConstructions(constructions: List<Construction>)
    }

    interface Presenter {
        fun loadConstructionsByUF(filter: String)
        fun loadConstructionsByName(filter: String)
    }

}