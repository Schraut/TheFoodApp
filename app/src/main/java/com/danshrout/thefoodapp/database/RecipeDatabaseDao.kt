package com.danshrout.thefoodapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

//@Dao
//interface RecipeDatabaseDao {
//    @Insert
//    fun insert(recipe: Recipe)
//
//    @Update
//    fun update(recipe: Recipe)
//
//    @Query( "SELECT * from recipe_table WHERE recipeId = :key")
//    fun getRecipe(key: Long): Recipe
//
//    @Query( "DELETE FROM recipe_table")
//    fun deleteAllRecipes()
//
//    @Query( "SELECT * FROM recipe_table ORDER BY recipeId DESC")
//    fun getAllRecipes(): LiveData<List<Recipe>>
//
//}