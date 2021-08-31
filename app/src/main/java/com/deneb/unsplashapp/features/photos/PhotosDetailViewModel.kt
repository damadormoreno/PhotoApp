package com.deneb.unsplashapp.features.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.deneb.unsplashapp.core.platform.BaseViewModel
import com.deneb.unsplashapp.features.photos.model.UnsplashDetailView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotosDetailViewModel
@Inject constructor(private val getPhotoDetails: GetPhotoDetails): BaseViewModel() {

    private val _photoDetails: MutableLiveData<UnsplashDetailView> = MutableLiveData()
    val photoDetails: LiveData<UnsplashDetailView> = _photoDetails

    fun loadPhotoDetails(id: String) {
        getPhotoDetails(Params(id), viewModelScope){
            it.fold(::handleFailure, ::handlePhotoDetails)
        }
    }

    private fun handlePhotoDetails(unsplashDetailView: UnsplashDetailView) {
        _photoDetails.value = unsplashDetailView
    }
}