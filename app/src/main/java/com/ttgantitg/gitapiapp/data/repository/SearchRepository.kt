package com.ttgantitg.gitapiapp.data.repository

import com.ttgantitg.gitapiapp.data.api.GithubApiService
import com.ttgantitg.gitapiapp.data.model.UserRepo
import io.reactivex.Observable

class SearchRepository(private val apiService: GithubApiService) {
    fun searchUserRepos(user: String): Observable<List<UserRepo>> {
        return apiService.search(user = user)
    }
}