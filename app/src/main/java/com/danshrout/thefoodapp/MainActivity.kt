package com.danshrout.thefoodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Buttons
        val recipes_button = findViewById<Button>(R.id.recipes_button)
        val restaurants_button = findViewById<Button>(R.id.restaurants_button)

        //Navigate to recipes page
        recipes_button.setOnClickListener {
            val intent = Intent(this, RecipeActivity::class.java)
            startActivity(intent)
        }

        //Navigate to restaurant page
        restaurants_button.setOnClickListener {
            val intent = Intent( this, RestaurantActivity::class.java)
            startActivity(intent)
        }
    }
}
