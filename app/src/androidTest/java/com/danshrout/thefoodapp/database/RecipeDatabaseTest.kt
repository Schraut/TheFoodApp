//package com.danshrout.thefoodapp.database
//
//import androidx.room.Room
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import androidx.test.platform.app.InstrumentationRegistry
//import com.danshrout.thefoodapp.models.Recipe
//import org.junit.After
//import org.junit.Before
//
//import org.junit.Assert.*
//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4::class)
//class RecipeDatabaseTest {
//
//    private lateinit var recipeDao: RecipeDatabaseDao
//    private lateinit var db: RecipeDatabase
//
//    @Before
//    fun creatDb() {
//        val context = InstrumentationRegistry.getInstrumentation().targetContext
//
//        db = Room.inMemoryDatabaseBuilder(context, RecipeDatabase::class.java)
//                .allowMainThreadQueries()
//                .build()
//        recipeDao = db.recipeDatabaseDao
//    }
//
//    @After
//    @Throws(Exception::class)
//    fun insertAndGetRecipe() {
//        val recipe = Recipe()
//        recipeDao.insertRecipe(recipe)
//        val recentRecipe = recipeDao.getCurrentRecipe()
//        assertEquals(recipe?.recipe)
//    }
//}