package com.danshrout.thefoodapp

import android.content.Intent
import android.os.Bundle
<<<<<<< HEAD
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

=======
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


>>>>>>> 37bab9ec2ab18d3511da658a32eab85a8692b364
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< HEAD
        //Buttons
        val recipes_button = findViewById<Button>(R.id.recipes_button)
        val restaurants_button = findViewById<Button>(R.id.restaurants_button)

        //Navigate to recipes page
=======

>>>>>>> 37bab9ec2ab18d3511da658a32eab85a8692b364
        recipes_button.setOnClickListener {
            val intent = Intent(this, RecipeActivity::class.java)
            startActivity(intent)
        }

<<<<<<< HEAD
        //TODO Build out restaurant features after MVP is complete.
        //Navigate to restaurant page
//        restaurants_button.setOnClickListener {
//            val intent = Intent( this, RestaurantActivity::class.java)
//            startActivity(intent)
//        }
=======
        restaurants_button.setOnClickListener {
            val intent = Intent( this, RestaurantActivity::class.java)
            startActivity(intent)
        }
>>>>>>> 37bab9ec2ab18d3511da658a32eab85a8692b364
    }
}
