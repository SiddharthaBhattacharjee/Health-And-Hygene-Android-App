package com.example.healthandhygene;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
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
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

    //call part
    public void Dialnum(String num){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",num, null));
        startActivity(intent);
    }
    public void call1(View view){
        String num = "+919370553235";
        Dialnum(num);
    }
    public void call2(View view){
        String num = "+917002744892";
        Dialnum(num);
    }
    public void call3(View view){
        String num = "+919337527307";
        Dialnum(num);
    }
    public void call4(View view){
        String num = "+917358408137";
        Dialnum(num);
    }

    //Email Part
    public void sendEmail(String email){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
        startActivity(i);
    }
    public void email1(View view){
        String em = "harshit.shukla1503@gmail.com";
        sendEmail(em);
    }
    public void email2(View view){
        String em = "harshit.shukla1503@gmail.com";
        sendEmail(em);
    }
    public void email3(View view){
        String em = "harshit.shukla1503@gmail.com";
        sendEmail(em);
    }
    public void email4(View view){
        String em = "harshit.shukla1503@gmail.com";
        sendEmail(em);
    }

    //web related part
    public void webopen(String link){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(link));
        startActivity(i);
    }
    //insta
    public void insta1(View view){
        String il = "https://www.instagram.com/harshitshukla123/";
        webopen(il);
    }
    public void insta2(View view){
        String il = "https://www.instagram.com/programmer_sid/";
        webopen(il);
    }
    public void insta3(View view){
        String il = "https://www.instagram.com/p_r_i_y_a_n_s_h_u_official527/";
        webopen(il);
    }
    public void insta4(View view){
        String il = "https://www.instagram.com/iam_ragul/";
        webopen(il);
    }
    //linkedin
    public void LI1(View view){
        String il = "https://www.linkedin.com/in/harshit-shukla-6a4020214/";
        webopen(il);
    }
    public void LI2(View view){
        String il = "https://www.linkedin.com/in/siddharthabhattacharjee2345/";
        webopen(il);
    }
    public void LI3(View view){
        String il = "https://www.linkedin.com/in/priyanshu-dash-777649214/";
        webopen(il);
    }
    public void LI4(View view){
        String il = "https://www.linkedin.com/in/ragulsankar/";
        webopen(il);
    }
}