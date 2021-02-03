package com.danshrout.thefoodapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.danshrout.thefoodapp.models.Recipe

@Dao
interface RecipeDatabaseDao {

    @Insert
    fun insertRecipe(recipe: Recipe)

    @Update
    fun updateRecipe(recipe: Recipe)

    @Delete
    fun deleteRecipe(recipe: Recipe)

    @Query("SELECT * FROM recipe_table WHERE recipeId = :key")
    fun get(key: Long): Recipe

    // Delete all entries
    @Query("DELETE FROM recipe_table")
    fun clear()

    // Get all recipes
    @Query("SELECT * FROM recipe_table ORDER BY recipeId DESC")
    fun getAllRecipes(): LiveData<List<Recipe>>

    // Get the most recent
    @Query("SELECT * FROM recipe_table ORDER BY recipeId DESC LIMIT 1")
    fun getCurrentRecipe(): Recipe?
}
