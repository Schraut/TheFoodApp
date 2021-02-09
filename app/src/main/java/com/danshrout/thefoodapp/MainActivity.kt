package com.danshrout.thefoodapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.danshrout.thefoodapp.adapters.RecipeAdapter
import com.danshrout.thefoodapp.models.Recipe
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Variable for creating dummy data
    //private val dummyData = dummyDataList(50)

    //private val adapter = RecipeAdapter(dummyData)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RecyclerView with dummy data
        //rv_recipes.adapter = RecipeAdapter(dummyData)
        // RecylcerView need a manager since it can't do it
        // LinearLayout displays the items vertically
        //rv_recipes.layoutManager = LinearLayoutManager(this)
        // For fixed width and height for performance optimization
        //rv_recipes.setHasFixedSize(true)
    }

//    private fun dummyDataList(size: Int): List<Recipe> {
//        val list = ArrayList<Recipe>()
//
//        for (i in 0 until size) {
//            val drawable = when (i % 3) {
//                0 -> R.drawable.ic_delete_forever_24
//                1 -> R.drawable.ic_edit_24
//                else -> R.drawable.add_icon
//            }
//
//            val item = Recipe(drawable, 5, "Description $i")
//            list += item
//        }
//        return list
//    }

//    fun addRecipe(view: View) {
//    }
//
//    fun deleteRecipe(view: View) {
//    }
}
