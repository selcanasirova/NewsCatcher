package com.selcanasirova.newscatcher.unit.base

import com.selcanasirova.newscatcher.unit.exceptions.NetworkException
import retrofit2.Response

abstract class BaseRepository {
    protected fun <T> handleResponse(response: Response<T>) : T? {
        return if (response.isSuccessful) {
            response.body()
        }else {
            when (response.code()){
                401 -> throw NetworkException.Unauthorized(response.message())
                404 -> throw NetworkException.NotFound(response.message())
                in 500..599 -> throw NetworkException.ServerError(response.code())
                else -> throw NetworkException.Error(response.message())
            }
        }
    }
}

