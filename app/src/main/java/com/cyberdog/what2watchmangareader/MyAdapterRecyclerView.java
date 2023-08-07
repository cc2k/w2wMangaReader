package com.cyberdog.what2watchmangareader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Classes.Manga;

public class MyAdapterRecyclerView extends RecyclerView.Adapter<MyAdapterRecyclerView.MyViewHolder> {
    public ArrayList<Manga> mDataSet;
    private Context context;
    private OnMangaBookClickListener listener;
    private FragmentActivity c;
    int containerId;

    public MyAdapterRecyclerView(ArrayList<Manga> dataSet, FragmentActivity context, OnMangaBookClickListener listener, int containerId) {
        mDataSet = dataSet;
        c = context;
        this.containerId = containerId;
        this.listener = listener;
        this.context = context.getApplicationContext();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_item, parent, false);
        return new MyViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        Picasso.get().load(mDataSet.get(position).getPosterPicture()).into(holder.imageViewBookCover);
        holder.tvBookTitle.setText("This is book nr: " + position + " and title " + mDataSet.get(position).getTitle());
      }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewBookCover;
        public TextView tvBookTitle;
        public ImageView imageViewBookCoverMenu;
        OnMangaBookClickListener onMangaBookClickListener;

        public MyViewHolder(@NonNull final View itemView, final OnMangaBookClickListener onMangaBookClickListener) {
            super(itemView);
            this.onMangaBookClickListener = onMangaBookClickListener;
            imageViewBookCover = itemView.findViewById(R.id.iv_book_cover);
            tvBookTitle = itemView.findViewById(R.id.tv_book_title);
            imageViewBookCoverMenu = itemView.findViewById(R.id.iv_book_cover_menu);

            imageViewBookCover.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    onMangaBookClickListener.onMangaBookClick(getAdapterPosition(), mDataSet.get(getAdapterPosition()));
                }
            });

            imageViewBookCoverMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    onMangaBookClickListener.onMangaBookMenuClick(getAdapterPosition(),mDataSet.get(getAdapterPosition()));
                        }
                    });
                }

    }

    public interface OnMangaBookClickListener {
        void onMangaBookClick(int position, Manga manga);
        void onMangaBookMenuClick(int position, Manga manga);
    }
}
