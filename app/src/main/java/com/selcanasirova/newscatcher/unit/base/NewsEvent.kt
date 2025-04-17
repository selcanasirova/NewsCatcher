package com.selcanasirova.newscatcher.unit.base

sealed class NewsEvent : UiEvent {
    data class ShowToast(val message: String) : NewsEvent()
}