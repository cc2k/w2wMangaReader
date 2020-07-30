package com.example.what2watchmangareader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Classes.Manga;

public class MyAdapterRecyclerView extends RecyclerView.Adapter<MyAdapterRecyclerView.MyViewHolder> {
    private ArrayList<Manga> mDataSet;
    private Context context;
    private OnMangaBookClickListener listener; //private?
    private PopupMenu.OnMenuItemClickListener menuItemClickListener;

    public MyAdapterRecyclerView(ArrayList<Manga> dataSet, Context context, OnMangaBookClickListener listener) {
        mDataSet = dataSet;
        this.context = context;
        this.listener = listener;
       // this.menuItemClickListener = onMenuItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Picasso.get().load(mDataSet.get(position).getPosterPicture()).into(holder.imageViewBookCover);
        holder.tvBookTitle.setText("This is book nr: " + position + " and title " + mDataSet.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                listener.onMangaBookClick(position, mDataSet.get(position));
            }
        });

        holder.imageViewBookCoverMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popMenu = new PopupMenu(context.getApplicationContext(), view);
                popMenu.getMenuInflater().inflate(R.menu.menu_mangas_search_book_option,popMenu.getMenu());


                popMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                       //return onMenuItemClick(menuItem);

                        Toast.makeText(context, "Selected Item: " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        switch (menuItem.getItemId()) {
                            case R.id.mail:
                                // do your code
                                return true;
                            case R.id.share:
                                // do your code
                                return true;
                            case R.id.upload:
                                // do your code
                                return true;
                            default:
                                break;
                        }
                        return false;

                 //      return false;
                    }
                });
                popMenu.show();
             //   return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    private static OnMangaBookClickListener onMangaBookClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewBookCover;
        public TextView tvBookTitle;
        public ImageView imageViewBookCoverMenu;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewBookCover = itemView.findViewById(R.id.iv_book_cover);
            tvBookTitle = itemView.findViewById(R.id.tv_book_title);
            imageViewBookCoverMenu = itemView.findViewById(R.id.iv_book_cover_menu);
        }
    }


    public interface OnMangaBookClickListener {
        void onMangaBookClick(int position, Manga manga);

    }

    public interface  OnMenuItemClick{
        boolean onMenuItemClick(MenuItem menuItem);
    }


}
