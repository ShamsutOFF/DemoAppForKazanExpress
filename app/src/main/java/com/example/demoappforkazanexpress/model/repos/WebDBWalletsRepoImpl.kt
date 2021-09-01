package com.example.demoappforkazanexpress.model.repos

import WalletsEntity
import com.example.demoappforkazanexpress.model.WalletsWebService
import com.example.demoappforkazanexpress.model.entitys.BaseWalletsEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class WebDBWalletsRepoImpl(private val retrofit: Retrofit) : DBWalletsRepoInt {

    private val serviceInt: WalletsWebService by lazy { retrofit.create(WalletsWebService::class.java) }
    override fun getDBWalletsData(
        onSuccesses: (List<WalletsEntity>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        serviceInt.getWalletsFromServer().enqueue(object : Callback<BaseWalletsEntity> {
            override fun onResponse(
                call: Call<BaseWalletsEntity>,
                response: Response<BaseWalletsEntity>
            ) {
                if (response.isSuccessful) {
                    onSuccesses(response.body()?.wallets!!)
                } else {
                    onError(Throwable("App error ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<BaseWalletsEntity>, t: Throwable) {
                onError(t)
            }
        })
    }
}