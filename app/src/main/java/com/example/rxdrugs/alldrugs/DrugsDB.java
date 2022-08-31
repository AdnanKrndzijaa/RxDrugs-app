package com.example.rxdrugs.alldrugs;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "drugs")
public class DrugsDB {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String brandName;
    private String generic;
    private String manufacturer;
    private String type;
    private double dose;
    private int amount;
    private String desc;
    private int image;

    public DrugsDB(String brandName, String generic, String manufacturer, String type, double dose, int amount, String desc, int image) {
        this.brandName = brandName;
        this.generic = generic;
        this.manufacturer = manufacturer;
        this.type = type;
        this.dose = dose;
        this.amount = amount;
        this.desc = desc;
        this.image = image;

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


    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}

