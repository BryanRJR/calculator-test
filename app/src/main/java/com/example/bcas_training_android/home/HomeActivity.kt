package com.example.bcas_training_android.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.example.bcas_training_android.CategoryAdapter
import com.example.bcas_training_android.ProfileActivity
import com.example.bcas_training_android.R
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_EMAIL
import com.example.bcas_training_android.auth.LoginActivity.Companion.KEY_PASSWORD
import com.example.bcas_training_android.calculator.CalculatorActivity
import com.example.bcas_training_android.databinding.ActivityHomeBinding
import com.example.bcas_training_android.detail.DetailActivity
import com.example.bcas_training_android.model.CategoryModel
import com.example.bcas_training_android.model.NewsModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainAdapter = HomeMainAdapter(dataNews =  populateData(), onClickNews = { dataNews ->
//            Toast.makeText(applicationContext, it.title, Toast.LENGTH_LONG).show()
                DetailActivity.navigateToActivityDetail(this, dataNews)
        })
        binding.rvNews.adapter = mainAdapter

        val categoryAdapter = CategoryAdapter(dataCategory = populateDataCategory())
        binding.rvListHorizontal.adapter = categoryAdapter

    }

    private fun populateData() : List<NewsModel> {
        val listData = listOf(
            NewsModel(
                image = R.drawable.jokowi,
                title = "Jokowi Paparkan Hasil Audit",
                descNews = "Baca artikel detiknews, Jokowi Paparkan Hasil Audit 22 Stadion Sepak Bola, 5 Stadion Rusak Berat"
            ),
            NewsModel(
                image = R.drawable.war_ukraine,
                title = "War Ukraine and Russia",
                descNews = "Rusia Tuding Ukraina Bersiap Invasi Transnistria di Moldova"
            ),
            NewsModel(
                image = R.drawable.anak_tak_bersepatu,
                title = "Anak-anak SDN Nainefo Tak Bersepatu dan Seragamnya",
                descNews = "Anak-anak SDN Nainefo Tak Bersepatu dan Seragamnya Tak Layak, Ayo Bantu!"
            ),
            NewsModel(
                image = R.drawable.kerusuhan_papua,
                title = "9 Orang Tewas Buntut Isu Penculikan Anak di Wamena, Polisi Kena Panah",
                descNews = "Kerusuhan yang diakibatnya adanya perselisihan antar warga yang membuat dua kampung berselisi kini memakan korban jiwa"
            )
        )
        return listData
    }

    private fun populateDataCategory() : List<CategoryModel> {
        val listData = listOf(
            CategoryModel(
                title = "Sport"
            ),
            CategoryModel(
                title = "News"
            ),
            CategoryModel(
                title = "Religion"
            ),
            CategoryModel(
                title = "Healthy"
            ),
            CategoryModel(
                title = "Teens"
            ),
            CategoryModel(
                title = "Watch"
            ),

            )
        return listData


    }
}