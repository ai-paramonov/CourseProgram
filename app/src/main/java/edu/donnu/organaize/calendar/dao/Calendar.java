package edu.donnu.organaize.calendar.dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Calendar {
    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;
    private String data;
    private String adres;

    public Calendar() {

    }

    public Calendar(String title, String data, String adress) {
        this.title = title;
        this.data = data;
        this.adres = adres;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getData() {
        return data;
    }

    public String getAdres() {
        return adres;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setAdres(String adress) {
        this.adres = adress;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                "title='" + title + '\'' +
                ", data='" + data + '\'' +
                ", adress='" + adres + '\'' +
                '}';
    }
}
