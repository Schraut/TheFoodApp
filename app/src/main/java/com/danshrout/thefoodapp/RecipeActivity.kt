package com.danshrout.thefoodapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

class RecipeActivity : AppCompatActivity() {

    fun addRecipe(view: View) {
        Toast.makeText(this, "The add recipe button has been clicked but doesn't do anything.", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

    }
}
