package edu.calvin.cs262.hp46;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Food.class, IngredientTable.class, FoodIngredient.class}, version = 1, exportSchema = false)
public abstract class database extends RoomDatabase {

    public abstract FIDao FIDao();
    private static database INSTANCE;

    static database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            database.class, "fi_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}