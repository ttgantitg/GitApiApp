package com.ttgantitg.gitapiapp.data.api

import com.ttgantitg.gitapiapp.data.model.SearchModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApiService {
    @GET("users/{user}/repos")
    fun getUserRepos(@Path("user", encoded = true) user: String): Observable<List<SearchModel>>
}