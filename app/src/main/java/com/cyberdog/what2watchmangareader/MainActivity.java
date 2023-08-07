package com.cyberdog.what2watchmangareader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

import Classes.LoggedInUser;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private AppBarConfiguration appBarConfig;

   // public static LoggedInUser loggedInUser;
  //  FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  loggedInUser = LoggedInUser.getInstance();
      //  fm = getSupportFragmentManager();

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        appBarConfig = new AppBarConfiguration.Builder(R.id.nav_graph_manga_book_details,
                R.id.nav_graph_mangas_search_souce, R.id.nav_graph_profile,
                R.id.nav_graph_settings).setDrawerLayout(drawer).build();

        NavController navController = Navigation.findNavController(this, R.id.main_content);

        NavigationView navigationView = findViewById(R.id.nav_view);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfig);

        DrawerLayout drawerL = findViewById(R.id.drawer_layout);

        NavigationUI.setupActionBarWithNavController(this, navController, drawerL);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
            NavController navController = Navigation.findNavController(this, R.id.main_content);
            return NavigationUI.navigateUp(navController, appBarConfig) || super.onSupportNavigateUp();

    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}

