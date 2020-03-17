package com.ttgantitg.gitapiapp.data.repository

import com.ttgantitg.gitapiapp.data.api.GithubApiService
import com.ttgantitg.gitapiapp.data.model.SearchResponse
import io.reactivex.Observable

class SearchRepository(private val apiService: GithubApiService) {
    fun searchUserRepos(user: String): Observable<ArrayList<SearchResponse>> {
        return apiService.search(user = user)
    }
}