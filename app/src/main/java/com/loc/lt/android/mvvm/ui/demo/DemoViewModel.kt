package com.loc.lt.android.mvvm.ui.demo

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.loc.lt.android.mvvm.model.User
import com.loc.lt.android.mvvm.ui.base.BaseViewModel
import com.loc.lt.android.mvvm.utils.NetworkHelper
import com.loc.lt.android.mvvm.utils.Resource
import kotlinx.coroutines.launch


class DemoViewModel @ViewModelInject constructor(
    private val repository: DemoRepositoryImp,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {
    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>> get() = _users

    /// get data when init
    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                repository.getUser().let {
                    if (it.isSuccessful) {
                        _users.postValue(Resource.success(it.body()))
                    } else _users.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _users.postValue(Resource.error("No internet connection", null))
        }
    }


}