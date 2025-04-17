package com.selcanasirova.newscatcher.domain.viewModel

import androidx.lifecycle.viewModelScope
import com.selcanasirova.newscatcher.domain.useCase.NewsUseCase
import com.selcanasirova.newscatcher.unit.base.BaseViewModel
import com.selcanasirova.newscatcher.unit.base.NewsEvent
import com.selcanasirova.newscatcher.unit.base.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getLatestNewsUseCase: NewsUseCase
) : BaseViewModel<NewsState, NewsEvent>() {

    override val initialState: NewsState
        get() = NewsState()

    override fun onEvent(event: NewsEvent) {
        when (event) {
            is NewsEvent.ShowToast -> getAllNews()
        }
    }

    private fun getAllNews() {
        getLatestNewsUseCase(
            scope = viewModelScope,
            params = Unit,
            onSuccess = { result ->
                updateState { it.copy(newsList = result ?: emptyList()) }
            },
            onFailure = { error ->
                updateState {
                    it.copy(error = error.localizedMessage ?: "Xəta baş verdi")
                }
            }
        )
    }
}
