package com.deneb.unsplashapp.features.photos

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deneb.unsplashapp.R
import com.deneb.unsplashapp.core.extensions.inflate
import com.deneb.unsplashapp.core.extensions.loadFromUrl
import com.deneb.unsplashapp.databinding.RowPhotoBinding
import com.deneb.unsplashapp.features.photos.model.UnsplashItemView
import javax.inject.Inject
import kotlin.properties.Delegates

class PhotosAdapter
@Inject constructor() : RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {

    internal var collection: List<UnsplashItemView> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal var clickListener: (UnsplashItemView) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.row_photo))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position], clickListener)

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = RowPhotoBinding.bind(itemView)

        fun bind(photo: UnsplashItemView, clickListener: (UnsplashItemView) -> Unit) {
            binding.photoPoster.loadFromUrl(photo.image)
            itemView.setOnClickListener {
                clickListener(
                    photo
                )
            }
        }
    }
}
