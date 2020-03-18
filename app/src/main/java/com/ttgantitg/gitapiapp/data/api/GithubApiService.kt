package com.ttgantitg.gitapiapp.data.api

import com.ttgantitg.gitapiapp.data.model.UserRepo
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {

    @GET("users/{user}/repos")
    fun search(@Path("user", encoded = true) user: String): Observable<List<UserRepo>>

    companion object Factory {
        fun create(): GithubApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build()

            return retrofit.create(GithubApiService::class.java)
        }
    }
}