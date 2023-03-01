package com.example.bcas_training_android.setting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcas_training_android.databinding.ItemSimpleBinding

class SettingAdapter : RecyclerView.Adapter<SettingAdapter.SettingViewHolder>() {

    inner class SettingViewHolder(private val binding: ItemSimpleBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String){
            binding.itemTvUser.text = item
        }
    }

    private val items: MutableList<String> = mutableListOf()

    fun addItems(newItems: List<String>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemSimpleBinding.inflate(layoutInflater, parent, false)
        return SettingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}