package com.deneb.unsplashapp.features.photos.model

data class UnsplashDetailView(
    val id: String = "",
    val description: String? = "",
    val altDescription: String = "",
    val image: String = "",
    val likes: Int = 0,
    val exif: Exif = Exif(),
    val user: User = User(),
    val views: Int = 0,
    val downloads: Int = 0,
)
