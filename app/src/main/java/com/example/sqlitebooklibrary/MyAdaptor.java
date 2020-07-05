package com.example.sqlitebooklibrary;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdaptor extends RecyclerView.Adapter <MyAdaptor.MyViewHolder> {

    Context context;
    ArrayList<String> bookId,bookNameId,authorNameId,pagesId;

    public MyAdaptor (Context context, ArrayList<String> bookId, ArrayList<String > bookNameId, ArrayList<String> authorNameId, ArrayList<String> pagesId) {

        this.context      = context;
        this.bookId       = bookId;
        this.bookNameId   = bookNameId;
        this.authorNameId = authorNameId;
        this.pagesId      = pagesId;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.Id.setText(String.valueOf(bookId.get(position)));

        holder.bookNameId.setText(String.valueOf(bookNameId.get(position)));

        holder.authorNameId.setText(String.valueOf(authorNameId.get(position)));
        //this authorNameId killed my 2 hours hahaha.....because i gave the wrong id to MyViewHolder class only A was small latter that my fault
        //Log.i("BIND", "onBindViewHolder: 4");

        holder.pagesId.setText(String.valueOf(pagesId.get(position)));

       // Log.i("BIND", "onBindViewHolder: 5");

       holder.rowId.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(context,UpdateActivity.class);

               intent.putExtra("bookName",String.valueOf(bookNameId.get(position)));
               intent.putExtra("authorName",String.valueOf(authorNameId.get(position)));
               intent.putExtra("pageNumber",String.valueOf(pagesId.get(position)));

               context.startActivity(intent);
           }
       });


    }

    @Override
    public int getItemCount() {
        return bookNameId.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView bookNameId,Id,authorNameId, pagesId;
        LinearLayout rowId;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bookNameId=itemView.findViewById(R.id.bookNameId);
            Id = itemView.findViewById(R.id.bookId);
            authorNameId = itemView.findViewById(R.id.AuthorNameId);
            pagesId = itemView.findViewById(R.id.pageId);
            rowId=   itemView.findViewById(R.id.myRowId);


        }
    }
}
