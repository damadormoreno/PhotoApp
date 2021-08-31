package com.deneb.unsplashapp.features.photos.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("username")
    val username: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("first_name")
    val firstName: String = "",
    @SerializedName("last_name")
    val lastName: String = "",
    @SerializedName("twitter_username")
    val twitterUsername: String = "",
    @SerializedName("portfolio_url")
    val portfolioUrl: String = "",
    @SerializedName("bio")
    val bio: String = "",
    @SerializedName("location")
    val location: String = "",
    @SerializedName("links")
    val links: LinksUser = LinksUser(),
    @SerializedName("profile_image")
    val profileImage: ProfileImage = ProfileImage(),
    @SerializedName("instagram_username")
    val instagramUsername: String = "",
    @SerializedName("total_collections")
    val totalCollections: Int = 0,
    @SerializedName("total_likes")
    val totalLikes: Int = 0,
    @SerializedName("total_photos")
    val totalPhotos: Int = 0,
    @SerializedName("accepted_tos")
    val acceptedTos: Boolean = false,
    @SerializedName("for_hire")
    val forHire: Boolean = false,
    @SerializedName("social")
    val social: Social = Social()
)