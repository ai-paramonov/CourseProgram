package edu.donnu.organaize.telephone.dao;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Telephone {


    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;
    @ColumnInfo(index = true)
    private String number;

    public Telephone(){

    }
    public Telephone(String name , String telephoneNumber){
        this.name = name;
        this.number = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.name + ",Number: " + this.number;
    }
}
