package com.example.dagger2fourproject.network

import com.example.dagger2fourproject.network.model.RetrofitModel
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetworkService {

    @GET("get")
     suspend fun getRecipe(
        @Header("Authorization") token: String,
        @Query("id") id: Int
    ): RetrofitModel
//
//    @GET("get")
//    suspend fun getRecipe(
//        @Header("Authorization") token: String,
//        @Query("id") id: Int
//    ): List<RetrofitModel>
}