package com.tugasakhirsemester.ihwan.api

import com.tugasakhirsemester.ihwan.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>
}