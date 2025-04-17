package com.selcanasirova.newscatcher.unit.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.selcanasirova.newscatcher.unit.exceptions.NetworkException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


abstract class BaseViewModel<State : UiState, Event : UiEvent> : ViewModel() {
    abstract val initialState: State

    private val _state = MutableStateFlow(initialState)

    val state: StateFlow<State> = _state.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun updateState(update: (State) -> State) {
        _state.value = update(_state.value)
    }

    abstract fun onEvent(event: Event)


    fun <T> execute(
        call: suspend () -> T,
        onSuccess: (T) -> Unit,
        onFail: ((Throwable) -> Unit)? = null
    ) {
        viewModelScope.launch{
            updateLoading(isLoading = true, showGenericLoading = true)
            withContext(Dispatchers.IO) {
                handleRequest(call, onSuccess, onFail, true)
            }
            updateLoading(isLoading = false, showGenericLoading = true)
        }
    }

    private suspend fun <T> handleRequest(
        call: suspend () -> T,
        onSuccess: (T) -> Unit,
        onFail: ((Throwable) -> Unit)? = null,
        showError: Boolean
    ) {
        try {
            val result = call()
            onSuccess(result)
        } catch (e: Throwable) {
            onFail?.invoke(e)
            if (showError) showErrorDialog(e)
        }
    }

    private suspend fun showErrorDialog(throwable: Throwable) {
        val errorMessage = when (throwable) {
            is NetworkException -> throwable.message ?: "A network error occurred."
            else -> throwable.localizedMessage ?: "An unexpected error occurred."
        }

    }

    private suspend fun updateLoading(isLoading: Boolean, showGenericLoading: Boolean) {
        _isLoading.value = isLoading
        if (showGenericLoading)
            _state.value = initialState
    }


}