package com.gabe.monop.application.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel<T>: ViewModel() {

    val successObserver   = MutableLiveData<T>()
    var emptyObserver     = MutableLiveData<String>()
    val errorObserver     = MutableLiveData<String>()
    val isLoadingObserver = MutableLiveData<Boolean>()

}