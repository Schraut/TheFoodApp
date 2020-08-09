package com.danshrout.thefoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddRecipeActivity extends AppCompatActivity {

public static final String EXTRA_TITLE = "com.danshrout.thefoodapp.EXTRA_TITLE";
public static final String EXTRA_INGREDIENTS = "com.danshrout.thefoodapp.EXTRA_INGREDIENTS";
public static final String EXTRA_DIRECTIONS = "com.danshrout.thefoodapp.EXTRA_DIRECTIONS";

    private EditText editTextTitle,
            editTextIngredients,
            editTextDirections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextIngredients = findViewById(R.id.edit_text_ingredients);
        editTextDirections = findViewById(R.id.edit_text_directions);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close_icon);
        setTitle("Add Recipe");
    }

    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String ingredients = editTextIngredients.getText().toString();
        String directions = editTextDirections.getText().toString();


        //TODO
        //Make this into a switch case
        if (title.trim().isEmpty()) {
            Toast.makeText( this, "Please enter a title", Toast.LENGTH_LONG).show();
        }

        if (ingredients.trim().isEmpty()) {
            Toast.makeText( this, "Please enter some ingredients", Toast.LENGTH_LONG).show();
        }

        if (directions.trim().isEmpty()) {
            Toast.makeText( this, "Please enter some directions", Toast.LENGTH_LONG).show();
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_INGREDIENTS, ingredients);
        data.putExtra(EXTRA_DIRECTIONS, directions);

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_recipe_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_recipe:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
