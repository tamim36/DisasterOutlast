package com.example.disasteroutlast.loginregister;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.disasteroutlast.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PasswordActivity extends AppCompatActivity {

    private EditText passwordemail;
    private Button resetpassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        firebaseAuth=FirebaseAuth.getInstance();

        passwordemail=(EditText) findViewById(R.id.passwordemail);
        resetpassword=(Button) findViewById(R.id.resetpassword);

        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail = passwordemail.getText().toString().trim();

                if (useremail.isEmpty())
                {
                    passwordemail.setError("name required");
                    passwordemail.requestFocus();
                    return ;
                }else{
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(PasswordActivity.this,"Password reset email sent! ",Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                            }else{
                                Toast.makeText(PasswordActivity.this,"Error in sending !",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }

            }
        });

    }
}
