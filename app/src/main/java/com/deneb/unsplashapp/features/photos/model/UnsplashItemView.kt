package com.deneb.unsplashapp.features.photos.model

import android.os.Parcel
import com.deneb.unsplashapp.core.platform.KParcelable
import com.deneb.unsplashapp.core.platform.parcelableCreator

data class UnsplashItemView(
    val id: String,
    val image: String
): KParcelable{
    companion object {
        @JvmField
        val CREATOR = parcelableCreator(::UnsplashItemView)
    }

    constructor(parcel: Parcel) : this(parcel.readString()!!, parcel.readString()!!)

    override fun writeToParcel(dest: Parcel, flags: Int) {
        with(dest){
            writeString(id)
            writeString(image)
        }
    }

}
