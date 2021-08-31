package com.deneb.unsplashapp.features.photos

import com.deneb.unsplashapp.features.photos.model.UnsplashResponse
import com.deneb.unsplashapp.features.photos.model.UnsplashDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

internal interface PhotosApi {
    @GET("photos/?client_id=tmr_PqBQovlCcGQgjwvPJPiUGqruqDOs-MMgrXrAgSQ")
    fun photos(): Call<UnsplashResponse>

    @GET("photos/{id}/?client_id=tmr_PqBQovlCcGQgjwvPJPiUGqruqDOs-MMgrXrAgSQ")
    fun detailPhoto(@Path("id")id: String): Call<UnsplashDetailResponse>
}