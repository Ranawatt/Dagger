package com.example.dagger_hilt.data.api

import com.example.dagger_hilt.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers() : Response<List<User>>
}