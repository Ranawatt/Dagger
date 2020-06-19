package com.example.dagger_hilt.data.repository

import com.example.dagger_hilt.data.api.ApiHelper
import com.example.dagger_hilt.data.model.User
import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper){

    suspend fun getUsers() : Response<List<User>> {
        return apiHelper.getUsers()
    }
}