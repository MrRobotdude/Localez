package com.project.localez;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<Model> modelArrayList;

    public RecyclerViewAdapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, WebView.class);
            intent.putExtra("url", modelArrayList.get(position).getUrl());
            context.startActivity(intent);
        });

        holder.ttime.setText("Published in: - " +modelArrayList.get(position).getPublishedAt());
        holder.aauthor.setText(modelArrayList.get(position).getAuthor());
        holder.hheader.setText(modelArrayList.get(position).getTitle());
        holder.ccontent.setText(modelArrayList.get(position).getDescription());
        Glide.with(context).load(modelArrayList.get(position).getUrlToImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView hheader, ccontent, aauthor, ttime;
        CardView cardView;
        ImageView imageView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            hheader=itemView.findViewById(R.id.header);
            ccontent=itemView.findViewById(R.id.content);
            aauthor=itemView.findViewById(R.id.author);
            ttime=itemView.findViewById(R.id.published);
            imageView=itemView.findViewById(R.id.imageview);
            cardView=itemView.findViewById(R.id.cardview);

        }
    }
}
