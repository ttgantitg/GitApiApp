package com.ttgantitg.gitapiapp.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse (
    @SerializedName("name") val repoName: String
)