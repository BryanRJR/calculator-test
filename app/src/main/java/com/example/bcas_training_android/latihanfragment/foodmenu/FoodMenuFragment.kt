package com.example.bcas_training_android.latihanfragment.foodmenu

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bcas_training_android.R
import com.example.bcas_training_android.adapter.CategoryFoodAdapter
import com.example.bcas_training_android.databinding.FragmentFoodMenuBinding
import com.example.bcas_training_android.model.CategoryFoodModel
import com.example.bcas_training_android.model.CategoryModel
import com.example.bcas_training_android.model.FoodModel

class FoodMenuFragment : Fragment() {
    private var binding: FragmentFoodMenuBinding? = null
    private val foodAdapter = FoodAdapter()
    private val categoryFoodAdapter = CategoryFoodAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodMenuBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        foodAdapter.setData(populateData())
        categoryFoodAdapter.setData(populateDataFoodCategory())

        binding?.rvFood?.adapter = foodAdapter
        binding?.rvCategoryFood?.adapter = categoryFoodAdapter
        
        categoryFoodAdapter.addOnClickFoodCategoryItem { categoryFoodModel ->  
            val categoryFoodData = populateDataFoodCategory()
            val category = categoryFoodData.map {
                val categoryId = categoryFoodModel.id
                val isSelected = it.id == categoryId
                it.copy(isSelected = isSelected)
            }
            categoryFoodAdapter.setData(category.toMutableList())

            val data = populateData()
            val filterData = data.filter { dataFood ->
                dataFood.category == categoryFoodModel.title
            }
            foodAdapter.setData(filterData.toMutableList())
        }

        binding?.etSearch?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val editTextValue = binding?.etSearch?.text
                if (editTextValue?.isEmpty() == true) {
                    binding?.ivClose?.visibility = View.INVISIBLE
                } else {
                    binding?.ivClose?.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(p0: Editable?) {
                val data = populateData()
                val filterData = data.filter { data ->
                    data.title.contains(p0.toString(), ignoreCase = true)

                }
                foodAdapter.setData(filterData.toMutableList())
            }
        })

        binding?.ivClose?.setOnClickListener {
            binding?.etSearch?.setText("")
        }
    }

    private fun populateData(): MutableList<FoodModel> {
        val listData = mutableListOf(
            FoodModel(
                image = "https://tribratanews.polri.go.id/web/image/blog.post/50469/image",
                title = "Ketoprak",
                descFood = "Lorem ipsum hujan terus nih hehehe lapar pingin pop mie,",
                category = "Manis"
            ),
            FoodModel(
                image = "https://tribratanews.polri.go.id/web/image/blog.post/50469/image",
                title = "Makanan Pedas",
                descFood = "Lorem ipsum hujan terus nih hehehe lapar pingin pop mie,",
                category = "Pedas"
            ),
            FoodModel(
                image = "https://tribratanews.polri.go.id/web/image/blog.post/50469/image",
                title = "Tempe",
                descFood = "Lorem ipsum hujan terus nih hehehe lapar pingin pop mie,",
                category = "Asin"
            ),
            FoodModel(
                image = "https://tribratanews.polri.go.id/web/image/blog.post/50469/image",
                title = "Bakso",
                descFood = "Lorem ipsum hujan terus nih hehehe lapar pingin pop mie,",
                category = "Bakso"
            ),
        )
        return listData
    }

    private fun populateDataFoodCategory(): MutableList<CategoryFoodModel> {
        val listData = mutableListOf(
            CategoryFoodModel(
                id = 1,
                title = "Pedas",
                isSelected = false
            ),
            CategoryFoodModel(
                id = 2,
                title = "Manis",
                isSelected = false
            ),
            CategoryFoodModel(
                id = 3,
                title = "Asam",
                isSelected = false
            ),
            CategoryFoodModel(
                id = 4,
                title = "Asin",
                isSelected = false
            ),
            CategoryFoodModel(
                id = 5,
                title = "Sate",
                isSelected = false
            ),
            CategoryFoodModel(
                id = 6,
                title = "Bakso",
                isSelected = false
            ),
        )
        return listData


    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}