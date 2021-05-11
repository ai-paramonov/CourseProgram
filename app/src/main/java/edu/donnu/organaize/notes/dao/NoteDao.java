package edu.donnu.organaize.notes.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.donnu.organaize.telephone.dao.Telephone;
@Dao
public interface NoteDao {

    @Query("SELECT * FROM note")
    List<Note> getAll();

    @Query("SELECT * FROM note WHERE id =:id")
    List<Note> getById(long id);

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

}

