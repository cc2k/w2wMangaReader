package com.example.what2watchmangareader;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Classes.Manga;

public class MyAdapterRecyclerView extends RecyclerView.Adapter<MyAdapterRecyclerView.MyViewHolder> {
    private ArrayList<Manga> mDataSet;
    private Context context;
    private OnMangaBookClickListener listener; //private?
    private PopupMenu.OnMenuItemClickListener menuItemClickListener;
    private FragmentActivity c;
    int containerId;

    public MyAdapterRecyclerView(ArrayList<Manga> dataSet, FragmentActivity context, OnMangaBookClickListener listener, int containerId) {
        mDataSet = dataSet;
        c = context;
        this.containerId = containerId;
        this.listener = listener;
        this.context = context.getApplicationContext();
       // this.menuItemClickListener = onMenuItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
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
            public void onClick(final View view) {
                PopupMenu popMenu = new PopupMenu(context, view);
                popMenu.getMenuInflater().inflate(R.menu.menu_mangas_search_book_option,popMenu.getMenu());


                popMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                       //return onMenuItemClick(menuItem);

                        Toast.makeText(context, "Selected Item: " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        switch (menuItem.getItemId()) {
                            case R.id.menus_search_book_details_manga_book:
//                                int containerId = holder.getAdapterPosition()+1;
                                 Bundle bundle = new Bundle();
                                        bundle.putParcelable("MangaBook", mDataSet.get(position));
                                        MangaBookFragment fragmentB = new MangaBookFragment();
                                        fragmentB.setArguments(bundle);
                                   c.getSupportFragmentManager().beginTransaction()
                                                .replace(containerId, fragmentB, "MangaBookFragment")
                                                .addToBackStack(null)
                                                .commit();
                                return true;
                            case R.id.menus_search_book_add_to_collection:
                                // do your code
                                return true;
                            case R.id.menus_search_book_read_manga:
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
