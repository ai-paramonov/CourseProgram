package edu.donnu.organaize.calendar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.donnu.organaize.R;
import edu.donnu.organaize.calendar.dao.Calendar;
import edu.donnu.organaize.calendar.dao.CalendarDatabase;
import edu.donnu.organaize.notes.dao.Note;

public class EditCalendarActivity extends AppCompatActivity {

    private CalendarDatabase database;
    private long id;
    private EditText title;
    private EditText data;
    private EditText adres;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_calendar);
        database = Room.databaseBuilder(this, CalendarDatabase.class, "databaseCalen")
                .allowMainThreadQueries().build();
        Intent intent = getIntent();
        String temp = intent.getStringExtra("id");
        id = Long.parseLong(temp);
        title = findViewById(R.id.calendar_edit_form_title);
        data = findViewById(R.id.calendar_edit_form_data);
        adres = findViewById(R.id.calendar_edit_form_adres);
        calendar = database.calendarDao().getById(id).get(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        title.setText(calendar.getTitle());
        data.setText(calendar.getData());
        adres.setText(calendar.getAdres());
    }

    public void onUpdateContact(View view){

        String str_title = title.getText().toString();
        String str_data = data.getText().toString();
        String str_adres = adres.getText().toString();

        Calendar calendar = new Calendar(str_title , str_data,str_adres);
        calendar.setId(id);
        this.database.calendarDao().update(calendar);
        onBackPressed();

    }
    public void onDeleteContact(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialogTitle);
        builder.setMessage(R.string.dialogMassage);
        builder.setNegativeButton(R.string.dialogNo,null);
        builder.setPositiveButton(R.string.dialogYes,new Dialog.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                database.calendarDao().delete(calendar);
                onBackPressed();
            }
        });
        builder.create().show();
    }
    public void onCancel(View view){
        onBackPressed();
    }
}