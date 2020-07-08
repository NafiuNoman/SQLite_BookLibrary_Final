package com.example.sqlitebooklibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText bookName, authorName,page;
    Button update;
    String id,book,author,pageCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        bookName =findViewById(R.id.bookNameId2);
        authorName =findViewById(R.id.authorNameId2);
        page=findViewById(R.id.pageId2);
        update=findViewById(R.id.updateBtn);

        getIntentDataAndShow();



    }

    public void doUpdate(View view) {

        Mydatabase db = new Mydatabase(this);
         book = bookName.getText().toString().trim();
         author= authorName.getText().toString().trim();
         pageCount= page.getText().toString();
         db.updateData(id,book,author,pageCount);

         Intent intent = new Intent(this,MainActivity.class);
         startActivity(intent);

    }



    public void doDelete(View view) {

        confirmationDialog();

    }



    public void confirmationDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Delete "+book+" !");
        builder.setMessage(" Proceed to delete ?");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Mydatabase db = new Mydatabase(UpdateActivity.this);
                db.deleteData(id);

                Intent intent = new Intent(UpdateActivity.this,MainActivity.class);
                startActivity(intent);



            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = new Intent(UpdateActivity.this,MainActivity.class);
                startActivity(intent);


            }
        });

        builder.create();
        builder.show();



    }


    void getIntentDataAndShow()
    {
        if(getIntent().hasExtra("bookName")&&getIntent().hasExtra("authorName")&&getIntent().hasExtra("pageNumber") && getIntent().hasExtra("id"))
        {
            book=getIntent().getStringExtra("bookName");
            author=getIntent().getStringExtra("authorName");
            pageCount=getIntent().getStringExtra("pageNumber");
            id=getIntent().getStringExtra("id");



            bookName.setText(book);
            authorName.setText(author);
            page.setText(pageCount);



        }else Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();


    }


}