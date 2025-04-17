package com.selcanasirova.newscatcher.unit.base

import com.selcanasirova.newscatcher.domain.model.NewsItem

data class NewsState(
    val isLoading: Boolean = false,
    val newsList: List<NewsItem> = emptyList(),
    val error: String = ""
): UiState