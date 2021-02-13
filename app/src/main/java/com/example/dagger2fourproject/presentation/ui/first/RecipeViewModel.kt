package com.example.dagger2fourproject.presentation.ui.first

import android.graphics.ColorSpace
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
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
    var networkService: NetworkService
):ViewModel() {
     private val muLiveData = MutableLiveData<DataState<RetrofitModel>>()
     val live:LiveData<DataState<RetrofitModel>> = muLiveData

    fun jalgas(token:String,recipe:Int){
        viewModelScope.launch {
            repository.getRecipe(token, recipe)
                .onStart {
                 muLiveData.postValue(DataState.Loading(true))
                }
                .catch {
                    it.message?.let {
                        muLiveData.postValue(DataState.Error(it))
                    }

                }.collect{
                    muLiveData.postValue(DataState.Success(it))
                    Log.i("jalgas7",it.title.toString())

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







