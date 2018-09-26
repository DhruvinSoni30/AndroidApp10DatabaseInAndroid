package com.example.kalpeshsoni.p10;

import android.app.AlertDialog;
import android.database.Cursor;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editSurname,editContactno,editTextId;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editName =  findViewById(R.id.editText_name);
        editSurname =  findViewById(R.id.editText_surname);
        editContactno =  findViewById(R.id.editText_Contactno);
        editTextId = findViewById(R.id.editText_id);
        btnAddData = findViewById(R.id.button_add);
        AddData();
    }
        public  void AddData() {
            btnAddData.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            boolean isInserted = myDb.insertData(editName.getText().toString(),
                                    editSurname.getText().toString(),
                                    editContactno.getText().toString() );
                            if(isInserted == true)
                                Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                        }
                    }
            );
        }
    }
