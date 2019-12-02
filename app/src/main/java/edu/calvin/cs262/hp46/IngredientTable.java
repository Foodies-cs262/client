package edu.calvin.cs262.hp46;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ingredient_table")
public class IngredientTable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID")
    private int IngredientID;

    @ColumnInfo(name = "Name")
    private String name;

    public IngredientTable(@NonNull int id, String inputName) {
        this.IngredientID = id;
        this.name = inputName;
    }

    public int getID() {
        return this.IngredientID;
    }

    public String getName() {
        return  this.name;
    }

}