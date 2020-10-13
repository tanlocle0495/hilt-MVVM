package com.loc.lt.android.mvvm.ui.demo.viewmodel

import com.loc.lt.android.mvvm.data.remote.ApiService
import com.loc.lt.android.mvvm.model.User
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

interface DemoRepository {
    suspend fun getUser(): Response<List<User>>
}

@Singleton
class DemoRepositoryImp @Inject constructor(private val api: ApiService) :
    DemoRepository {
    override suspend fun getUser(): Response<List<User>> = api.getUsers()
}