package edu.calvin.cs262.hp46;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Food_table")
public class Food {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID")
    private int foodID;

    @ColumnInfo(name = "Name")
    private String name;

    public Food(@NonNull int id, String inputName) {
        this.foodID = id;
        this.name = inputName;
    }

    public int getID(){return this.foodID;}
    public  String getName(){return  this.name;}
}