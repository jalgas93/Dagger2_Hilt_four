package com.example.dagger2fourproject.domain.data

class DataState<out T>(
    val data: T? = null,
    val error: String? = null,
    val loading: Boolean = false
) {
    companion object {
        fun <T> success(
            data: T
        ): DataState<T> {
            return success(
                data = data
            )
        }

        fun <T> error(
            message: String
        ): DataState<T> {
            return error(
                message
            )
        }

        fun <T> loading(): DataState<T> = DataState(loading = false)
    }
}