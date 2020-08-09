package com.danshrout.thefoodapp.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Recipe.class}, version = 1, exportSchema = false)
public abstract class RecipeDatabase extends RoomDatabase {

    private static RecipeDatabase instance;

    public  abstract RecipeDao recipeDao();

    public static synchronized  RecipeDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    RecipeDatabase.class, "recipe_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private RecipeDao recipeDao;

        private PopulateDbAsyncTask(RecipeDatabase db) {
            recipeDao = db.recipeDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            recipeDao.insert(new Recipe( "Mac n Cheese", "Box of mac with milk n butter", "add em together"));
            recipeDao.insert(new Recipe( "PBJ", "peanut butter and jelly", "use a butter knife"));
            recipeDao.insert(new Recipe( "taco", "stuff", "I don't know"));
            return null;
        }
    }
}
