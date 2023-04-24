package com.example.daznsportslist

import retrofit2.Call
import retrofit2.http.GET

interface SportsListAPI {
    @GET(value = "fc2a4463-16e1-4a03-acdd-12abe4b8300a")
    fun getData() : Call<SportsData>
}