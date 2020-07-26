package com.example.what2watchmangareader;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import Classes.Manga;

public class MangaBookFragment extends Fragment {


    private Manga manga;
    private ImageView mangaBookPosterCover;
    private TextView tvMangaBookTitleText;
    private TextView tvMangaBookAuthorText;
    private TextView tvMangaBookArtistsText;
    private TextView tvMangaBookDescriptionText;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        tvMangaBookTitleText = view.findViewById(R.id.tv_manga_book_title_text);
        tvMangaBookAuthorText = view.findViewById(R.id.tv_manga_book_author_text);
        tvMangaBookArtistsText = view.findViewById(R.id.tv_manga_book_artists_text);
        tvMangaBookDescriptionText = view.findViewById(R.id.tv_manga_book_description_text);
        mangaBookPosterCover = view.findViewById(R.id.iv_manga_book_manga_cover);


        //    manga = savedInstanceState.getParcelable("MangaBook");


//          mangaBookPosterCover.setImageResource(R.drawable.ic_launcher_background);//TODO

//        //get the information from fragmentMangaSearch here!
//        Bundle  results;
//
//        MainActivity activity = (MainActivity)getActivity();
//        int position = activity.getBundleMangaBook(0).getInt("position");
//        manga = activity.getBundleMangaBook(position).getParcelable("MangaBook");//get the position somehow?


        Picasso.get().load(manga.getPosterPicture()).into(mangaBookPosterCover);


        tvMangaBookTitleText.setText(manga.getTitle());

        String authors = "";
        if (manga.getAuthors() != null && manga.getAuthors().size() > 1) {
            for (int i = 0; i < manga.getAuthors().size(); i++) {
                if (i != 0 && manga.getAuthors().size() != 1) {
                    authors = authors + "," + manga.getAuthors().get(i) + " pos:" + i;
                } else {
                    authors = authors + manga.getAuthors().get(i) + " pos:" + i;
                }
                if (manga.getAuthors().size() == 1) {
                    tvMangaBookAuthorText.setText(manga.getAuthors().get(0)); ///change into a loop to get all the author's TODO
                }
                tvMangaBookAuthorText.setText(authors);
            }
        }

        String artists = "";
        if (manga.getArtists() != null && manga.getArtists().size() > 1) {
            for (int i = 0; i < manga.getArtists().size(); i++) {
                if (i != 0 && manga.getArtists().size() != 1) {
                    artists = artists + "," + manga.getArtists().get(i) + " pos:" + i;
                } else {
                    artists = artists + manga.getArtists().get(i) + " pos:" + i;
                }
                if (manga.getArtists().size() == 1) {
                    tvMangaBookArtistsText.setText(manga.getArtists().get(0));///change into a loop to get all the author's TODO
                }
                tvMangaBookArtistsText.setText(artists);
            }
            ///change into a loop to get all the artists's TODO
        }

        tvMangaBookDescriptionText.setText(manga.getDescriptionOfManga());


        return view;
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
//            @Override
//            public void onFragmentResult(@NonNull String key, @NonNull Bundle bundle) {
//                // We use a String here, but any type that can be put in a Bundle is supported
//                String result = bundle.getString("bundleKey");
//                // Do something with the result...
//            }
//        });
//
//
//
//
//    }


}

