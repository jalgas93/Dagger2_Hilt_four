package com.example.dagger2fourproject.presentation.ui.first

import android.graphics.ColorSpace
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.dagger2fourproject.domain.model.Model
import com.example.dagger2fourproject.network.NetworkService
import com.example.dagger2fourproject.network.model.RetrofitModel
import com.example.dagger2fourproject.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class RecipeViewModel @ViewModelInject constructor(

    var repository: Repository,
    var networkService: NetworkService
):ViewModel() {
     private val muLiveData = MutableLiveData<RetrofitModel>()
     val live:LiveData<RetrofitModel> = muLiveData
//
//    fun c(){
//        viewModelScope.launch {
//            repository.a().collect {
//                muLiveData.value = it
//                Log.i("jalgas6",it.toString())
//
//            }
//
//            }
//        }
//    }


     fun jalgas (token:String,recipeId:Int){
         viewModelScope.launch {
            var a =   repository.RecipeRepos(token,recipeId)
             muLiveData.value = a
         }

    }

    //val liveData =
       // repository.execute(9, "Token 9c8b06d329136da358c2d00e76946b0111ce2c48").asLiveData()

    init {
        Log.i("jalgas4", muLiveData.toString())
    }
}



