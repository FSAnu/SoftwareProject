package com.example.zooapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class TotalAnimals extends AppCompatActivity {
    private static final String Shared_Animal = "AnimalPref";
    private static final String Shared_Total = "totalCOunt";
    private CheckBox c1;
    private CheckBox c10;
    private CheckBox c11;
    private CheckBox c12;
    private CheckBox c13;
    private CheckBox c2;
    private CheckBox c3;
    private CheckBox c4;
    private CheckBox c5;
    private CheckBox c6;
    private CheckBox c7;
    private CheckBox c8;
    private CheckBox c9;
    private Button clear;
    private EditText e1;
    private EditText e10;
    private EditText e11;
    private EditText e12;
    private EditText e13;
    private EditText e2;
    private EditText e3;
    private EditText e4;
    private EditText e5;
    private EditText e6;
    private EditText e7;
    private EditText e8;
    private EditText e9;
    private TextView result;
    private SharedPreferences sharedPreferences;
    private Button total;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_animals);
        getSupportActionBar().setTitle("Total Animals");
        this.c1 = (CheckBox) findViewById(R.id.c1);
        this.c2 = (CheckBox) findViewById(R.id.c2);
        this.c3 = (CheckBox) findViewById(R.id.c3);
        this.c4 = (CheckBox) findViewById(R.id.c4);
        this.c5 = (CheckBox) findViewById(R.id.c5);
        this.c6 = (CheckBox) findViewById(R.id.c6);
        this.c7 = (CheckBox) findViewById(R.id.c7);
        this.c8 = (CheckBox) findViewById(R.id.c8);
        this.c9 = (CheckBox) findViewById(R.id.c9);
        this.c10 = (CheckBox) findViewById(R.id.c10);
        this.c11 = (CheckBox) findViewById(R.id.c11);
        this.c12 = (CheckBox) findViewById(R.id.c12);
        this.c13 = (CheckBox) findViewById(R.id.c13);
        this.e1 = (EditText) findViewById(R.id.e1);
        this.e2 = (EditText) findViewById(R.id.e2);
        this.e3 = (EditText) findViewById(R.id.e3);
        this.e4 = (EditText) findViewById(R.id.e4);
        this.e5 = (EditText) findViewById(R.id.e5);
        this.e6 = (EditText) findViewById(R.id.e6);
        this.e7 = (EditText) findViewById(R.id.e7);
        this.e8 = (EditText) findViewById(R.id.e8);
        this.e9 = (EditText) findViewById(R.id.e9);
        this.e10 = (EditText) findViewById(R.id.e10);
        this.e11 = (EditText) findViewById(R.id.e11);
        this.e12 = (EditText) findViewById(R.id.e12);
        this.e13 = (EditText) findViewById(R.id.e13);
        this.total = (Button) findViewById(R.id.calT);
        this.clear = (Button) findViewById(R.id.clearField);
        this.result = (TextView) findViewById(R.id.resulT);
        this.clear.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.TotalAnimals.AnonymousClass1 */

            public void onClick(View view) {
                TotalAnimals.this.result.setText("00");
            }
        });
        this.sharedPreferences = getSharedPreferences(Shared_Animal, 0);
        this.total.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.TotalAnimals.AnonymousClass2 */

            public void onClick(View view) {
                int total = 0;
                ArrayList<Integer> animalsNum = new ArrayList<>();
                if (TotalAnimals.this.c1.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e1.getText().toString())));
                }
                if (TotalAnimals.this.c2.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e2.getText().toString())));
                }
                if (TotalAnimals.this.c3.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e3.getText().toString())));
                }
                if (TotalAnimals.this.c4.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e4.getText().toString())));
                }
                if (TotalAnimals.this.c5.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e5.getText().toString())));
                }
                if (TotalAnimals.this.c6.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e6.getText().toString())));
                }
                if (TotalAnimals.this.c7.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e7.getText().toString())));
                }
                if (TotalAnimals.this.c8.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e8.getText().toString())));
                }
                if (TotalAnimals.this.c9.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e9.getText().toString())));
                }
                if (TotalAnimals.this.c10.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e10.getText().toString())));
                }
                if (TotalAnimals.this.c11.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e11.getText().toString())));
                }
                if (TotalAnimals.this.c12.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e12.getText().toString())));
                }
                if (TotalAnimals.this.c13.isChecked()) {
                    animalsNum.add(Integer.valueOf(Integer.parseInt(TotalAnimals.this.e13.getText().toString())));
                }
                for (int i = 0; i < animalsNum.size(); i++) {
                    total += animalsNum.get(i).intValue();
                }
                TotalAnimals.this.result.setText(Integer.toString(total));
                SharedPreferences.Editor editor1 = TotalAnimals.this.sharedPreferences.edit();
                editor1.putString(TotalAnimals.Shared_Total, TotalAnimals.this.result.getText().toString());
                editor1.apply();
            }
        });
    }
}
