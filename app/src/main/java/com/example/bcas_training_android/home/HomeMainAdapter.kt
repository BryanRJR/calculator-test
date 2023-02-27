package com.example.bcas_training_android.home

import android.content.Intent
import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bcas_training_android.databinding.ItemNewsBinding
import com.example.bcas_training_android.model.NewsModel

class HomeMainAdapter (private val dataNews: List<NewsModel>, private val onClickNews: (NewsModel) -> Unit
): RecyclerView.Adapter<HomeMainAdapter.HomeMainViewHolder>() {

    inner class HomeMainViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data: NewsModel, onClickNews: (NewsModel) -> Unit) {
            binding.ivNews.setImageResource(data.image ?: 0)
            binding.tvTitle.text = data.title
            binding.tvDescNews.text = data.descNews

            binding.itemNews.setOnClickListener {
                onClickNews(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMainViewHolder
    = HomeMainViewHolder (
            ItemNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            )

    override fun onBindViewHolder(holder: HomeMainViewHolder, position: Int) {
        holder.bindView(dataNews[position], onClickNews)
//        val (photo, title, description) = dataNews[position]
//        holder.binding.ivNews.setImageResource(photo ?: 0)
//        holder.binding.tvTitle.text = title
//        holder.binding.tvDescNews.text = description
//        holder.itemView.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + dataNews[holder.adapterPosition].title, Toast.LENGTH_SHORT).show()
//        }
    }

    override fun getItemCount(): Int = dataNews.size
}