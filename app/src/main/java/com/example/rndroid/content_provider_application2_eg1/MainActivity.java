package com.example.rndroid.content_provider_application2_eg1;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editTextName, editTextSub;
    TextView textView;
    Button buttonRead, buttonInsert;
    Uri_Provider uri_provider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonInsert = (Button) findViewById(R.id.buttonInsert);
        buttonRead= (Button) findViewById(R.id.buttonRead);
        textView = (TextView) findViewById(R.id.textview);
        editTextName = (EditText) findViewById(R.id.edName);
        editTextSub = (EditText) findViewById(R.id.edSub);

        buttonInsert.setOnClickListener(this);
        buttonRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonInsert:
                // client want to insert details into FIRST URI - STUDENT_URI
                ContentResolver contentResolver = getContentResolver();
                String s1 = editTextName.getText().toString();
                String s2 = editTextSub.getText().toString();
                ContentValues values = new ContentValues();
                values.put(Uri_Provider.NAME, s1);
                values.put(Uri_Provider.SUB, s2);
                // now insert
                contentResolver.insert(Uri_Provider.STUDENT_URI, values);
                break;
            case R.id.buttonRead:
                ContentResolver contentResolver1 = getContentResolver();
                Cursor c = contentResolver1.query(Uri_Provider.STUDENT_URI,null,null,null,null);
                StringBuilder stringBuilder = new StringBuilder();
                if (c != null){
                    while (c.moveToNext()){
                        int no = c.getInt(0);
                        String name = c.getString(1);
                        String sub = c.getString(2);
                    stringBuilder.append("Id - "+no+" Name - "+name+" Subject - "+sub);
                    }
                    textView.setText(stringBuilder.toString());
                }
                break;
        }
    }
}
