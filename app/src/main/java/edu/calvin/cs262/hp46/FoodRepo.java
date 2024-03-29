package edu.calvin.cs262.hp46;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
/**
 * @author Hamin Hong
 * FoodRepo acts as a class where data are temporarily stored in between
 * the database and its client classes.
 * */
public class FoodRepo {

    private fDao mfDao;
    private LiveData<List<Food>> allFood;

    private iDao miDao;
    private LiveData<List<IngredientTable>> allIngredient;

    private fiDao mfiDao;
    private LiveData<List<FoodIngredient>> allQuantity;

    FoodRepo(Application application) {
        database db = database.getDatabase(application);
        mfDao = db.FDao();
        allFood = mfDao.getAllFood();
        miDao = db.IDao();
        allIngredient = miDao.getAllIngredient();
        mfiDao = db.FiDao();
        allQuantity = mfiDao.getAllQuantity();
    }

    LiveData<List<Food>> getAllFood() {
        return allFood;
    }

    LiveData<List<IngredientTable>> getAllIngredient() {
        return allIngredient;
    }

    LiveData<List<FoodIngredient>> getAllQuantity() {
        return allQuantity;
    }


    public void insert (Food food) {
        new insertFoodAsyncTask(mfDao).execute(food);
    }

    private static class insertFoodAsyncTask extends AsyncTask<Food, Void, Void> {

        private fDao mAsyncTaskDao;

        insertFoodAsyncTask(fDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Food... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    public void insert (IngredientTable ingredientTable) {
        new insertIngredientAsyncTask(miDao).execute(ingredientTable);
    }

    private static class insertIngredientAsyncTask extends AsyncTask<IngredientTable, Void, Void> {

        private iDao mAsyncTaskDao2;

        insertIngredientAsyncTask(iDao dao) {
            mAsyncTaskDao2 = dao;
        }

        @Override
        protected Void doInBackground(final IngredientTable... params) {
            mAsyncTaskDao2.insert(params[0]);
            return null;
        }
    }

    public void insert (FoodIngredient foodIngredient) {
        new insertFoodIngredientAsyncTask(mfiDao).execute(foodIngredient);
    }

    private static class insertFoodIngredientAsyncTask extends AsyncTask<FoodIngredient, Void, Void> {

        private fiDao mAsyncTaskDao3;

        insertFoodIngredientAsyncTask(fiDao dao) {
            mAsyncTaskDao3 = dao;
        }

        @Override
        protected Void doInBackground(final FoodIngredient... params) {
            mAsyncTaskDao3.insert(params[0]);
            return null;
        }
    }

    private static class deleteIngredientTableAsyncTask extends AsyncTask<IngredientTable, Void, Void> {
        private iDao mAsyncTaskDao4;

        deleteIngredientTableAsyncTask(iDao dao) {
            mAsyncTaskDao4 = dao;
        }

        @Override
        protected Void doInBackground(final IngredientTable... params) {
            mAsyncTaskDao4.deleteIngredientTable(params[0]);
            return null;
        }
    }

    public void deleteIngredientTable(IngredientTable ingredientTable)  {
        new deleteIngredientTableAsyncTask(miDao).execute(ingredientTable);
    }


}

