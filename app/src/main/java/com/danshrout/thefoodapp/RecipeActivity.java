package com.danshrout.thefoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.danshrout.thefoodapp.database.Recipe;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    public static final int ADD_RECIPE_REQUEST = 1;

    private RecipeViewModel recipeViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        FloatingActionButton buttonAddRecipe = findViewById(R.id.button_add_recipe);
        buttonAddRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipeActivity.this, AddRecipeActivity.class);
                startActivityForResult(intent, ADD_RECIPE_REQUEST);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view_recipe);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final RecipeAdapter adapter = new RecipeAdapter();
        recyclerView.setAdapter(adapter);

        recipeViewModel = ViewModelProviders.of(this).get(RecipeViewModel.class);
        recipeViewModel.getAllRecipes().observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                adapter.setRecipes(recipes);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                recipeViewModel.delete(adapter.getRecipeAt(viewHolder.getAdapterPosition()));
                Toast.makeText(RecipeActivity.this, "Recipe deleted", Toast.LENGTH_SHORT).show();

            }
        }).attachToRecyclerView(recyclerView);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_RECIPE_REQUEST && resultCode == RESULT_OK) {
            String title = data.getStringExtra(AddRecipeActivity.EXTRA_TITLE);
            String ingredients = data.getStringExtra(AddRecipeActivity.EXTRA_INGREDIENTS);
            String directions = data.getStringExtra(AddRecipeActivity.EXTRA_DIRECTIONS);

            Recipe recipe = new Recipe(title, ingredients, directions);
            recipeViewModel.insert(recipe);

            Toast.makeText(this, "Recipe Saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Recipe Not Saved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.delete_all_recipes:
                recipeViewModel.deleteAllRecipes();
                Toast.makeText(this, "All recipes deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
