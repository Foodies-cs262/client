package edu.calvin.cs262.hp46;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Ingredient_table")
public class IngredientTable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID")
    private int IngredientID;

    @ColumnInfo(name = "Name")
    private String name;

    public IngredientTable(@NonNull int IngredientID, String name) {
        this.IngredientID = IngredientID;
        this.name = name;
    }

    public int getIngredientID() {
        return this.IngredientID;
    }

    public String getName() {
        return  this.name;
    }

}