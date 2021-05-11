package edu.donnu.organaize.notes;

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
import edu.donnu.organaize.notes.dao.Note;
import edu.donnu.organaize.notes.dao.NoteDao;
import edu.donnu.organaize.notes.dao.NoteDatabase;


public class NotesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private NoteDatabase database ;

    private NoteDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.addView(new EditText(this));
        Button button = new Button(this);
        button.setText(R.string.search);
        toolbar.addView(button);
        setSupportActionBar(toolbar);

        Intent intent = new Intent(this, NewNotesActivity.class);
        FloatingActionButton fab = findViewById(R.id.fabNotes);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        database = Room.databaseBuilder(this, NoteDatabase.class, "databaseNote")
                .allowMainThreadQueries().build();
        List<Note> list = database.noteDao().getAll();
        Log.d("EROORRRR", list.toString());
        Note note = new Note("11","11");
        note.setId(0);
        database.noteDao().delete(note);
        List<Note> notes = database.noteDao().getAll();
        this.recyclerView = (RecyclerView) this.findViewById(R.id.notesContainer);
        recyclerView.setAdapter(new NoteAdapter(notes, this));

        // RecyclerView scroll vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


    }
    protected void onResume() {
        super.onResume();
        database = Room.databaseBuilder(this, NoteDatabase.class, "databaseNote")
                .allowMainThreadQueries().build();
        List<Note> notes = database.noteDao().getAll();
        this.recyclerView = (RecyclerView) this.findViewById(R.id.notesContainer);
        recyclerView.setAdapter(new NoteAdapter(notes, this));

        // RecyclerView scroll vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    public void onClicikingNote(View view){
        TextView textView = (TextView) view.findViewById(R.id.ntHiddenId);
        String s = (String) textView.getText();
        Intent intent = new Intent(this , EditNotesActivity.class);
        intent.putExtra("id",s);
        startActivity(intent);
    }
}