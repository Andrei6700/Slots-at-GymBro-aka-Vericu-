package com.example.pacanele;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter_recyclerView extends RecyclerView.Adapter<Adapter_recyclerView.MyViewHolder> {
    Context context;
    ArrayList<InstructionsHandler> movies;

    public Adapter_recyclerView(Context context, ArrayList<InstructionsHandler> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewTitle.setText(movies.get(position).getTitle());
        holder.textViewMessage.setText(movies.get(position).getMessage());
        holder.imageView.setImageResource(movies.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewTitle, textViewMessage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.posterImageView);
            textViewTitle = itemView.findViewById(R.id.titleTextView);
            textViewMessage = itemView.findViewById(R.id.textViewMessage);
        }
    }
}