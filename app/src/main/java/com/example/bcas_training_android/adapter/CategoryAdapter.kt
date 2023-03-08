package com.example.bcas_training_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcas_training_android.databinding.ItemCategoryBinding
import com.example.bcas_training_android.model.CategoryModel

class CategoryAdapter (private val dataCategory: List<CategoryModel>
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(val binding: ItemCategoryBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data: CategoryModel) {

            binding.tvTitleCategory.text = data.title

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder
            = CategoryViewHolder (
        ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun getItemCount(): Int = dataCategory.size
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindView(dataCategory[position])
    }
}