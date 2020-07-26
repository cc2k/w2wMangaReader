package com.example.what2watchmangareader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Classes.Manga;

public class MyAdapterRecyclerView extends RecyclerView.Adapter<MyAdapterRecyclerView.MyViewHolder> {
    private ArrayList<Manga> mDataSet;
    private Context context;

    public MyAdapterRecyclerView(ArrayList<Manga> dataSet, Context context) {
        mDataSet = dataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        //  final RecyclerView.ViewHolder holder = new MyViewHolder(view);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(mDataSet.get(position).getPosterPicture()).into(holder.imageviewBookCover);
        holder.tvBookTitle.setText("This is book nr: " + position + " and title " + mDataSet.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    private static OnMangaBookClickListener onMangaBookClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageviewBookCover;
        public TextView tvBookTitle;
        OnMangaBookClickListener onMangaBookClickListener;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageviewBookCover = itemView.findViewById(R.id.imageView_bookcover);
            tvBookTitle = itemView.findViewById(R.id.textView_booktitle);

            itemView.setOnClickListener((View.OnClickListener) onMangaBookClickListener);
        }


        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "WHAT?!", Toast.LENGTH_SHORT).show();
            onMangaBookClickListener.onMangaBookClick(getAdapterPosition(), view);
            Toast.makeText(view.getContext(), "WHAT?!", Toast.LENGTH_SHORT).show();
        }
    }

    public void setOnMangaBookClickListener(OnMangaBookClickListener onMangaBookClickListener) {
        MyAdapterRecyclerView.onMangaBookClickListener = onMangaBookClickListener;
    }

    public interface OnMangaBookClickListener {
        void onMangaBookClick(int position, View view);

    }
}
