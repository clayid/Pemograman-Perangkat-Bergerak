package com.example.mybiodataapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.buttonTelp);
        Button btn2 = (Button) findViewById(R.id.buttonAlamat);
        Button btn3 = (Button) findViewById(R.id.buttonEmail);
        Intent intent = getIntent();

        // fungsi telpon
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:085879442010"));
                startActivity(intent);
            }
        });

        // fungsi alamat
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent,chooser;
                intent  = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://maps.app.goo.gl/JqXDStj9ePRHMQEE9"));
                chooser = Intent.createChooser(intent,"Lauch Map");
                startActivity(chooser);
            }
        });

        // fungsi email
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("message/kalimat");
                String[] to ={"111201911859@mhs.dinus.ac.id"};
                email.putExtra(Intent.EXTRA_EMAIL,to);
                startActivity(email);
            }
        });
    }
}