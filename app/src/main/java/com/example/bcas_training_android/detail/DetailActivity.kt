package com.example.bcas_training_android.detail

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bcas_training_android.databinding.ActivityDetailBinding
import com.example.bcas_training_android.model.NewsModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDataToViewDetail()

        binding.btnBack.setOnClickListener {
            binding.btnBack.setBackgroundColor(Color.BLUE)
        }

    }

    private fun setDataToViewDetail() {
        val data = intent.getParcelableExtra<NewsModel>(DATA_NEWS)
        binding.tvDetailTitle.text = data?.title
        binding.tvDetailDesc.text = data?.descNews
    }
    companion object {
        private const val DATA_NEWS = "dataNews"

        fun navigateToActivityDetail(activity: Activity, dataNews: NewsModel) {
            val intent = Intent(activity, DetailActivity::class.java)
            intent.putExtra(DATA_NEWS, dataNews)
            activity.startActivity(intent)
        }
    }
}