package com.example.rxdrugs.inventory;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "inventoryy")
public class InventoryDB {

    @PrimaryKey(autoGenerate = true)
    public long id;
    public String brandName;
    public String generic;
    public String manufacturer;
    public String date;
    public int quantity;
    public double dose;
    public String type;

    public InventoryDB(String brandName, String generic, String manufacturer, String date, int quantity, double dose, String type) {
        this.brandName = brandName;
        this.generic = generic;
        this.manufacturer = manufacturer;
        this.date = date;
        this.quantity = quantity;
        this.dose = dose;
        this.type = type;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brand_name) {
        this.brandName = brand_name;
    }


    public String getGeneric() {
        return generic;
    }

    public void setGeneric(String generic) {
        this.generic = generic;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}


