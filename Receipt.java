package com.example.zooapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Receipt extends AppCompatActivity {
    private static final String Shared_Animal = "AnimalPref";
    private static final String Shared_Food = "FoodPref";
    private static final String Shared_Total = "totalCOunt";
    private static final String Shared_Total_Meat = "totalMeatCOunt";
    private static final String Shared_Total_Veg = "totalVegCOunt";
    Button receiptfinal;
    private SharedPreferences sharedPreferences1;
    private SharedPreferences sharedPreferences2;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        getSupportActionBar().setTitle("Receipt");
        this.t1 = (TextView) findViewById(R.id.anitotal);
        this.t2 = (TextView) findViewById(R.id.vegtotal);
        this.t3 = (TextView) findViewById(R.id.meattotal);
        this.t4 = (TextView) findViewById(R.id.pricetotal);
        this.receiptfinal = (Button) findViewById(R.id.receiptfinal);
        this.sharedPreferences1 = getSharedPreferences(Shared_Animal, 0);
        this.sharedPreferences2 = getSharedPreferences(Shared_Food, 0);
        this.receiptfinal.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.Receipt.AnonymousClass1 */

            public void onClick(View view) {
                try {
                    String anitotal = Receipt.this.sharedPreferences1.getString(Receipt.Shared_Total, null);
                    if (anitotal != null) {
                        Receipt.this.t1.setText(anitotal);
                    }
                    String vegtotal = Receipt.this.sharedPreferences2.getString(Receipt.Shared_Total_Veg, null);
                    String meattotal = Receipt.this.sharedPreferences2.getString(Receipt.Shared_Total_Meat, null);
                    if (!(vegtotal == null && meattotal == null)) {
                        Receipt.this.t2.setText(vegtotal);
                        Receipt.this.t3.setText(meattotal);
                    }
                    Receipt.this.t4.setText(String.format("%.2f", Double.valueOf(Double.parseDouble(vegtotal) + Double.parseDouble(meattotal))));
                } catch (Exception e) {
                    Toast.makeText(Receipt.this, "Calculations Required", 0).show();
                }
            }
        });
    }
}
