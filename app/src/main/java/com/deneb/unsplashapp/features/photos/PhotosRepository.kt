package com.deneb.unsplashapp.features.photos

import com.deneb.unsplashapp.core.exception.Failure
import com.deneb.unsplashapp.core.functional.Either
import com.deneb.unsplashapp.core.functional.request
import com.deneb.unsplashapp.core.platform.NetworkHandler
import com.deneb.unsplashapp.features.photos.model.*
import javax.inject.Inject

interface PhotosRepository {
    fun photos(): Either<Failure, List<UnsplashItemView>>
    fun photoDetails(id:String): Either<Failure, UnsplashDetailView>
    class PhotosRepositoryImpl
    @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: PhotosService
    ) : PhotosRepository {
        override fun photos(): Either<Failure, List<UnsplashItemView>> {
            return when (networkHandler.isNetworkAvailable()) {
                true -> request(
                    service.photos(),
                    {
                        it.map { item ->
                            item.toUnsplashItemView()
                        }
                    },
                    UnsplashResponse()
                )
                false -> Either.Left(Failure.NetworkConnection)
            }
        }

        override fun photoDetails(id: String): Either<Failure, UnsplashDetailView> {
            return when (networkHandler.isNetworkAvailable()) {
                true -> request(
                    service.detailPhoto(id),
                    {
                        it.toUnsplashDetailView()
                    },
                    UnsplashDetailResponse()
                )
                false -> Either.Left(Failure.NetworkConnection)
            }
        }

    }
}