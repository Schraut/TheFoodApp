package com.danshrout.thefoodapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.danshrout.thefoodapp.database.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {

    private List<Recipe> recipes = new ArrayList<>();

    @NonNull
    @Override
    public RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_item, parent, false);
        return new RecipeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeHolder holder, int position) {
        Recipe currentRecipe = recipes.get(position);
        holder.textViewTitle.setText(currentRecipe.getTitle());
        holder.textViewIngredients.setText(currentRecipe.getIngredients());
        holder.textViewDirections.setText(currentRecipe.getDirections());

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    public Recipe getRecipeAt(int position) {
        return recipes.get(position);
    }

    class RecipeHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewIngredients;
        private TextView textViewDirections;


        public RecipeHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            textViewIngredients = itemView.findViewById(R.id.text_view_ingredients);
            textViewDirections = itemView.findViewById(R.id.text_view_directions);
        }
    }
}
