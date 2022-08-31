package com.example.rxdrugs.inventory;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface InventoryyDAO {

    @Insert
    void add(InventoryDB inventoryDB);

    @Query("SELECT * FROM inventoryy")
    List<InventoryDB> getAll();

    @Query("SELECT * FROM inventoryy WHERE id = :id LIMIT 1")
    InventoryDB getById(long id);

    @Delete
    void delete(InventoryDB inventoryDB);

    @Update
    void update(InventoryDB inventoryDB);
}
