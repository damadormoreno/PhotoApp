package com.deneb.unsplashapp.features.photos

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.deneb.unsplashapp.R
import com.deneb.unsplashapp.core.exception.Failure
import com.deneb.unsplashapp.core.extensions.failure
import com.deneb.unsplashapp.core.extensions.observe
import com.deneb.unsplashapp.core.platform.BaseFragment
import com.deneb.unsplashapp.databinding.FragmentPhotosBinding
import com.deneb.unsplashapp.features.photos.model.UnsplashItemView
import com.deneb.unsplashapp.features.photos.model.UnsplashResponseItem
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PhotosFragment : BaseFragment<FragmentPhotosBinding>(FragmentPhotosBinding::inflate) {

    @Inject
    lateinit var photosAdapter: PhotosAdapter

    private val photosViewModel: PhotosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(photosViewModel) {
            observe(photos, ::renderPhotoList)
            failure(failure, ::renderFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        loadPhotoList()
    }

    private fun initializeView() {
        binding.photoList.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.photoList.adapter = photosAdapter
        photosAdapter.clickListener = { photo ->
            val bundle = bundleOf("photo" to photo)
            findNavController().navigate(R.id.detailPhotoFragment, bundle)
        }
    }

    private fun loadPhotoList() {
        showProgress()
        photosViewModel.loadPhotos()
    }

    private fun renderPhotoList(photos: List<UnsplashItemView>?) {
        photosAdapter.collection = photos.orEmpty()
        hideProgress()
    }

    private fun renderFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> Log.e(DetailPhotoFragment::class.java.canonicalName, "Network Connection Error")
            is Failure.ServerError -> Log.e(DetailPhotoFragment::class.java.canonicalName, "Server Error")
            else -> Log.e(DetailPhotoFragment::class.java.canonicalName, "Error")
        }
    }

}