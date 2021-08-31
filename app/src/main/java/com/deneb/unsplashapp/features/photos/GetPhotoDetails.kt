package com.deneb.unsplashapp.features.photos

import com.deneb.unsplashapp.core.interactor.UseCase
import com.deneb.unsplashapp.features.photos.model.UnsplashDetailView
import javax.inject.Inject

class GetPhotoDetails
@Inject constructor(private val photosRepository: PhotosRepository): UseCase<UnsplashDetailView, Params>() {
    override suspend fun run(params: Params) = photosRepository.photoDetails(params.id)
}

data class Params(val id: String)