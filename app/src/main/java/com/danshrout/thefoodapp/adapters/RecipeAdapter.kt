package com.danshrout.thefoodapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danshrout.thefoodapp.R
import com.danshrout.thefoodapp.models.Recipe
import kotlinx.android.synthetic.main.recipe_item.view.*

open class RecipeAdapter(
    private val recipeList: List<Recipe>
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)

        return RecipeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentItem = recipeList[position]

        holder.image.setImageResource(currentItem.image)
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description
    }

    override fun getItemCount() = recipeList.size

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // itemView is one instance of the row layout
        // the viewholder caches references
        val image: ImageView = itemView.iv_recipe
        val title: TextView = itemView.tv_recipe_title
        val description: TextView = itemView.tv_description
    }
}
