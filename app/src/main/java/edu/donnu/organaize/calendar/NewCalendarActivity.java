package edu.donnu.organaize.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.donnu.organaize.R;
import edu.donnu.organaize.calendar.dao.Calendar;
import edu.donnu.organaize.calendar.dao.CalendarDatabase;
import edu.donnu.organaize.notes.dao.Note;
import edu.donnu.organaize.notes.dao.NoteDatabase;

public class NewCalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_calendar);
    }
    public void onCreateNewCalendar(View view){

        CalendarDatabase db = Room.databaseBuilder(this, CalendarDatabase.class, "databaseCalen")
                .allowMainThreadQueries().build();

        EditText title = (EditText)findViewById(R.id.calendar_new_title);
        EditText adres = (EditText)findViewById(R.id.calendar_new_adres);
        EditText date = (EditText)findViewById(R.id.calendar_new_date);
        String str_title = title.getText().toString();
        String str_adres= adres.getText().toString();
        String str_data = date.getText().toString();

        Calendar calendar = new Calendar(str_title , str_adres,str_data);
        db.calendarDao().insert(calendar);
        onBackPressed();
    }

    public void onCancel(View view){
        onBackPressed();
    }
}
