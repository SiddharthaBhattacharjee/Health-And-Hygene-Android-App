package com.example.healthandhygene;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void open(View view){
        Intent i = new Intent(this,MainActivity2.class);
        Toast.makeText(this, "Taking to next page...", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }
}