package com.example.healthandhygene;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    public void open(View view){
        Intent i = new Intent(this,MainActivity2.class);
        Toast.makeText(this, "Taking to next page...", Toast.LENGTH_SHORT).show();
        startActivity(i);
    }
    public void open1(View view){
        Intent i = new Intent(this,MainActivity3.class);
        startActivity(i);
    }
    public void open4(View view){
        Intent i = new Intent(this,MainActivity4.class);
        startActivity(i);
    }
}