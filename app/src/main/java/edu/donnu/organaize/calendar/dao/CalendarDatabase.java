package edu.donnu.organaize.calendar.dao;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.RoomDatabase;

@Database(entities = {Calendar.class},version = 1)
public abstract class CalendarDatabase extends RoomDatabase {
    public abstract CalendarDao calendarDao();
}
