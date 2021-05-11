package edu.donnu.organaize.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import edu.donnu.organaize.R;
import edu.donnu.organaize.notes.dao.Note;
import edu.donnu.organaize.notes.dao.NoteDatabase;
import edu.donnu.organaize.telephone.dao.Telephone;
import edu.donnu.organaize.telephone.dao.TelephoneDatabase;

public class NewNotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_notes);
    }
    public void onCreateNewNote(View view){

        NoteDatabase db = Room.databaseBuilder(this, NoteDatabase.class, "databaseNote")
                .allowMainThreadQueries().build();

        EditText title = (EditText)findViewById(R.id.note_new_form_title);
        EditText text = (EditText)findViewById(R.id.note_new_form_text);
        String str_title = title.getText().toString();
        String str_text = text.getText().toString();

        Note note = new Note(str_title , str_text);
        db.noteDao().insert(note);
        onBackPressed();
    }

    public void onCancel(View view){
        onBackPressed();
    }
}