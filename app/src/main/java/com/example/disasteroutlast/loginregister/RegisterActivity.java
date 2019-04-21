package com.example.disasteroutlast.loginregister;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.disasteroutlast.MainActivity;
import com.example.disasteroutlast.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {


    private EditText username,password,email,city;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;
    private Button register;
    private String userID;


    private void registerUser(final String name , String pass ,final String email_,final String city_)
    {

        if (name.isEmpty())
        {
            username.setError("name required");
            username.requestFocus();
            return ;
        }
        if (email_.isEmpty())
        {
            email.setError("email required");
            email.requestFocus();
            return ;
        }
        if(city_.isEmpty())
        {
            city.setError("City required");
            city.requestFocus();
            return;
        }
        if (pass.isEmpty())
        {
            password.setError("password required");
            password.requestFocus();
            return ;
        }

        firebaseAuth.createUserWithEmailAndPassword(email_,pass ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful())
                {
                    final User newuser = new User(
                            name , email_,city_
                    );
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    mDatabase.child("Users").child(user.getUid()).setValue(newuser).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful() )
                            {
                                Toast.makeText(RegisterActivity.this,"Registration successful",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }
                        }
                    });


                }else {
                    Toast.makeText(RegisterActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        city=findViewById(R.id.city);
        register=findViewById(R.id.register);

        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase=FirebaseDatabase.getInstance().getReference();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register.setEnabled(false);

                final String user=username.getText().toString().trim();
                final String pass=password.getText().toString().trim();
                final String emai=email.getText().toString().trim();
                final String city_=city.getText().toString().trim();

                registerUser(user , pass ,emai ,city_);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        register.setEnabled(true);
    }
}
