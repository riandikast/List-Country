package com.binar.country

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v2/all")
    fun getAllFlags(): Call<List<GetAllCountryItem>>
}