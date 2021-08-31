package com.deneb.unsplashapp.features.photos.model


import com.google.gson.annotations.SerializedName

data class Social(
    @SerializedName("instagram_username")
    val instagramUsername: String = "",
    @SerializedName("portfolio_url")
    val portfolioUrl: String = "",
    @SerializedName("twitter_username")
    val twitterUsername: String = "",
    @SerializedName("paypal_email")
    val paypalEmail: Any = Any()
)