package com.example.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.zooapp.AnimalsDetails.AnimalsList;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Calculations extends AppCompatActivity {
    private LinearLayout l1;
    private LinearLayout l2;
    private LinearLayout l3;
    private LinearLayout l4;
    private BottomNavigationView navigationView;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculations);
        this.l1 = (LinearLayout) findViewById(R.id.totalAnimals);
        this.l2 = (LinearLayout) findViewById(R.id.foodrecords);
        this.l3 = (LinearLayout) findViewById(R.id.receipt);
        this.l4 = (LinearLayout) findViewById(R.id.econtacts);
        layoutCards();
        this.navigationView = (BottomNavigationView) findViewById(R.id.botNav);
        navigation();
    }

    private void layoutCards() {
        this.l1.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.Calculations.AnonymousClass1 */

            public void onClick(View view) {
                Calculations.this.startActivity(new Intent(Calculations.this, TotalAnimals.class));
            }
        });
        this.l2.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.Calculations.AnonymousClass2 */

            public void onClick(View view) {
                Calculations.this.startActivity(new Intent(Calculations.this, FoodRecord.class));
            }
        });
        this.l3.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.Calculations.AnonymousClass3 */

            public void onClick(View view) {
                Calculations.this.startActivity(new Intent(Calculations.this, Receipt.class));
            }
        });
    }

    private void navigation() {
        this.navigationView.setSelectedItemId(R.id.calculation);
        this.navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            /* class com.example.zooapp.Calculations.AnonymousClass4 */

            @Override // com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.mainLoc) {
                    Calculations.this.startActivity(new Intent(Calculations.this, ZooMap.class));
                    return true;
                } else if (item.getItemId() == R.id.Animals) {
                    Calculations.this.startActivity(new Intent(Calculations.this, AnimalsList.class));
                    return true;
                } else if (item.getItemId() != R.id.mainHome) {
                    return false;
                } else {
                    Calculations.this.startActivity(new Intent(Calculations.this, Page1.class));
                    return true;
                }
            }
        });
    }
}
