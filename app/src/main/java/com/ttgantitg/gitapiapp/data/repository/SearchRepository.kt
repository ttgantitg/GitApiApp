package com.ttgantitg.gitapiapp.data.repository

import com.ttgantitg.gitapiapp.data.remote.GithubApiService
import com.ttgantitg.gitapiapp.data.model.SearchModel
import io.reactivex.Observable
import javax.inject.Inject

class SearchRepository @Inject constructor(private val apiService: GithubApiService) {
    fun searchUserRepos(user: String): Observable<List<SearchModel>> {
        return apiService.getUserRepos(user = user)
    }
}