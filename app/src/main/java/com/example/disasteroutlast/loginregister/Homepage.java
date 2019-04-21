package com.example.disasteroutlast.loginregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.disasteroutlast.R;
import com.example.disasteroutlast.loginregister.mapshelter.LocationUpdateActivity;
import com.google.firebase.auth.FirebaseAuth;
public class Homepage extends AppCompatActivity {

    private Button flood,cyclone,rivererosion,drought,logout,locationupdate;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        locationupdate=(Button)findViewById(R.id.locationupdate);
        flood=(Button)findViewById(R.id.flood);
        cyclone=(Button)findViewById(R.id.cyclone);
        rivererosion=(Button)findViewById(R.id.rivererosion);
        drought=(Button)findViewById(R.id.drought);
        logout=(Button) findViewById(R.id.logout);
        logout.setVisibility(View.GONE);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth=FirebaseAuth.getInstance();
                firebaseAuth.signOut();
                Intent intent = new Intent(Homepage.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        locationupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LocationUpdateActivity.class));
            }
        });
        flood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,show_preparation.class).putExtra("message","Flood");
                startActivity(intent);

            }
        });
        cyclone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,show_preparation.class).putExtra("message","Cyclone");
                startActivity(intent);

            }
        });
        rivererosion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,show_preparation.class).putExtra("message","RiverErosion");
                startActivity(intent);

            }
        });
        drought.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this,show_preparation.class).putExtra("message","Drought");
                startActivity(intent);

            }
        });
    }


}