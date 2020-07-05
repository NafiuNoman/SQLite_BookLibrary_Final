package com.example.sqlitebooklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsartionActivity extends AppCompatActivity {

    EditText book,author,page;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insartion);



        book = findViewById(R.id.bookNameId);
        author = findViewById(R.id.authorNameId);
        page = findViewById(R.id.pageId);
        addBtn = findViewById(R.id.buttonId);




    }

    public void doAdd(View view) {

        Mydatabase mydatabase = new Mydatabase(this);

        String bookname = book.getText().toString().trim();
        String authorname= author.getText().toString().trim();
        int pagenumber = Integer.parseInt(page.getText().toString());

        mydatabase.addBook(bookname,pagenumber,authorname);

        Intent intent  = new Intent(this,MainActivity.class);
        startActivity(intent);
    }






}