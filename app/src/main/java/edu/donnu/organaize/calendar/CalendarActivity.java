package edu.donnu.organaize.calendar;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import edu.donnu.organaize.R;
import edu.donnu.organaize.calendar.dao.Calendar;
import edu.donnu.organaize.calendar.dao.CalendarDao;
import edu.donnu.organaize.calendar.dao.CalendarDatabase;



public class CalendarActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private CalendarDatabase database ;

    private CalendarDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.addView(new EditText(this));
        Button button = new Button(this);
        button.setText(R.string.search);
        toolbar.addView(button);
        setSupportActionBar(toolbar);

        Intent intent = new Intent(this, NewCalendarActivity.class);
        FloatingActionButton fab = findViewById(R.id.fabCalend);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        database = Room.databaseBuilder(this, CalendarDatabase.class, "databaseCalen")
                .allowMainThreadQueries().build();
        List<Calendar> list = database.calendarDao().getAll();
        this.recyclerView = (RecyclerView) this.findViewById(R.id.calendarContainer);
        recyclerView.setAdapter(new CalendarAdapter(list, this));

        // RecyclerView scroll vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


    }
    protected void onResume() {
        super.onResume();
        database = Room.databaseBuilder(this, CalendarDatabase.class, "databaseCalen")
                .allowMainThreadQueries().build();
        List<Calendar> list = database.calendarDao().getAll();
        this.recyclerView = (RecyclerView) this.findViewById(R.id.calendarContainer);
        recyclerView.setAdapter(new CalendarAdapter(list, this));

        // RecyclerView scroll vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    public void onClicikingNote(View view){
        TextView textView = (TextView) view.findViewById(R.id.clHiddenId);
        String s = (String) textView.getText();
        Intent intent = new Intent(this , EditCalendarActivity.class);
        intent.putExtra("id",s);
        startActivity(intent);
    }
}