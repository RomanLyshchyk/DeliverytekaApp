package com.example.deliverytekaapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "full_price_list")
open class Medicine(
    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id: String,

    @SerializedName("name")
    @Expose
    val name: String?,

    @SerializedName("price")
    @Expose
    val price: String?,

    @SerializedName("country")
    @Expose
    val country: String?,


    @SerializedName("pack")
    @Expose
    val pack: String?,

    @SerializedName("dosage")
    @Expose
    val dosage: String?,

    @SerializedName("form")
    @Expose
    val form: String?,

    @SerializedName("isrecipe")
    @Expose
    val isrecipe: String?,

    @SerializedName("description")
    @Expose
    val description: String?
)