package com.danshrout.thefoodapp.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class RecipeViewModel(
    val databaseDao: RecipeDatabaseDao,
    application: Application
) : AndroidViewModel(application) {

}
