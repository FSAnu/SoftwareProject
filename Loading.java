package com.example.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class Loading extends AppCompatActivity {
    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        getWindow().setFlags(1024, 1024);
        new Handler().postDelayed(new Runnable() {
            /* class com.example.zooapp.Loading.AnonymousClass1 */

            public void run() {
                Loading.this.startActivity(new Intent(Loading.this, RegisterP.class));
            }
        }, 3000);
    }
}
