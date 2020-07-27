package com.example.what2watchmangareader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Classes.Manga;

public class MyAdapterRecyclerView extends RecyclerView.Adapter<MyAdapterRecyclerView.MyViewHolder> {
    private ArrayList<Manga> mDataSet;
    private Context context;
    private OnMangaBookClickListener listener; //private?

    public MyAdapterRecyclerView(ArrayList<Manga> dataSet, Context context, OnMangaBookClickListener listener) {
        mDataSet = dataSet;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Picasso.get().load(mDataSet.get(position).getPosterPicture()).into(holder.imageviewBookCover);
        holder.tvBookTitle.setText("This is book nr: " + position + " and title " + mDataSet.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listener.onMangaBookClick(position, mDataSet.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    private static OnMangaBookClickListener onMangaBookClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageviewBookCover;
        public TextView tvBookTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageviewBookCover = itemView.findViewById(R.id.imageView_bookcover);
            tvBookTitle = itemView.findViewById(R.id.textView_booktitle);
        }
    }


    public interface OnMangaBookClickListener {
        void onMangaBookClick(int position, Manga manga);

    }
}
