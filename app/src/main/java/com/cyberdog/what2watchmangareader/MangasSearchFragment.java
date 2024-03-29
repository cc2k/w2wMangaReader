package com.cyberdog.what2watchmangareader;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Classes.JsonHandling;
import Classes.Manga;

public class MangasSearchFragment extends Fragment implements MyAdapterRecyclerView.OnMangaBookClickListener {
    //This activity shows manga from a source, or sources where the reader can select them, check their info and maybe add or not to the collection of the reader.
    //


// first implementation
//    mangas
//
//    1   2   3   4
//
//    5   6   7   8
//
//
// later added as a choise
//    mangasource1
//    1   2   3   more
//
//    mangasource 2
//    4   5   6   more

// reuse a view for showing the manga's
    //using recyclerview for this


    private RecyclerView recyclerView;
    private MyAdapterRecyclerView mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Bundle results;
    private ArrayList<Manga> mangaTempList;
    private int containerId;
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mangas_to_search, container, false);
        Context context = getActivity();
        recyclerView = view.findViewById(R.id.rv_manga_book);
        mangaTempList = new JsonHandling(context).getMangaBookJson();
        containerId = container.getId();
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));

        // specify an adapter (see also next example)
        mAdapter = new MyAdapterRecyclerView(mangaTempList, this.getActivity(), this, containerId);


        recyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onMangaBookClick(int position, Manga manga) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("MangaBook", mangaTempList.get(position));
        MangaBookFragment fragmentB = new MangaBookFragment();
        fragmentB.setArguments(bundle);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.main_content, fragmentB, "MangaBookFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onMangaBookMenuClick(final int position, Manga manga) {
        final PopupMenu popMenu = new PopupMenu(getContext(), view.findViewById(R.id.iv_book_cover_menu));
        popMenu.getMenuInflater().inflate(R.menu.menu_mangas_search_book_option, popMenu.getMenu());


        popMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                //return onMenuItemClick(menuItem);

                Toast.makeText(getContext(), "Selected Item: " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                switch (menuItem.getItemId()) {
                    case R.id.menus_search_book_details_manga_book:

                        Bundle bundle = new Bundle();
                        bundle.putParcelable("MangaBook", mangaTempList.get(position));
                        MangaBookFragment fragmentB = new MangaBookFragment();
                        fragmentB.setArguments(bundle);
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.main_content, fragmentB, "MangaBookFragment")
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


    }
}

