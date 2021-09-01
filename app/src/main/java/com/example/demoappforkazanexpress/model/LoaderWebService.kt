package com.example.demoappforkazanexpress.model

import com.example.demoappforkazanexpress.model.entitys.BaseHistoriesEntity
import com.example.demoappforkazanexpress.model.entitys.BaseWalletsEntity
import retrofit2.Call
import retrofit2.http.GET

interface HistoryWebService {
    @GET("histories")
    fun getHistoryFromServer(): Call<BaseHistoriesEntity>
}

interface WalletsWebService {
    @GET("wallets")
    fun getWalletsFromServer(): Call<BaseWalletsEntity>
}