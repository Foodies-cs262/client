package edu.calvin.cs262.hp46;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {

    private FIDao mWordDao;
    private LiveData<List<FoodIngredient>> mAllWords;

    Repository(Application application) {
        database db = database.getDatabase(application);
        mWordDao = db.FIDao();
        mAllWords = mWordDao.getAll();
    }

    LiveData<List<FoodIngredient>> getAllWords() {
        return mAllWords;
    }

    public void insert (FoodIngredient FI) {
        new insertAsyncTask(mWordDao).execute((Runnable) FI);
    }

    private static class insertAsyncTask extends AsyncTask<Food, Void, Void>{

        private FIDao mAsyncTaskDao;

        insertAsyncTask(FIDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Food... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}