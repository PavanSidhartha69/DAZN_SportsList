package com.example.daznsportslist

import retrofit2.Call
import retrofit2.http.GET

interface SportsListAPI {
    @GET(value = "5a8dbd14-6eba-4697-9027-56b0b3efd9dc")
    fun getData() : Call<SportsData>
}