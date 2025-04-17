package com.selcanasirova.newscatcher.network.services

import com.selcanasirova.newscatcher.domain.model.News
import retrofit2.Response
import retrofit2.http.GET

interface NewsAPI {
    @GET("products")
    suspend fun getNews(): Response<News>
}