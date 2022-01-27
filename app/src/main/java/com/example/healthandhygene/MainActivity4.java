package com.example.healthandhygene;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {
    EditText Hcm;
    EditText w;
    TextView bmiout;
    TextView statusout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Hcm = findViewById(R.id.height1);
        w = findViewById(R.id.weight1);
        bmiout = findViewById(R.id.bmiout);
        statusout = findViewById(R.id.statusout);
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
            finish();
        }
        return super.onOptionsItemSelected(item);

    }
    public void bmi(View view){
        String Hcm_t = Hcm.getText().toString();
        int Hcm_val = Integer.parseInt(Hcm_t);
        String W_t = w.getText().toString();
        int W_val = Integer.parseInt(W_t);
        double Hc = (double) Hcm_val;
        double Hm  = Hc/100;
        double bmi_val = W_val/(Hm*Hm);
        bmiout.setText(String.format("%.2f",bmi_val));
        if(bmi_val<=18.5){
            statusout.setText("You Are Underweight");
        }
        else if(bmi_val>18.5 && bmi_val<25){
            statusout.setText("You have Normal BMI");
        }
        else if(bmi_val>=25 && bmi_val<30){
            statusout.setText("You are Overweight");
        }
        else if(bmi_val>=30 && bmi_val<35){
            statusout.setText("You are Obese");
        }
        else if(bmi_val>=35 && bmi_val<40){
            statusout.setText("You are Highly Obese");
        }
        else{
            statusout.setText("You are Extremely Obese");
        }
    }
    public void linkhealthydiet(View view){
        Intent i = new Intent(this,MainActivity3.class);
        startActivity(i);
        finish();
    }
    public void openstepcounter(View view){
        Intent i = new Intent(this,MainActivity5.class);
        startActivity(i);
    }
}