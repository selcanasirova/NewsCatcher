package com.selcanasirova.newscatcher.domain.repository

import com.selcanasirova.newscatcher.network.services.NewsAPI
import com.selcanasirova.newscatcher.unit.base.BaseRepository
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsAPI: NewsAPI
): BaseRepository() {
    suspend fun getAllNews() = handleResponse(newsAPI.getNews())
}