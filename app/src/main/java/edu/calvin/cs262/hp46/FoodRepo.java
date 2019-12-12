package edu.calvin.cs262.hp46;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

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

    //_______________


//    public void updateParam( String name , double amount){
//
//        upParams UpParams = new upParams(name,amount);
//        new updateIngredientTableAsyncTask(miDao).execute(UpParams);
//    }
//
//    private static class updateIngredientTableAsyncTask extends AsyncTask<upParams,Void,Void>{
//        private iDao mAsyncTaskDao5;
//
//        public updateIngredientTableAsyncTask( iDao MIDAO){
//            mAsyncTaskDao5 = MIDAO;
//        }
//
//        @Override
//        protected Void doInBackground(upParams... myTaskParams) {
//            double amount =myTaskParams[0].amount;
//            String name = myTaskParams[0].name;
//            mAsyncTaskDao5.updateQuantity(name, amount);
//            return null;
//        }
//    }
//
//    public void getmyName1( String name ){
//
//        upParams2 UpParams = new upParams2(name);
//        new getMyNameAsyncTask(miDao).execute(UpParams);
//    }
//
//    private static class getMyNameAsyncTask extends AsyncTask<upParams2,Void,Void>{
//        private iDao mAsyncTaskDao6;
//
//        public getMyNameAsyncTask( iDao MIDAO){
//            mAsyncTaskDao6 = MIDAO;
//        }
//
//        @Override
//        protected Void doInBackground(upParams2... myTaskParams) {
//            String name = myTaskParams[0].name;
//            mAsyncTaskDao6.getMyName(name);
//            return null;
//        }
//    }


}

