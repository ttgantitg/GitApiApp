package com.ttgantitg.gitapiapp.data.repository

import com.ttgantitg.gitapiapp.data.api.GithubApiService

object SearchRepositoryProvider {
    fun provideSearchRepository(): SearchRepository {
        return SearchRepository(apiService = GithubApiService.create())
    }
}