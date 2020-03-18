package com.ttgantitg.gitapiapp.data.model

import com.google.gson.annotations.SerializedName

data class UserRepo (
    @SerializedName("name") val repoName: String
)