package com.danshrout.thefoodapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe_table")
data class Recipe(

    @PrimaryKey(autoGenerate = true)
    var recipeId: Int,

    @ColumnInfo(name = "image")
    val image: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String
)
