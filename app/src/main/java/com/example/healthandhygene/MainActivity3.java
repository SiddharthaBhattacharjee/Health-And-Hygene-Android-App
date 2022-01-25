package com.example.healthandhygene;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    TextView outtext;
    EditText age;
    EditText height;
    EditText weight;
    RadioGroup selectgender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        outtext = findViewById(R.id.outtext);
        age = findViewById(R.id.age);
        height = findViewById(R.id.height1);
        weight = findViewById(R.id.weight1);
        selectgender = findViewById(R.id.gender);

    }
    public void calc(View view){
        int selected = selectgender.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(selected);
        String gender = radioButton.getText().toString();
        int weight_val = Integer.parseInt(weight.getText().toString());
        int height_val = Integer.parseInt(height.getText().toString());
        int age_val = Integer.parseInt(age.getText().toString());
        if(gender.equals("Male")){
            double bmr_val = 10*weight_val+6.25*height_val-5*age_val+5;
            String bmr = String.format("%.2f",bmr_val);
            outtext.setText("Your Recomended Daily Calorie Input is : "+bmr+"Kcal");
        }
        else if(gender.equals("Female")){
            double bmr = 10*weight_val+6.25*height_val-5*age_val-161;
            outtext.setText("Your Recomended Daily Calorie Input is : "+bmr+"Kcal");
        }
        else{
            Toast.makeText(this, "no gender found", Toast.LENGTH_SHORT).show();
        }

    }
}