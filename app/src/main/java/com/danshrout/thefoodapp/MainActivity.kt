package com.danshrout.thefoodapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var recipesButton: Button? = null
    private var restaurantsButton: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recipesButton = findViewById(R.id.recipes_button)
        restaurantsButton = findViewById(R.id.restaurants_button)

//        recipesButton!!.setOnClickListener {
//            val recipeIntent = Intent(this@MainActivity, RecipeActivity::class.java)
//            startActivity(recipeIntent)
//        }
//
//        restaurantsButton!!.setOnClickListener {
//            val restaurantIntent = Intent(this@MainActivity, RestaurantActivity::class.java)
//            startActivity(restaurantIntent)
//        }
    }
}
