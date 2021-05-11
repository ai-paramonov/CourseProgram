package edu.donnu.organaize.telephone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import edu.donnu.organaize.R;
import edu.donnu.organaize.telephone.dao.Telephone;
import edu.donnu.organaize.telephone.dao.TelephoneDatabase;

public class NewTelephone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_telephone);
    }
    public void onCreateNewContact(View view){

        TelephoneDatabase db = Room.databaseBuilder(this, TelephoneDatabase.class, "databaseTel")
                .allowMainThreadQueries().build();

        EditText name = findViewById(R.id.telephone_edit_name);
        EditText number = findViewById(R.id.telephone_edit_number);
        String str_name = name.getText().toString();
        String str_number = number.getText().toString();

        Telephone telephone = new Telephone(str_name , str_number);
        db.telephoneDao().insert(telephone);
        onBackPressed();
    }
}