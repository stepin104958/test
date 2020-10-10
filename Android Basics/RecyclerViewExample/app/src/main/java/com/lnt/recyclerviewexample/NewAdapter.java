package com.lnt.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.MyViewHolder>{

    ArrayList<String> personNames;
    ArrayList<String> lastName;
    ArrayList<Integer> file;
    Context context;


    public NewAdapter(Context context, ArrayList<String> personNames , ArrayList<String> lastName){
        this.context = context;
        this.personNames = personNames;
        this.lastName = lastName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //inflate the item layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);
        //set th view's size, margin, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
    // set the data in items
        holder.name.setText(personNames.get(position));
        holder.TextViewLastName.setText(lastName.get(position));
        //implement setOnClickListener event on item view.


        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context,personNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return personNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView TextViewLastName;
        ImageView imageViewIcon;
        public MyViewHolder(View itemView){
            super(itemView);
            TextViewLastName = (TextView) itemView.findViewById(R.id.lName);
            imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
            name= (TextView) itemView.findViewById(R.id.name);
        }
    }
}
