package com.example.demoappforkazanexpress.model.repos

import HistoryEntity
import com.example.demoappforkazanexpress.model.HistoryWebService
import com.example.demoappforkazanexpress.model.entitys.BaseHistoriesEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class WebDBHistoryRepoImpl(private val retrofit: Retrofit) : DBHistoryRepoInt {

    private val serviceInt: HistoryWebService by lazy { retrofit.create(HistoryWebService::class.java) }
    override fun getDBHistoryData(
        onSuccesses: (List<HistoryEntity>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        serviceInt.getHistoryFromServer().enqueue(object : Callback<BaseHistoriesEntity> {
            override fun onResponse(
                call: Call<BaseHistoriesEntity>,
                response: Response<BaseHistoriesEntity>
            ) {
                if (response.isSuccessful) {
                    onSuccesses(response.body()?.histories!!)
                } else {
                    onError(Throwable("App error ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<BaseHistoriesEntity>, t: Throwable) {
                onError(t)
            }

        })
    }
}