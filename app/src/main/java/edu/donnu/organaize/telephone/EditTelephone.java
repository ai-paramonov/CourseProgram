package edu.donnu.organaize.telephone;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import edu.donnu.organaize.R;
import edu.donnu.organaize.telephone.dao.Telephone;
import edu.donnu.organaize.telephone.dao.TelephoneDatabase;

public class EditTelephone extends AppCompatActivity {

    private TelephoneDatabase database;
    private long id;
    private EditText name;
    private EditText number;
    private Telephone telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_telephone);
        database = Room.databaseBuilder(this, TelephoneDatabase.class, "databaseTel")
                .allowMainThreadQueries().build();
        Intent intent = getIntent();
        String temp = intent.getStringExtra("id");
        id = Long.parseLong(temp);
        name = findViewById(R.id.editTextFormName);
        number = findViewById(R.id.editTextFormNumber);
        telephone = database.telephoneDao().getById(id).get(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        name.setText(telephone.getName());
        number.setText(telephone.getNumber());
    }

    public void onUpdateContact(View view){

        String str_name = name.getText().toString();
        String str_number = number.getText().toString();

        Telephone tel = new Telephone(str_name , str_number);
        tel.setId(id);
        this.database.telephoneDao().update(tel);
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
                database.telephoneDao().delete(telephone);
                onBackPressed();
            }
        });
        builder.create().show();
    }
    public void onCancel(View view){
        onBackPressed();
    }
}

