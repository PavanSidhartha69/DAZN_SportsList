package com.example.daznsportslist
import com.google.gson.annotations.SerializedName
data class Image(
    @SerializedName("ImageMimeType" ) var ImageMimeType : String? = null,
    @SerializedName("ImageType"     ) var ImageType     : String? = null,
    @SerializedName("Id"            ) var Id            : String? = null
)
