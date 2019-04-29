package com.gabe.monop.application.modules.home

import com.gabe.monop.model.Construction

class HomeContracts {

    interface View {
        fun loadInvestments(max: Construction, min: Construction)
        fun loadConstructions(construction: List<Construction>)
    }

    interface Presenter {
        fun loadInvestments()
        fun loadConstructions()
    }
}