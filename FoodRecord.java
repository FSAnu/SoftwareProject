package com.example.zooapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class FoodRecord extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String Shared_Food = "FoodPref";
    private static final String Shared_Total_Meat = "totalMeatCOunt";
    private static final String Shared_Total_Veg = "totalVegCOunt";
    double BabyCorn = 17.8d;
    double Banana = 17.8d;
    double Beef = 102.7d;
    double Cabbage = 11.3d;
    double Chicken = 75.6d;
    double Fish = 59.3d;
    double Grass = 9.7d;
    double Mutton = 110.4d;
    double Peas = 12.4d;
    Button complete;
    Button complete2;
    private TextView.OnEditorActionListener editorActionListener1 = new TextView.OnEditorActionListener() {
        /* class com.example.zooapp.FoodRecord.AnonymousClass3 */

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            Double x1 = Double.valueOf(Double.parseDouble(FoodRecord.this.fixed.getText().toString()));
            Double x2 = Double.valueOf(Double.parseDouble(FoodRecord.this.vegAV.getText().toString()));
            if (i == 6) {
                FoodRecord.this.need.setText(String.format("%.2f", Double.valueOf(x1.doubleValue() - x2.doubleValue())));
            }
            return false;
        }
    };
    private TextView.OnEditorActionListener editorActionListener2 = new TextView.OnEditorActionListener() {
        /* class com.example.zooapp.FoodRecord.AnonymousClass4 */

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            Double a1 = Double.valueOf(Double.parseDouble(FoodRecord.this.fixed2.getText().toString()));
            Double a2 = Double.valueOf(Double.parseDouble(FoodRecord.this.meatAV.getText().toString()));
            if (i == 6) {
                FoodRecord.this.need2.setText(String.format("%.2f", Double.valueOf(a1.doubleValue() - a2.doubleValue())));
            }
            return false;
        }
    };
    TextView fixed;
    TextView fixed2;
    EditText meatAV;
    double meatprice = 0.0d;
    TextView need;
    TextView need2;
    EditText price;
    EditText price2;
    Spinner s1;
    Spinner s2;
    private SharedPreferences sharedPreferences;
    TextView totalVeg;
    TextView totalmeat;
    EditText vegAV;
    double vegprice = 0.0d;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_record);
        getSupportActionBar().setTitle("Food Record");
        this.fixed = (TextView) findViewById(R.id.fixed);
        this.fixed2 = (TextView) findViewById(R.id.fixed2);
        this.vegAV = (EditText) findViewById(R.id.vegAV);
        this.meatAV = (EditText) findViewById(R.id.meatAV);
        this.price = (EditText) findViewById(R.id.price);
        this.price2 = (EditText) findViewById(R.id.price2);
        this.complete = (Button) findViewById(R.id.complete);
        this.complete2 = (Button) findViewById(R.id.complete2);
        this.totalVeg = (TextView) findViewById(R.id.totalVeg);
        this.totalmeat = (TextView) findViewById(R.id.totalmeat);
        this.need = (TextView) findViewById(R.id.need);
        this.need2 = (TextView) findViewById(R.id.need2);
        this.s1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.vegies, 17367048);
        adapter1.setDropDownViewResource(17367049);
        this.s1.setAdapter((SpinnerAdapter) adapter1);
        this.s1.setOnItemSelectedListener(this);
        this.s2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.meat, 17367048);
        adapter2.setDropDownViewResource(17367049);
        this.s2.setAdapter((SpinnerAdapter) adapter2);
        this.s2.setOnItemSelectedListener(this);
        this.sharedPreferences = getSharedPreferences(Shared_Food, 0);
        this.vegAV.setOnEditorActionListener(this.editorActionListener1);
        this.meatAV.setOnEditorActionListener(this.editorActionListener2);
        this.complete.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.FoodRecord.AnonymousClass1 */

            public void onClick(View view) {
                try {
                    if (FoodRecord.this.need.getText().toString().isEmpty()) {
                        Toast.makeText(FoodRecord.this, "Need Required", 0).show();
                        return;
                    }
                    double x3 = Double.parseDouble(FoodRecord.this.need.getText().toString());
                    double x4 = Double.parseDouble(FoodRecord.this.price.getText().toString());
                    FoodRecord.this.totalVeg.setText(String.format("%.2f", Double.valueOf(x3 * x4)));
                    FoodRecord.this.vegprice += x3 * x4;
                    SharedPreferences.Editor editor1 = FoodRecord.this.sharedPreferences.edit();
                    editor1.putString(FoodRecord.Shared_Total_Veg, String.valueOf(FoodRecord.this.vegprice));
                    editor1.apply();
                } catch (Exception e) {
                    Toast.makeText(FoodRecord.this, "Enter Amount", 0).show();
                }
            }
        });
        this.complete2.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.FoodRecord.AnonymousClass2 */

            public void onClick(View view) {
                try {
                    if (FoodRecord.this.need2.getText().toString().isEmpty()) {
                        Toast.makeText(FoodRecord.this, "Need Required", 0).show();
                        return;
                    }
                    double a3 = Double.parseDouble(FoodRecord.this.need2.getText().toString());
                    double a4 = Double.parseDouble(FoodRecord.this.price2.getText().toString());
                    FoodRecord.this.totalmeat.setText(String.format("%.2f", Double.valueOf(a3 * a4)));
                    FoodRecord.this.meatprice += a3 * a4;
                    SharedPreferences.Editor editor2 = FoodRecord.this.sharedPreferences.edit();
                    editor2.putString(FoodRecord.Shared_Total_Meat, String.valueOf(FoodRecord.this.meatprice));
                    editor2.apply();
                } catch (Exception e) {
                    Toast.makeText(FoodRecord.this, "Enter Amount", 0).show();
                }
            }
        });
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00bf, code lost:
        if (r4.equals("Select...") != false) goto L_0x00eb;
     */
    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        boolean z;
        String text1 = adapterView.getItemAtPosition(i).toString();
        boolean z2 = false;
        switch (text1.hashCode()) {
            case -2125581890:
                if (text1.equals("BabyCorn")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -2091214079:
                if (text1.equals("Cabbage")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 2483463:
                if (text1.equals("Peas")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 69063062:
                if (text1.equals("Grass")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 287943634:
                if (text1.equals("Select...")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1982479237:
                if (text1.equals("Banana")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z) {
            this.fixed.setText("");
        } else if (z) {
            this.fixed.setText(Double.toString(this.Peas));
        } else if (z) {
            this.fixed.setText(Double.toString(this.BabyCorn));
        } else if (z) {
            this.fixed.setText(Double.toString(this.Grass));
        } else if (z) {
            this.fixed.setText(Double.toString(this.Cabbage));
        } else if (z) {
            this.fixed.setText(Double.toString(this.Banana));
        }
        String text2 = adapterView.getItemAtPosition(i).toString();
        switch (text2.hashCode()) {
            case -1978899929:
                if (text2.equals("Mutton")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case -1884306027:
                if (text2.equals("Chicken")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 2066500:
                if (text2.equals("Beef")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 2189944:
                if (text2.equals("Fish")) {
                    z2 = true;
                    break;
                }
                z2 = true;
                break;
            case 287943634:
                break;
            default:
                z2 = true;
                break;
        }
        if (!z2) {
            this.fixed2.setText("");
        } else if (z2) {
            this.fixed2.setText(Double.toString(this.Beef));
        } else if (z2) {
            this.fixed2.setText(Double.toString(this.Chicken));
        } else if (z2) {
            this.fixed2.setText(Double.toString(this.Mutton));
        } else if (z2) {
            this.fixed2.setText(Double.toString(this.Fish));
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
