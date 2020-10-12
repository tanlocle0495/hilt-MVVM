package com.loc.lt.android.mvvm.data.remote

import com.loc.lt.android.mvvm.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}