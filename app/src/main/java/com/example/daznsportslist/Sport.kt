package com.example.daznsportslist
import com.google.gson.annotations.SerializedName
data class Sport(
    @SerializedName("Id"     ) var Id     : String?           = null,
    @SerializedName("Title"  ) var Title  : String?           = null,
    @SerializedName("Images" ) var Images : ArrayList<Images> = arrayListOf()
)
