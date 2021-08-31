package com.deneb.unsplashapp.features.photos.model


import com.google.gson.annotations.SerializedName

data class LinksUser(
    @SerializedName("self")
    val self: String = "",
    @SerializedName("html")
    val html: String = "",
    @SerializedName("photos")
    val photos: String = "",
    @SerializedName("likes")
    val likes: String = "",
    @SerializedName("portfolio")
    val portfolio: String = "",
    @SerializedName("following")
    val following: String = "",
    @SerializedName("followers")
    val followers: String = ""
)