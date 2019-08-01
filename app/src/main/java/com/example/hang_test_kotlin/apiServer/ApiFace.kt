package com.example.hang_test_kotlin.apiServer

import com.example.hang_test_kotlin.bean.DataBeen
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiFace {
    @GET("data/%E7%A6%8F%E5%88%A9/20/1")
    fun getUrl(): Observable<DataBeen>

    companion object {

        val url = "http://gank.io/api/"
    }

}
