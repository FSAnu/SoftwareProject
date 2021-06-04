package com.example.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.zooapp.AnimalsDetails.AnimalsList;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class Page1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected DrawerLayout drawerLayout;
    private ImageView nav_menu;
    private BottomNavigationView navigationView;
    private NavigationView navigationView2;
    SliderLayout sliderLayout;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.navigationView2 = (NavigationView) findViewById(R.id.nav_view);
        this.nav_menu = (ImageView) findViewById(R.id.drawer_menu);
        navigationDrawer();
        this.sliderLayout = (SliderLayout) findViewById(R.id.imageSlider);
        imageSlider();
        this.navigationView = (BottomNavigationView) findViewById(R.id.botNav);
        navigation();
    }

    private void navigationDrawer() {
        this.navigationView2.bringToFront();
        this.navigationView2.setNavigationItemSelectedListener(this);
        this.navigationView2.setCheckedItem(R.id.drawer_home);
        this.nav_menu.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.Page1.AnonymousClass1 */

            public void onClick(View view) {
                if (Page1.this.drawerLayout.isDrawerVisible(GravityCompat.START)) {
                    Page1.this.drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    Page1.this.drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (this.drawerLayout.isDrawerVisible(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void navigation() {
        this.navigationView.setSelectedItemId(R.id.mainHome);
        this.navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            /* class com.example.zooapp.Page1.AnonymousClass2 */

            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.mainLoc) {
                    Page1.this.startActivity(new Intent(Page1.this, ZooMap.class));
                    return true;
                } else if (item.getItemId() == R.id.Animals) {
                    Page1.this.startActivity(new Intent(Page1.this, AnimalsList.class));
                    return true;
                } else if (item.getItemId() != R.id.calculation) {
                    return false;
                } else {
                    Page1.this.startActivity(new Intent(Page1.this, Calculations.class));
                    return true;
                }
            }
        });
    }

    private void imageSlider() {
        this.sliderLayout.setIndicatorAnimation(IndicatorAnimations.THIN_WORM);
        this.sliderLayout.setAutoScrolling(true);
        this.sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        this.sliderLayout.setScrollTimeInSec(2);
        for (int i = 0; i <= 5; i++) {
            DefaultSliderView sliderView = new DefaultSliderView(this);
            if (i == 0) {
                sliderView.setImageDrawable(R.drawable.lion1);
            } else if (i == 1) {
                sliderView.setImageDrawable(R.drawable.bear1);
            } else if (i == 2) {
                sliderView.setImageDrawable(R.drawable.giraffe1);
            } else if (i == 3) {
                sliderView.setImageDrawable(R.drawable.zebra1);
            } else if (i == 4) {
                sliderView.setImageDrawable(R.drawable.tiger1);
            } else if (i == 5) {
                sliderView.setImageDrawable(R.drawable.snake1);
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);
            this.sliderLayout.addSliderView(sliderView);
        }
    }

    @Override // com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.drawer_logout) {
            FirebaseAuth.getInstance().signOut();
            finish();
            startActivity(new Intent(this, LoginP.class));
            return true;
        } else if (id != R.id.drawer_profile) {
            return true;
        } else {
            startActivity(new Intent(this, UserProfile.class));
            return true;
        }
    }
}
