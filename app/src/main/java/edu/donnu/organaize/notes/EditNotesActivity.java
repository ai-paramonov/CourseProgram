package edu.donnu.organaize.notes;

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
import edu.donnu.organaize.notes.dao.Note;
import edu.donnu.organaize.notes.dao.NoteDatabase;
import edu.donnu.organaize.telephone.dao.Telephone;
import edu.donnu.organaize.telephone.dao.TelephoneDatabase;

public class EditNotesActivity extends AppCompatActivity {

    private NoteDatabase database;
    private long id;
    private EditText title;
    private EditText text;
    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_notes);
        database = Room.databaseBuilder(this, NoteDatabase.class, "databaseNote")
                .allowMainThreadQueries().build();
        Intent intent = getIntent();
        String temp = intent.getStringExtra("id");
        id = Long.parseLong(temp);
        title = findViewById(R.id.note_edit_form_title);
        text = findViewById(R.id.note_edit_form_text);
        note = database.noteDao().getById(id).get(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        title.setText(note.getTitle());
        text.setText(note.getText());
    }

    public void onUpdateContact(View view){

        String str_title = title.getText().toString();
        String str_text = text.getText().toString();

        Note note = new Note(str_title , str_text);
        note.setId(id);
        this.database.noteDao().update(note);
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
                database.noteDao().delete(note);
                onBackPressed();
            }
        });
        builder.create().show();
    }
    public void onCancel(View view){
        onBackPressed();
    }
}