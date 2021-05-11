package edu.donnu.organaize.telephone.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Telephone.class},version = 1)
public abstract class TelephoneDatabase extends RoomDatabase {
    public abstract TelephoneDao telephoneDao();
}
