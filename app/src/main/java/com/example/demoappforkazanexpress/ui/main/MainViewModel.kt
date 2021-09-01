package com.example.demoappforkazanexpress.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoappforkazanexpress.model.AppState
import com.example.demoappforkazanexpress.model.MyApplication
import com.example.demoappforkazanexpress.model.repos.DBHistoryRepoInt
import com.example.demoappforkazanexpress.model.repos.DBWalletsRepoInt
import com.example.demoappforkazanexpress.model.repos.WebDBHistoryRepoImpl
import com.example.demoappforkazanexpress.model.repos.WebDBWalletsRepoImpl

class MainViewModel(
    val dataLoadingLiveData: MutableLiveData<AppState> = MutableLiveData()
) : ViewModel() {
    private lateinit var dataBaseDBHistoryRepoInt: DBHistoryRepoInt
    private lateinit var dataBaseDBWalletsRepoInt: DBWalletsRepoInt

    fun loadHistoryListFromServer(){
        dataLoadingLiveData.value = AppState.Loading
        dataBaseDBHistoryRepoInt = WebDBHistoryRepoImpl(MyApplication().retrofit)
        with(dataBaseDBHistoryRepoInt){
            getDBHistoryData({
                dataLoadingLiveData.value = AppState.SuccessHistories(it)
            },{
                dataLoadingLiveData.value = AppState.Error(it)
            })
        }
    }

    fun loadWalletsListFromServer(){
        dataLoadingLiveData.value = AppState.Loading
        dataBaseDBWalletsRepoInt = WebDBWalletsRepoImpl(MyApplication().retrofit)
        with(dataBaseDBWalletsRepoInt){
            getDBWalletsData({
                dataLoadingLiveData.value = AppState.SuccessWallets(it)
            },{
                dataLoadingLiveData.value = AppState.Error(it)
            })
        }
    }
}