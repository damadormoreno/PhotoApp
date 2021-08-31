package com.deneb.unsplashapp.features.photos.model


import com.google.gson.annotations.SerializedName

data class Exif(
    @SerializedName("make")
    val make: String = "",
    @SerializedName("model")
    val model: String = "",
    @SerializedName("exposure_time")
    val exposureTime: String = "",
    @SerializedName("aperture")
    val aperture: String = "",
    @SerializedName("focal_length")
    val focalLength: String = "",
    @SerializedName("iso")
    val iso: Int = 0
)