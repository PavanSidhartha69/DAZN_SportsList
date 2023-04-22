package com.example.daznsportslist
import com.google.gson.annotations.SerializedName
data class Videos(
    @SerializedName("Id"     ) var Id     : String? = null,
    @SerializedName("Format" ) var Format : String? = null
)
