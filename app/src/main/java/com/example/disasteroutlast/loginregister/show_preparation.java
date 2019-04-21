package com.example.disasteroutlast.loginregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.disasteroutlast.R;

public class show_preparation extends AppCompatActivity {

    private Button pre,during,after;
    private TextView info,headline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_preparation);

        final  String disaster = getIntent().getStringExtra("message");
        //Toast.makeText(getApplicationContext(),table,Toast.LENGTH_LONG).show();


        headline=(TextView)findViewById(R.id.headline);
        info=(TextView)findViewById(R.id.info);
        pre=(Button)findViewById(R.id.pre);
        during=(Button)findViewById(R.id.during);
        after=(Button)findViewById(R.id.after);

        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String name=databaseAccess.getinfo(disaster,"pre");
                info.setText(name);
                headline.setText("দুর্যোগ পূর্ববর্তী প্রস্তুতি সমুহ --");
                databaseAccess.close();
            }
        });

        during.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String name=databaseAccess.getinfo(disaster,"during");
                info.setText(name);
                headline.setText("দুর্যোগ কালীন করণীয় সমুহ --");
                databaseAccess.close();
            }
        });
        after.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseAccess databaseAccess=DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String name=databaseAccess.getinfo(disaster,"after");
                info.setText(name);
                headline.setText("দুর্যোগ পরবর্তী করণীয় সমুহ --");
                databaseAccess.close();
            }
        });


    }
}