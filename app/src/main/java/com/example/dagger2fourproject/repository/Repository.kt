package com.example.dagger2fourproject.repository

import android.util.Log
import com.example.dagger2fourproject.domain.data.DataState
import com.example.dagger2fourproject.domain.model.Model
import com.example.dagger2fourproject.network.NetworkService
import com.example.dagger2fourproject.network.model.RetrofitMapper
import com.example.dagger2fourproject.network.model.RetrofitModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class Repository @Inject constructor(
    private val networkService: NetworkService,
    private val retrofitMapper: RetrofitMapper
) {
    suspend fun RecipeRepos(token:String,recipe:Int) = networkService.getRecipe(token,recipe)

}


//    fun get():Flow<List<Model>> = flow {
//        networkService.getRecipe().map {
//          retrofitMapper.mapToDomainModel(it)
//        }
//    }



//    fun a():Flow<List<Model>>{
//        return flow {
//            val b = networkService.getRecipe("Token 9c8b06d329136da358c2d00e76946b0111ce2c48",9)
//                .map { retrofitModel ->
//                  retrofitMapper.mapToDomainModel(retrofitModel)
//                }
//
//            emit(b)
//        }.flowOn(Dispatchers.IO)
//    }
//   fun get2() = networkService.getRecipe("Token 9c8b06d329136da358c2d00e76946b0111ce2c48",9).map {
//       Log.i("jalgas4",it.toString())
//        it.map { retrofitModel ->
//            Log.i("jalgas5",retrofitModel.title.toString())
//            retrofitMapper.mapToDomainModel(retrofitModel)
//        }
//    }


//    fun execute(
//        recipeId: Int,
//        token: String
//    ): Flow<DataState<Model>> = flow {
//        try {
//
//            emit(DataState.loading())
//            delay(1000)
//
//            var recipe = getRecipeFromNetwork(token, recipeId)
//            if (recipe != null) {
//                emit(DataState.success(recipe))
//                Log.i("jalgas1", recipe.title.toString())
//            }
//
//
//        } catch (e: Exception) {
//            emit(DataState.error<Model>(e.message ?: "Unknown error"))
//        }
//
//    }
//      private  suspend fun getRecipeFromNetwork(token: String, recipeId: Int): Model {
//            return retrofitMapper.mapToDomainModel(networkService.getRecipe(token, recipeId))
//
//
//        }



