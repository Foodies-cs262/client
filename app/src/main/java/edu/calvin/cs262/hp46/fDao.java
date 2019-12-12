package edu.calvin.cs262.hp46;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * @author Hamin Hong
 * fDao is Dao for the Food table
 * */
@Dao
public interface fDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert( Food food);

    @Query("DELETE FROM Food_table")
    void deleteAllFood();

    @Query("SELECT * from Food_table ORDER BY Name ASC")
    LiveData<List<Food>> getAllFood();
}