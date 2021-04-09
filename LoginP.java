package com.example.zooapp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginP extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener AuthState;
    EditText Lmail;
    EditText Lpass;
    Dialog dialog;
    TextView fPass;
    private FirebaseAuth fireAuth;
    ProgressDialog prog;
    TextView reg;
    Button signin;

    /* access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_p);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("User Log In");
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setDisplayShowHomeEnabled(true);
        this.reg = (TextView) findViewById(R.id.registerpage);
        this.Lmail = (EditText) findViewById(R.id.Lmail);
        this.Lpass = (EditText) findViewById(R.id.Lpass);
        this.signin = (Button) findViewById(R.id.login);
        this.fireAuth = FirebaseAuth.getInstance();
        this.AuthState = new FirebaseAuth.AuthStateListener() {
            /* class com.example.zooapp.LoginP.AnonymousClass1 */

            @Override // com.google.firebase.auth.FirebaseAuth.AuthStateListener
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                if (LoginP.this.fireAuth.getCurrentUser() != null) {
                    Toast.makeText(LoginP.this, "You are logged in", 0).show();
                    LoginP.this.startActivity(new Intent(LoginP.this, Page1.class));
                }
            }
        };
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.prog = progressDialog;
        progressDialog.setMessage("Loggin In...");
        this.signin.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.LoginP.AnonymousClass2 */

            public void onClick(View view) {
                String mail = LoginP.this.Lmail.getText().toString();
                String pass = LoginP.this.Lpass.getText().toString();
                if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                    LoginP.this.Lmail.setError("Invalid e-mail");
                    LoginP.this.Lmail.setFocusable(true);
                } else if (pass.isEmpty()) {
                    LoginP.this.Lpass.setError("Enter your password");
                    LoginP.this.Lpass.requestFocus();
                } else {
                    LoginP.this.loginUser(mail, pass);
                }
            }
        });
        this.reg.setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.LoginP.AnonymousClass3 */

            public void onClick(View view) {
                LoginP.this.startActivity(new Intent(LoginP.this, RegisterP.class));
            }
        });
        this.dialog = new Dialog(this);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void loginUser(String mail, String pass) {
        this.prog.show();
        this.fireAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            /* class com.example.zooapp.LoginP.AnonymousClass5 */

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    LoginP.this.prog.dismiss();
                    LoginP.this.fireAuth.getCurrentUser();
                    LoginP.this.startActivity(new Intent(LoginP.this, Page1.class));
                    LoginP.this.finish();
                    return;
                }
                LoginP.this.prog.dismiss();
                Toast.makeText(LoginP.this, "Authentication Failed", 0).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            /* class com.example.zooapp.LoginP.AnonymousClass4 */

            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception e) {
                LoginP.this.prog.dismiss();
                LoginP loginP = LoginP.this;
                Toast.makeText(loginP, "" + e.getMessage(), 0).show();
            }
        });
    }

    public void ShowpopUp(View v) {
        this.dialog.setContentView(R.layout.recoverpass);
        this.dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.dialog.setCancelable(false);
        this.dialog.show();
        final AwesomeValidation b = new AwesomeValidation(ValidationStyle.BASIC);
        final EditText recM = (EditText) this.dialog.findViewById(R.id.recM);
        ((TextView) this.dialog.findViewById(R.id.recoverB)).setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.LoginP.AnonymousClass6 */

            public void onClick(View view) {
                if (recM.getText().toString().isEmpty()) {
                    b.addValidation(LoginP.this, R.id.recM, Patterns.WEB_URL, R.string.validMail);
                    Toast.makeText(LoginP.this, "Please Enter Recovery Mail", 0).show();
                    return;
                }
                LoginP.this.beginRecovery(recM.getText().toString());
            }
        });
        ((TextView) this.dialog.findViewById(R.id.cancelB)).setOnClickListener(new View.OnClickListener() {
            /* class com.example.zooapp.LoginP.AnonymousClass7 */

            public void onClick(View view) {
                LoginP.this.dialog.cancel();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void beginRecovery(String mailrecover) {
        this.fireAuth.sendPasswordResetEmail(mailrecover).addOnCompleteListener(new OnCompleteListener<Void>() {
            /* class com.example.zooapp.LoginP.AnonymousClass8 */

            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginP.this, "E-mail Sent", 0).show();
                } else {
                    Toast.makeText(LoginP.this, "Incorrect E-mail, try again", 0).show();
                }
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        startActivity(new Intent(this, RegisterP.class));
        return super.onSupportNavigateUp();
    }

    /* access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        this.fireAuth.addAuthStateListener(this.AuthState);
    }
}
