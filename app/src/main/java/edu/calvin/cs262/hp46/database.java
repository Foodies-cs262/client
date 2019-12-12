package edu.calvin.cs262.hp46;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Food.class, IngredientTable.class, FoodIngredient.class}, version = 6, exportSchema = false)
public abstract class database extends RoomDatabase {

    public abstract fDao FDao();
    public  abstract fiDao FiDao();
    public  abstract  iDao IDao();

    private static database INSTANCE;

    static database getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            database.class, "food_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
//                            .addCallback(sRoomDatabaseCallback)
                }
            }
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final fDao FDao;
        private final iDao IDao;
        private final fiDao FiDao;

        PopulateDbAsync(database db) {
            FDao = db.FDao();
            IDao = db.IDao();
            FiDao = db.FiDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            FDao.deleteAllFood();
            IDao.deleteAllIngredient();
            FiDao.deleteFoodIngredient();


            return null;
        }
    }
}