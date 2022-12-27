package com.example.authapp.data.remote.entity

import com.google.gson.annotations.SerializedName

data class TodoNetworkEntity(

    @SerializedName("completed")
    val completed: Boolean,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("user_id")
    val userId: Int
)
