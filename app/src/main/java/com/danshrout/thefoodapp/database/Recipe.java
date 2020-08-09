package com.danshrout.thefoodapp.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipe_table")
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String ingredients;
    private String directions;

    //Constructor
    public Recipe(String title, String ingredients, String directions) {
        this.title = title;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    //Setter
    public void setId(int id) {
        this.id = id;
    }

    //Getter
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getIngredients() {
        return ingredients;
    }
    public String getDirections() {
        return  directions;
    }


}
