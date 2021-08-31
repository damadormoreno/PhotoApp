package com.deneb.unsplashapp.features.photos.model


import com.google.gson.annotations.SerializedName

data class UnsplashResponseItem(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("alt_description")
    val altDescription: String = "",
    @SerializedName("urls")
    val urls: Urls = Urls(),
    @SerializedName("user")
    val user: User = User()
) {
    fun toUnsplashItemView(): UnsplashItemView {
        return UnsplashItemView(id, urls.thumb)
    }

}