package com.deneb.unsplashapp.features.photos

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.deneb.unsplashapp.core.exception.Failure
import com.deneb.unsplashapp.core.extensions.failure
import com.deneb.unsplashapp.core.extensions.loadFromUrl
import com.deneb.unsplashapp.core.extensions.observe
import com.deneb.unsplashapp.core.platform.BaseFragment
import com.deneb.unsplashapp.databinding.FragmentDetailPhotoBinding
import com.deneb.unsplashapp.features.photos.model.UnsplashDetailView
import com.deneb.unsplashapp.features.photos.model.UnsplashItemView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailPhotoFragment :
    BaseFragment<FragmentDetailPhotoBinding>(FragmentDetailPhotoBinding::inflate) {
    private val photoDetailsViewModel by viewModels<PhotosDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(photoDetailsViewModel) {
            observe(photoDetails, ::renderPhotoDetail)
            failure(failure, ::renderFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadPhotoDetail()
    }

    private fun loadPhotoDetail() {
        showProgress()
        photoDetailsViewModel.loadPhotoDetails(
            arguments?.getParcelable<UnsplashItemView>("photo")?.id ?: ""
        )
    }

    private fun renderPhotoDetail(unsplashDetailView: UnsplashDetailView?) {
        bindUser(unsplashDetailView)
        bindCamera(unsplashDetailView)

        hideProgress()
    }

    private fun bindCamera(unsplashDetailView: UnsplashDetailView?) {
        binding.cameraModel.text = unsplashDetailView?.exif?.model
        binding.cameraIso.text = "ISO: ${unsplashDetailView?.exif?.iso}"
        binding.cameraAperture.text = "Aperture: ${unsplashDetailView?.exif?.aperture}"
    }

    private fun bindUser(unsplashDetailView: UnsplashDetailView?) {
        binding.imageDetail.loadFromUrl(unsplashDetailView?.image)
        binding.circleImageProfile.loadFromUrl(unsplashDetailView?.user?.profileImage?.small)
        binding.profileName.text =
            "${unsplashDetailView?.user?.firstName} ${unsplashDetailView?.user?.lastName}"
        binding.instagramName.text = unsplashDetailView?.user?.instagramUsername
    }

    private fun renderFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> Log.e(DetailPhotoFragment::class.java.canonicalName, "Network Connection Error")
            is Failure.ServerError -> Log.e(DetailPhotoFragment::class.java.canonicalName, "Server Error")
            else -> Log.e(DetailPhotoFragment::class.java.canonicalName, "Error")
        }
    }

}