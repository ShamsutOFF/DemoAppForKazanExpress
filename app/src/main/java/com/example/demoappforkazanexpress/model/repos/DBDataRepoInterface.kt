package com.example.demoappforkazanexpress.model.repos

import HistoryEntity
import WalletsEntity

interface DBHistoryRepoInt {
    fun getDBHistoryData(
        onSuccesses: (List<HistoryEntity>) -> Unit,
        onError: (Throwable) -> Unit
    )
}

interface DBWalletsRepoInt {
    fun getDBWalletsData(
        onSuccesses: (List<WalletsEntity>) -> Unit,
        onError: (Throwable) -> Unit
    )
}