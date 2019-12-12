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

    @ColumnInfo(name = "Quantity")
    private double quantity;

    @ColumnInfo(name = "unit")
    private String unit;

    public IngredientTable(@NonNull int IngredientID, String name, double quantity, String unit) {
        this.IngredientID = IngredientID;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }


    public void setQuantity( double quantity) {
        this.quantity = quantity;
    }

    public int getIngredientID() {
        return this.IngredientID;
    }

    public String getName() {
        return this.name;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public String getUnit() { return this.unit; }

}