package edu.donnu.organaize.telephone;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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

import java.util.ArrayList;
import java.util.List;

import edu.donnu.organaize.R;
import edu.donnu.organaize.telephone.dao.Telephone;
import edu.donnu.organaize.telephone.dao.TelephoneDao;
import edu.donnu.organaize.telephone.dao.TelephoneDatabase;

public class TelephoneActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private TelephoneDatabase database ;

    private TelephoneDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephone);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.addView(new EditText(this));
        Button button = new Button(this);
        button.setText(R.string.search);
        toolbar.addView(button);
        setSupportActionBar(toolbar);

        Intent intent = new Intent(this, NewTelephone.class);
        FloatingActionButton fab = findViewById(R.id.fabTele);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        database = Room.databaseBuilder(this, TelephoneDatabase.class, "databaseTel")
                .allowMainThreadQueries().build();
        List<Telephone> phoneNumbers = database.telephoneDao().getAll();
        this.recyclerView = (RecyclerView) this.findViewById(R.id.telephonesContainer);
        recyclerView.setAdapter(new TelephoneAdapter( phoneNumbers, this));

        // RecyclerView scroll vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


    }

    @Override
    protected void onResume() {
        super.onResume();
        database = Room.databaseBuilder(this, TelephoneDatabase.class, "databaseTel")
                .allowMainThreadQueries().build();
        List<Telephone> phoneNumbers = database.telephoneDao().getAll();
        this.recyclerView = (RecyclerView) this.findViewById(R.id.telephonesContainer);
        recyclerView.setAdapter(new TelephoneAdapter(phoneNumbers, this));

        // RecyclerView scroll vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void onClicikingContact(View view){
        TextView textView = (TextView) view.findViewById(R.id.tpHiddenId);
        String s = (String) textView.getText();
        Intent intent = new Intent(this , EditTelephone.class);
        intent.putExtra("id",s);
        startActivity(intent);
    }
}