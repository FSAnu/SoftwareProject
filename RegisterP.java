package com.example.zooapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.mikhaellopez.circularimageview.CircularImageView;
import java.io.IOException;
import java.util.HashMap;

public class RegisterP extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;
    EditText Rmail;
    EditText Rpass;
    private FirebaseAuth fireAuth;
    TextView login;
    private CircularImageView pickImg;
    ProgressDialog prog;
    Uri resultImg;
    Button signup;
    EditText username;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerp);
        getSupportActionBar().setTitle("Create Account");
        CircularImageView circularImageView = (CircularImageView) findViewById(R.id.pickImage);
        this.pickImg = circularImageView;
        circularImageView.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.RegisterP.AnonymousClass1 */

            public void onClick(View view) {
                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction("android.intent.action.GET_CONTENT");
                RegisterP.this.startActivityForResult(Intent.createChooser(gallery, "Select Picture"), 1);
            }
        });
        this.fireAuth = FirebaseAuth.getInstance();
        this.Rmail = (EditText) findViewById(R.id.Rmail);
        this.Rpass = (EditText) findViewById(R.id.Rpass);
        this.signup = (Button) findViewById(R.id.signup);
        this.username = (EditText) findViewById(R.id.name);
        this.login = (TextView) findViewById(R.id.loginpage);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.prog = progressDialog;
        progressDialog.setMessage("Registering User...");
        this.signup.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.RegisterP.AnonymousClass2 */

            public void onClick(View view) {
                String mail = RegisterP.this.Rmail.getText().toString();
                String pass = RegisterP.this.Rpass.getText().toString();
                if (RegisterP.this.username.getText().toString().isEmpty()) {
                    RegisterP.this.username.setError("Enter your name");
                    RegisterP.this.username.setFocusable(true);
                } else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                    RegisterP.this.Rmail.setError("Invalid e-mail");
                    RegisterP.this.Rmail.setFocusable(true);
                } else if (pass.length() < 6) {
                    RegisterP.this.Rpass.setError("Password length must contain 6 characters");
                    RegisterP.this.Rpass.setFocusable(true);
                } else {
                    RegisterP.this.registerUser(mail, pass);
                }
            }
        });
        this.login.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.RegisterP.AnonymousClass3 */

            public void onClick(View view) {
                RegisterP.this.startActivity(new Intent(RegisterP.this, LoginP.class));
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void registerUser(String mail, String pass) {
        this.prog.show();
        this.fireAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            /* class com.example.zooapp.RegisterP.AnonymousClass5 */

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    RegisterP.this.prog.dismiss();
                    FirebaseUser user = RegisterP.this.fireAuth.getCurrentUser();
                    String usermail = user.getEmail();
                    String uid = user.getUid();
                    HashMap<Object, String> hash = new HashMap<>();
                    hash.put("email", usermail);
                    hash.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "");
                    hash.put("pro-pic", "");
                    hash.put("uid", uid);
                    FirebaseDatabase.getInstance().getReference("Users").child(uid).setValue(hash);
                    RegisterP registerP = RegisterP.this;
                    Toast.makeText(registerP, "Registered...\n" + user.getEmail(), 0).show();
                    RegisterP.this.startActivity(new Intent(RegisterP.this, LoginP.class));
                    RegisterP.this.finish();
                    return;
                }
                RegisterP.this.prog.dismiss();
                Toast.makeText(RegisterP.this, "Authentication Failed", 0).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            /* class com.example.zooapp.RegisterP.AnonymousClass4 */

            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception e) {
                RegisterP.this.prog.dismiss();
                RegisterP registerP = RegisterP.this;
                Toast.makeText(registerP, "" + e.getMessage(), 0).show();
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == -1 && data != null) {
            this.resultImg = data.getData();
            try {
                this.pickImg.setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), this.resultImg));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        System.exit(0);
        super.onBackPressed();
    }
}
