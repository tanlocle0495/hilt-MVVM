package com.loc.lt.android.mvvm.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.loc.lt.android.mvvm.ui.base.BaseViewModel
import com.loc.lt.android.mvvm.utils.security.SecurityUtils

class LoginViewModel @ViewModelInject constructor(
//    private val secure: SecurityUtils
) : BaseViewModel() {
    private val _passwordLiveData by lazy {
        MutableLiveData<String>()
    }
    private val passwordLiveData get() = _passwordLiveData

    fun setPassword(text: String) {
        _passwordLiveData.apply {
            value = text
        }
    }

    fun savePassword() {
        passwordLiveData.value?.let {
//            secure.storeDataExample(it)
        }
    }

}