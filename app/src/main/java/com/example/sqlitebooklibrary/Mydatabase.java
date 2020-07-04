package com.example.sqlitebooklibrary;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class Mydatabase extends SQLiteOpenHelper {

    private static final String dataBaseName ="book.db" ;
    private static final int dataBaseVersion=3;
    Context context;
    public Mydatabase(@Nullable Context context) {

        super(context, dataBaseName, null, dataBaseVersion);
        this.context=context;


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String qury="CREATE TABLE my_book ( id INTEGER PRIMARY KEY AUTOINCREMENT , book_name TEXT , author_name TEXT , page_number INTEGER );";

        db.execSQL(qury);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String qury="DROP TABLE IF EXISTS my_book";
        db.execSQL(qury);
        onCreate(db);

    }



     void addBook(String bookName,int pages,String authorName)
    {

        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues contentValues = new ContentValues();

        contentValues.put("book_name",bookName);
        contentValues.put("page_number",pages);
        contentValues.put("author_name",authorName);


       long row = db.insert("my_book",null,contentValues);

       if (row==-1)
       {
           Toast.makeText(context, "Failed to insert", Toast.LENGTH_SHORT).show();


       }else Toast.makeText(context, "Successfully added", Toast.LENGTH_SHORT).show();

    }


    Cursor readAllData()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String qury =" SELECT *FROM my_book ";
        Cursor cursor = null;

        if(db!=null){
            cursor = db.rawQuery(qury,null);
        }

        return cursor;
    }

}

