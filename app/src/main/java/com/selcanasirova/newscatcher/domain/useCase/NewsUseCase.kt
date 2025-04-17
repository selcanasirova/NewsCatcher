package com.selcanasirova.newscatcher.domain.useCase

import com.selcanasirova.newscatcher.domain.model.News
import com.selcanasirova.newscatcher.domain.repository.NewsRepository
import com.selcanasirova.newscatcher.unit.base.BaseUseCase
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class NewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) : BaseUseCase<Unit, News?>() {

    override suspend fun onExecute(
        params: Unit?,
        scope: CoroutineScope
    ): News? {
        return newsRepository.getAllNews()
    }
}
