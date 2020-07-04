package com.example.sqlitebooklibrary;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        holder.Id.setText(String.valueOf(bookId.get(position)));

        holder.bookNameId.setText(String.valueOf(bookNameId.get(position)));

        holder.authorNameId.setText(String.valueOf(authorNameId.get(position)));
        //this authorNameId kiis my 2 hours hahaha.....beacuse i gives the worng id to MyViewHolder class only A was small latter that my fault
        //Log.i("BIND", "onBindViewHolder: 4");

        holder.pagesId.setText(String.valueOf(pagesId.get(position)));

       // Log.i("BIND", "onBindViewHolder: 5");


    }

    @Override
    public int getItemCount() {
        return bookNameId.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView bookNameId,Id,authorNameId, pagesId;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bookNameId=itemView.findViewById(R.id.bookNameId);
            Id = itemView.findViewById(R.id.bookId);
            authorNameId = itemView.findViewById(R.id.AuthorNameId);
            pagesId = itemView.findViewById(R.id.pageId);


        }
    }
}
