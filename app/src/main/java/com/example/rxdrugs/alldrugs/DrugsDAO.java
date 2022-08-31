package com.example.rxdrugs.alldrugs;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DrugsDAO {

    @Insert
    void add(DrugsDB drugsDB);

    @Query("SELECT * FROM drugs ORDER BY `desc`")
    List<DrugsDB> getAll();

    @Query("SELECT * FROM drugs WHERE id = :id LIMIT 1")
    DrugsDB getDrugById(long id);

    @Query("SELECT * FROM drugs WHERE type = :type ORDER BY brandName ASC")
    List<DrugsDB> getByType(String type);

    @Delete
    void delete(DrugsDB drugsDB);

    @Update
    void updateUser(DrugsDB drugsDB);

    @Query("DELETE FROM drugs")
    void deleteAll();
}
