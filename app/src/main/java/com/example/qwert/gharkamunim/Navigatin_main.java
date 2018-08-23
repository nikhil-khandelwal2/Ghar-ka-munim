package com.example.qwert.gharkamunim;

import android.os.Bundle;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DividerItemDecoration;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Navigatin_main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigatin_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_navigation);
        setSupportActionBar(toolbar);


        getSupportActionBar().setTitle("Ghar Ka Munim");


        //to load fragment dashboard as soon as navigation drawer is opened
        Fragment fragment=null;
        final Navigation_fragment_dash navigation_fragment_dash_ =new Navigation_fragment_dash();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        ft.replace(R.id.navigation_fragment,navigation_fragment_dash_);
        ft.commit();





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //to separate items by a line
        NavigationMenuView navMenuView = (NavigationMenuView) navigationView.getChildAt(0);
        navMenuView.addItemDecoration(new DividerItemDecoration(Navigatin_main.this,DividerItemDecoration.VERTICAL));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigatin_main, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        Fragment fragment=null;



        if (id == R.id.navigation_dash) {

            fragment=new Navigation_fragment_dash();
            getSupportActionBar().setTitle("Dashboard");


        } else if (id == R.id.navigation_profile) {

            fragment=new Profile_fragment_navi();
            getSupportActionBar().setTitle("Profile");

        } else if (id == R.id.navigation_Expense_Category) {

        } else if (id == R.id.navigation_transaction_history) {

        } else if (id == R.id.navigation_import_export) {

        } else if (id == R.id.navigation_backup) {

        }
        else if (id == R.id.navigation_trash) {

        }
        else if (id == R.id.navigation_refer_earn) {

        }


        if (fragment!=null)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction ft=fragmentManager.beginTransaction();
            ft.replace(R.id.navigation_fragment,fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
