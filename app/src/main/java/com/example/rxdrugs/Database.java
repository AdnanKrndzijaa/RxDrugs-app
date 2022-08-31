package com.example.rxdrugs;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.rxdrugs.alldrugs.DrugsDAO;
import com.example.rxdrugs.alldrugs.DrugsDB;
import com.example.rxdrugs.inventory.InventoryDB;
import com.example.rxdrugs.inventory.InventoryyDAO;

@androidx.room.Database(entities = {DrugsDB.class, InventoryDB.class},version = 1,exportSchema = false)
public abstract class Database extends RoomDatabase {
    public abstract DrugsDAO drugsDAO();
    public abstract InventoryyDAO inventoryyDAO();

    private static Database INSTANCE;
    public static Database getInstance(Context context) {
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,Database.class,"app_database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
