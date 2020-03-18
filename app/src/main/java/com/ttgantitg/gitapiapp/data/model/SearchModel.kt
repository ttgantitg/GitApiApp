package com.ttgantitg.gitapiapp.data.model

import com.google.gson.annotations.SerializedName

data class SearchModel (
    @SerializedName("name") val repoName: String
)