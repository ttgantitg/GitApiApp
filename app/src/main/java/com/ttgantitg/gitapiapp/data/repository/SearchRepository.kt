package com.ttgantitg.gitapiapp.data.repository

import com.ttgantitg.gitapiapp.data.api.GithubApiService
import com.ttgantitg.gitapiapp.data.model.SearchModel
import io.reactivex.Observable

class SearchRepository(private val apiService: GithubApiService) {
    fun searchUserRepos(user: String): Observable<List<SearchModel>> {
        return apiService.getUserRepos(user = user)
    }
}