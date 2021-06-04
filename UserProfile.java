package com.example.zooapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {
    private static final String USER = "Users";
    private FirebaseDatabase database;
    protected DrawerLayout drawerLayout;
    TextView mailpro;
    private DatabaseReference userData;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        final String email = getIntent().getStringExtra("email");
        this.mailpro = (TextView) findViewById(R.id.mailpro);
        FirebaseDatabase instance = FirebaseDatabase.getInstance();
        this.database = instance;
        DatabaseReference reference = instance.getReference(USER);
        this.userData = reference;
        reference.addValueEventListener(new ValueEventListener() {
            /* class com.example.zooapp.UserProfile.AnonymousClass1 */

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    if (ds.child("email").getValue().equals(email)) {
                        UserProfile.this.mailpro.setText(email);
                    }
                }
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
            }
        });
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        finish();
        startActivity(new Intent(this, Page1.class));
        super.onBackPressed();
    }
}
