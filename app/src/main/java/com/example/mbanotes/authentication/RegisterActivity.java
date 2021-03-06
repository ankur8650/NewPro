package com.example.mbanotes.authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.mbanotes.MainActivity;
import com.example.mbanotes.R;
import com.example.mbanotes.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    FirebaseAuth auth;
    String myEmaill ;
    String myPasswordd;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        GOTOLOGIN();
        SET_EMAIL_WITH_INTENT();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("wait few seconds");
        progressDialog.setMessage("Register Account");
        progressDialog.setCancelable(false);

        auth = FirebaseAuth.getInstance();

        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.registerEmail.getText().toString();
                String password = binding.registerPassword.getText().toString();
                if (TextUtils.isEmpty(email) || !email.contains("@gmail.com")) {
                    Toast.makeText(RegisterActivity.this, "Please enter right email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                } else if ((password.length() <= 6)) {
                    Toast.makeText(RegisterActivity.this, "Password more than 6 character", Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.show();
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                                progressDialog.dismiss();
                            } else {
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                intent.putExtra("email", email);
                                intent.putExtra("password", password);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                progressDialog.dismiss();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(RegisterActivity.this, "Error is " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }



    private void GOTOLOGIN() {
        binding.loginAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
    }
    private void SET_EMAIL_WITH_INTENT() {
        myEmaill = getIntent().getStringExtra("emaill");
        myPasswordd = getIntent().getStringExtra("passwordd");
        binding.registerEmail.setText(myEmaill);
        binding.registerPassword.setText(myPasswordd);
    }
}