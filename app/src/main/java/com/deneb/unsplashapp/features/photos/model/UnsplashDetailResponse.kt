package com.deneb.unsplashapp.features.photos.model


import com.google.gson.annotations.SerializedName

data class UnsplashDetailResponse(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("alt_description")
    val altDescription: String = "",
    @SerializedName("urls")
    val urls: Urls = Urls(),
    @SerializedName("likes")
    val likes: Int = 0,
    @SerializedName("exif")
    val exif: Exif = Exif(),
    @SerializedName("user")
    val user: User = User(),
    @SerializedName("views")
    val views: Int = 0,
    @SerializedName("downloads")
    val downloads: Int = 0,

    ) {
    fun toUnsplashDetailView(): UnsplashDetailView {
        return UnsplashDetailView(
            id,
            description,
            altDescription,
            urls.regular,
            likes,
            exif,
            user,
            views,
            downloads
        )
    }
}