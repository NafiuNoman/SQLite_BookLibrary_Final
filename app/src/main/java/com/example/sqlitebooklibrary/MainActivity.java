package com.example.sqlitebooklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Mydatabase mydatabase;
    ArrayList<String> id,bookName,bookAuthor,pages;
    MyAdaptor myAdaptor;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydatabase=new Mydatabase(this);
        id = new ArrayList<>();
        bookName = new ArrayList<>();
        bookAuthor = new ArrayList<>();
        pages = new ArrayList<>();

        storeDataInArray();

        recyclerView = findViewById(R.id.recycleId);

       //Log.i("onCreate: ","Executed 1");

        myAdaptor= new MyAdaptor(this,id,bookName,bookAuthor,pages);

       // Log.i("onCreate: ","Executed 2");


        recyclerView.setAdapter(myAdaptor);

       // Log.i("onCreate: ","Executed 3");
    }

    void storeDataInArray()
    {
        Cursor cursor = mydatabase.readAllData();

        if(cursor.getCount()==0)
        {
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
            
        }else{
            while (cursor.moveToNext())
            {
                id.add(cursor.getString(0));
                bookName.add(cursor.getString(1));
                bookAuthor.add(cursor.getString(2));
                pages.add(cursor.getString(3));
            }
        }


    }

    public void doSomething(View view) {

        /*Mydatabase database= new Mydatabase(this);

        //SQLiteDatabse db is a variable sunch as String..... getWritableDatabase gives SQLiteDatabse return type;
        SQLiteDatabase db =database.getWritableDatabase();

        database.onUpgrade(db,1,2);
        Toast.makeText(this, "done......", Toast.LENGTH_SHORT).show();*/



        Intent intent = new Intent(MainActivity.this,InsartionActivity.class);
        startActivity(intent);

    }
}