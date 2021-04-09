package com.example.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.example.zooapp.AnimalsDetails.AnimalsList;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ZooMap extends AppCompatActivity {
    BottomNavigationView navigationView;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_map);
        this.navigationView = (BottomNavigationView) findViewById(R.id.botNav);
        navigation();
    }

    private void navigation() {
        this.navigationView.setSelectedItemId(R.id.mainLoc);
        this.navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            /* class com.example.zooapp.ZooMap.AnonymousClass1 */

            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.mainHome) {
                    ZooMap.this.startActivity(new Intent(ZooMap.this, Page1.class));
                    return true;
                } else if (item.getItemId() == R.id.Animals) {
                    ZooMap.this.startActivity(new Intent(ZooMap.this, AnimalsList.class));
                    return true;
                } else if (item.getItemId() != R.id.calculation) {
                    return false;
                } else {
                    ZooMap.this.startActivity(new Intent(ZooMap.this, Calculations.class));
                    return true;
                }
            }
        });
    }
}
