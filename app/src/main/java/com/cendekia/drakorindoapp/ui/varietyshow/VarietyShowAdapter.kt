package com.cendekia.drakorindoapp.ui.varietyshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cendekia.drakorindoapp.R
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity
import com.cendekia.drakorindoapp.databinding.ItemsRvBinding
import com.cendekia.drakorindoapp.ui.detail.DetailVarietyShowActivity

class VarietyShowAdapter :
    PagedListAdapter<VarietyEntity, VarietyShowAdapter.VarietyShowViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<VarietyEntity>() {
            override fun areItemsTheSame(oldItem: VarietyEntity, newItem: VarietyEntity): Boolean {
                return oldItem.drakorindoId == newItem.drakorindoId
            }

            override fun areContentsTheSame(
                oldItem: VarietyEntity,
                newItem: VarietyEntity
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VarietyShowViewHolder {
        val itemsRvBinding =
            ItemsRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VarietyShowViewHolder(
            itemsRvBinding
        )
    }

    override fun onBindViewHolder(holder: VarietyShowViewHolder, position: Int) {
        val variety = getItem(position)
        if (variety != null) {
            holder.bind(variety)
        }
    }

    class VarietyShowViewHolder(private val binding: ItemsRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(variety: VarietyEntity) {
            with(binding) {
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailVarietyShowActivity::class.java)
                    intent.putExtra(
                        DetailVarietyShowActivity.EXTRA_VARIETY,
                        variety.drakorindoId
                    )
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(variety.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }
}