package com.example.healthandhygene;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.menu_contact){
            Toast.makeText(this, "Opening Contact Us.", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,MainActivity6.class);
            startActivity(i);
        }
        if(id==R.id.menu_about){
            Toast.makeText(this, "Opening About Us.", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,MainActivity8.class);
            startActivity(i);
        }
        if(id==R.id.menu_home){
            recreate();
        }
        if(id==R.id.menu_share){
            /*Create an ACTION_SEND Intent*/
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            /*This will be the actual content you wish you share.*/
            String shareBody = "Want to Stay Healthy but can't stay motivated to go to the gym?, Download Care For Me app today, and get progressive improvement and a healthy body.\n get app here : https://drive.google.com/drive/folders/1YhD42wdNopbNxjRTPS7UHSlM1nLZuJRW?usp=sharing ";
            /*The type of the content is text, obviously.*/
            intent.setType("text/plain");
            /*Applying information Subject and Body.*/
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Share app link...");
            intent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            /*Fire!*/
            startActivity(Intent.createChooser(intent, "Share using"));
        }
        return super.onOptionsItemSelected(item);

    }

    public void open(View view){
        Intent i = new Intent(this,MainActivity2.class);
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
    public void open2(View view){
        Intent i = new Intent(this,MainActivity7.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
    public void open8(View view){
        Intent i = new Intent(this,MainActivity10.class);
        startActivity(i);
    }
    public void open3(View view){
        Intent i = new Intent(this,MainActivity11.class);
        startActivity(i);
    }
    public void open5(View view){
        Intent i = new Intent(this,MainActivity12.class);
        startActivity(i);
    }
    public void open7(View view){
        Intent i = new Intent(this,MainActivity13.class);
        startActivity(i);
    }

}