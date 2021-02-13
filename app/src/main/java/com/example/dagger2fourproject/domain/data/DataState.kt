package com.example.dagger2fourproject.domain.data

sealed class DataState <out T> (
    val status : Status,
    val _data : T?,
    val message: String?
    ) {

    data class Success<out R>(val data : R) : DataState<R>(
        status = Status.SUCCESS,
        _data = data,
        message = null
    )
    data class Loading(val isLoading : Boolean) : DataState<Nothing>(
        status = Status.LOADING,
        _data = null,
        message = null
    )
    data class Error(val exception: String) : DataState<Nothing>(
        status = Status.ERROR,
        _data = null,
        message = exception
    )

}