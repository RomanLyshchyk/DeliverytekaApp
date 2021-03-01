package com.example.deliverytekaapp.pojo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("id")
    @Expose
    val userId: String?,
    @SerializedName("phone")
    @Expose
    val userPhone: String?,
)
