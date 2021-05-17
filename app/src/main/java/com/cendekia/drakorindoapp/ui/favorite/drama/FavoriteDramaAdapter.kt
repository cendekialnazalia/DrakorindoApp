package com.cendekia.drakorindoapp.ui.favorite.drama

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cendekia.drakorindoapp.R
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.databinding.ItemsRvBinding
import com.cendekia.drakorindoapp.ui.detail.DetailDramaActivity

class FavoriteDramaAdapter :
    PagedListAdapter<DramaEntity, FavoriteDramaAdapter.DramaViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DramaEntity>() {
            override fun areItemsTheSame(oldItem: DramaEntity, newItem: DramaEntity): Boolean {
                return oldItem.drakorindoId == newItem.drakorindoId
            }

            override fun areContentsTheSame(oldItem: DramaEntity, newItem: DramaEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DramaViewHolder {
        val itemsRvBinding =
            ItemsRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DramaViewHolder(
            itemsRvBinding
        )
    }

    override fun onBindViewHolder(holder: DramaViewHolder, position: Int) {
        val drama = getItem(position)
        if (drama != null) {
            holder.bind(drama)
        }
    }

    fun getSwipedData(swipedPosition: Int): DramaEntity? = getItem(swipedPosition)

    inner class DramaViewHolder(private val binding: ItemsRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(drama: DramaEntity) {
            with(binding) {
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailDramaActivity::class.java)
                    intent.putExtra(DetailDramaActivity.EXTRA_DRAMA, drama.drakorindoId)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(drama.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }
}