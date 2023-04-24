package com.example.daznsportslist
import com.google.gson.annotations.SerializedName
data class Image(
    @SerializedName("ImageMimeType" ) var ImageMimeType : String? = null,
    @SerializedName("ImageType"     ) var ImageType     : String? = null,
    @SerializedName("Id"            ) var Id            : String? = null,
    @SerializedName("URL"            ) var URL            : String? = "https://image.discovery.indazn.com/jp/v3/jp/none/111572549752_image-header_pRow_1620527394000/fill/center/top/none/85/1042/828/jpg/image"

)
