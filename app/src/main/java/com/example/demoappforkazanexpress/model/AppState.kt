package com.example.demoappforkazanexpress.model

import HistoryEntity
import WalletsEntity

sealed class AppState {
    data class SuccessWallets(val walletsEntityList: List<WalletsEntity>) : AppState()
    data class SuccessHistories(val historyEntityList: List<HistoryEntity>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}