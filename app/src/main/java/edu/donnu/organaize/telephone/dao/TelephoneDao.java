package edu.donnu.organaize.telephone.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TelephoneDao {

    @Query("SELECT * FROM telephone")
    List<Telephone> getAll();

    @Query("SELECT * FROM telephone WHERE id =:id")
    List<Telephone> getById(long id);

    @Insert
    void insert(Telephone telephone);

    @Update
    void update(Telephone telephone);

    @Delete
    void delete(Telephone telephone);

}
