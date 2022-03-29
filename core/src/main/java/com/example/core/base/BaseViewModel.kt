package com.example.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


abstract class BaseViewModel : ViewModel() {
    private val isLoading = MutableLiveData<Boolean>()

    protected fun setLoading(loading: Boolean) {
        isLoading.postValue(loading)
    }

    fun isLoading(): LiveData<Boolean> = isLoading
}