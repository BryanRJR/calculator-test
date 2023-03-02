package com.example.bcas_training_android.latihanfragment.foodmenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bcas_training_android.databinding.ItemFoodBinding
import com.example.bcas_training_android.model.FoodModel

class FoodAdapter : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private var dataFood: MutableList<FoodModel> = mutableListOf()

    fun setData(newData: MutableList<FoodModel>) {
        dataFood = newData
        notifyDataSetChanged()
    }


    inner class FoodViewHolder(val binding: ItemFoodBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bindView(data: FoodModel) {
//            binding.ivFood.setImageResource(data.image ?: 0)
            Glide.with(binding.root.context)
                .load(data.image)
                .into(binding.ivFood)
            binding.tvTitleFood.text = data.title
            binding.tvDescFood.text = data.descFood

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder =
        FoodViewHolder(
            ItemFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bindView(dataFood[position])

    }

    override fun getItemCount(): Int = dataFood.size
}