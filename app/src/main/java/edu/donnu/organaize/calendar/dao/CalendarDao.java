package edu.donnu.organaize.calendar.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CalendarDao {
    @Query("SELECT * FROM calendar")
    List<Calendar> getAll();

    @Query("SELECT * FROM calendar WHERE id =:id")
    List<Calendar> getById(long id);

    @Insert
    void insert(Calendar calendar);

    @Update
    void update(Calendar calendar);

    @Delete
    void delete(Calendar calendar);

}

