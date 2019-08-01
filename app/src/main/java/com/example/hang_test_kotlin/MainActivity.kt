package com.example.hang_test_kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.hang_test_kotlin.adapters.MyAdapter
import com.example.hang_test_kotlin.apiServer.ApiFace
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }



    private fun initView() {
        mtb.setOnClickListener {
            val retrofit = Retrofit.Builder()
                .baseUrl(ApiFace.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
            val apiFace = retrofit.create(ApiFace::class.java)
            val data = apiFace.getUrl()
            data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer {t->
                        val results = t.results
                    val adapter = MyAdapter(results!!, this)
                    rec.layoutManager= LinearLayoutManager(this)
                    rec.adapter=adapter
                })
        }


    }

}

