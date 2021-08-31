package com.deneb.unsplashapp.core.platform

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deneb.unsplashapp.core.exception.Failure

abstract class BaseViewModel : ViewModel() {

    private var _failure: MutableLiveData<Failure> = MutableLiveData()
    val failure: MutableLiveData<Failure>
        get() = _failure

    protected fun handleFailure(failure: Failure) {
        this._failure.value = failure
    }

}