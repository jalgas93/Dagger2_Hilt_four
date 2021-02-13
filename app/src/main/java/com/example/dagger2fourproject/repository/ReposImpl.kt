package com.example.dagger2fourproject.repository

import com.example.dagger2fourproject.network.NetworkService
import com.example.dagger2fourproject.network.model.RetrofitModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ReposImpl @Inject constructor(
    var networkService: NetworkService
):Repository{
    override fun getRecipe(token: String, recipeId: Int): Flow<RetrofitModel> {
        return flow {
            var a = networkService.getRecipe(token,recipeId)
            emit(a)
        }.flowOn(Dispatchers.IO)

    }
}