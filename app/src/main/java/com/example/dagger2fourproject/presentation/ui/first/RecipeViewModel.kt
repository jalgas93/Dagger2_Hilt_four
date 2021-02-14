package com.example.dagger2fourproject.presentation.ui.first

import android.graphics.ColorSpace
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.dagger2fourproject.cache.RoomServiceDao
import com.example.dagger2fourproject.domain.data.DataState
import com.example.dagger2fourproject.domain.model.Model
import com.example.dagger2fourproject.network.NetworkService
import com.example.dagger2fourproject.network.model.RetrofitModel
import com.example.dagger2fourproject.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class RecipeViewModel @ViewModelInject constructor(

    var repository: Repository,
    var roomServiceDao: RoomServiceDao,
    var networkService: NetworkService
):ViewModel() {

    var jalgas = roomServiceDao.getRecipeByIdLiveData(9)
//    private val roomMutableLiveData = MutableLiveData<List<Model>>()
//    val liveData:LiveData<List<Model>> = roomMutableLiveData
//         fun jalgas(recipe: Int){
//             viewModelScope.launch {
//                 var jalgas = roomServiceDao.getRecipeByIdLiveData(recipe)
//                 liveData.value = jalgas
//
//
//             }
//         }
     private val muLiveData = MutableLiveData<DataState<List<Model>>>()
     val live:LiveData<DataState<List<Model>>>  = muLiveData

    //var list:MutableLiveData<Model> = MutableLiveData()

    fun jalgas(token:String,recipe:Int){
        viewModelScope.launch {
            repository.getRecipe(token, recipe)
                .onStart {
                 muLiveData.value = DataState.Loading(true)
                }
                .catch {
                    it.message?.let {
                        muLiveData.value = DataState.Error(it)
                    }

                }.collect{
                    muLiveData.value = it
                Log.i("jalgas7",it.toString())
                }

        }

        }
    }























//     fun jalgas (token:String,recipeId:Int){
//         viewModelScope.launch {
//            var a =   repository.RecipeRepos(token,recipeId)
//             muLiveData.value = a
//         }
//
//    }

    //val liveData =
       // repository.execute(9, "Token 9c8b06d329136da358c2d00e76946b0111ce2c48").asLiveData()







