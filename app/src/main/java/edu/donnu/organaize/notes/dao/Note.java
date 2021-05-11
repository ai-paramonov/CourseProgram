package edu.donnu.organaize.notes.dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;

    private String text;

    public long getId() {
        return id;
    }

    public Note(String title , String text){
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return title + '\n' + text;

    }
}
