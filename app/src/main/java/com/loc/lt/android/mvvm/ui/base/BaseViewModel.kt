package com.loc.lt.android.mvvm.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _isLoading
    fun setLoading(isLoading: Boolean) {
        _isLoading.value = isLoading
    }
}