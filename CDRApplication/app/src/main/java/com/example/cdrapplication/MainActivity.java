package com.example.cdrapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cdrapplication.Fragments.CallsCountsFragments;
import com.example.cdrapplication.Fragments.HomeFragment;
import com.example.cdrapplication.Fragments.LocationsFragment;
import com.example.cdrapplication.Fragments.ProminentContactsFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle drawerToggle;
    DrawerLayout mainDrawer;
    NavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpDrawerLayout();  // Handling Drawer
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainActivityFragments,new HomeFragment());
        fragmentTransaction.commit();
    }

    // Setup Drawer on left side
    public void setUpDrawerLayout() {
        setSupportActionBar(findViewById(R.id.AppBar));
        navigation = findViewById(R.id.NavView);
        mainDrawer = findViewById(R.id.MainDrawer);


        drawerToggle = new ActionBarDrawerToggle(this, findViewById(R.id.MainDrawer), R.string.app_name, R.string.app_name);
        drawerToggle.syncState();

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                int Id = item.getItemId();
                Fragment temp=null;
                switch (Id){
                    case R.id.homeScreen : temp = new HomeFragment();
                        break;
                    case R.id.callsCounts : temp=new CallsCountsFragments();
                        break;
                    case R.id.locationsCalls : temp=new LocationsFragment();
                        break;
                    case R.id.prominantContacts: temp=new ProminentContactsFragment();
                    break;

                }
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.mainActivityFragments,temp);
                fragmentTransaction.commit();
                mainDrawer.closeDrawers();
                return true;
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}