package com.example.bcas_training_android.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.bcas_training_android.R
import com.example.bcas_training_android.databinding.ItemCategoryBinding
import com.example.bcas_training_android.databinding.ItemFoodCategoryBinding
import com.example.bcas_training_android.databinding.ItemNewsBinding
import com.example.bcas_training_android.home.HomeMainAdapter
import com.example.bcas_training_android.model.CategoryFoodModel
import com.example.bcas_training_android.model.FoodModel
import com.example.bcas_training_android.model.NewsModel

class CategoryFoodAdapter: RecyclerView.Adapter<CategoryFoodAdapter.CategoryFoodViewHolder>() {

    private var data: MutableList<CategoryFoodModel> = mutableListOf()
    private var onClickList:(CategoryFoodModel)-> Unit = {}

    fun setData(newData: MutableList<CategoryFoodModel>) {
        data = newData
        notifyDataSetChanged()
    }

    fun addOnClickFoodCategoryItem(clickFood: (CategoryFoodModel)->Unit){
        onClickList = clickFood
    }

    inner class CategoryFoodViewHolder(val binding: ItemFoodCategoryBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data: CategoryFoodModel) {

            binding.tvTitleCategory.text = data.title
            binding.constFood.setOnClickListener {
                onClickList(data)
            }

            val(selectedBackgroundRes, selectedColor) = if (data.isSelected ?: false) {
                Pair(R.drawable.background_rounded_selected, Color.CYAN)
            } else{
                Pair(R.drawable.background_rounded_outline_black, Color.BLACK)
            }

            val selectedBackground = ContextCompat.getDrawable(binding.root.context, selectedBackgroundRes)

            binding.constFood.background = selectedBackground
            binding.tvTitleCategory.setTextColor(ColorStateList.valueOf(selectedColor))

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryFoodViewHolder
            = CategoryFoodViewHolder (
        ItemFoodCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun getItemCount(): Int = data.size
    override fun onBindViewHolder(holder: CategoryFoodAdapter.CategoryFoodViewHolder, position: Int) {
        holder.bindView(data[position])
    }
}