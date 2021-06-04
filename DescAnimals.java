package com.example.zooapp.AnimalsDetails;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.zooapp.R;

public class DescAnimals extends AppCompatActivity {
    Toolbar animalsBAR;
    TextView descA;
    ImageView imageA;
    TextView namesA;
    TextView spanA;
    TextView specA;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc_animals);
        Toolbar toolbar = (Toolbar) findViewById(R.id.animalsBAR);
        this.animalsBAR = toolbar;
        setSupportActionBar(toolbar);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setDisplayShowHomeEnabled(true);
        this.imageA = (ImageView) findViewById(R.id.imageA);
        this.namesA = (TextView) findViewById(R.id.namesA);
        this.specA = (TextView) findViewById(R.id.specA);
        this.spanA = (TextView) findViewById(R.id.spanA);
        this.descA = (TextView) findViewById(R.id.descA);
        Bundle b1 = getIntent().getExtras();
        if (b1 != null) {
            this.imageA.setImageResource(b1.getInt("imageA"));
            this.namesA.setText(b1.getString("namesA"));
            this.specA.setText(b1.getString("specA"));
            this.spanA.setText(b1.getString("spanA"));
            this.descA.setText(b1.getString("descA"));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}
