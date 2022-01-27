package com.example.healthandhygene;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity implements SensorEventListener, StepListener{
    private TextView textView;
    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    private int numSteps;
    TextView TvSteps;
    Button BtnStart;
    Button BtnStop;
    TextView pms;
    TextView tv2;
    int lastSteps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);

        TvSteps = findViewById(R.id.tv_steps);
        BtnStart = findViewById(R.id.btn_start);
        BtnStop = findViewById(R.id.btn_stop);
        pms = findViewById(R.id.PMS);
        tv2 = findViewById(R.id.tv_steps2);
        SharedPreferences sp = getSharedPreferences("vals",MODE_PRIVATE);
        lastSteps = sp.getInt("laststeps",0);
        int hs = sp.getInt("laststeps",0);
        tv2.setText("Highest Score : "+hs);


        BtnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                SharedPreferences sp = getSharedPreferences("vals",MODE_PRIVATE);
                numSteps = sp.getInt("steps",0);
                pms.setText("PADOMETER RUNNING");
                sensorManager.registerListener(MainActivity5.this, accel, SensorManager.SENSOR_DELAY_FASTEST);

            }
        });


        BtnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                pms.setText("PADOMETER PAUSED");
                SharedPreferences sp = getSharedPreferences("vals",MODE_PRIVATE);
                SharedPreferences.Editor ed = sp.edit();
                if(numSteps>=lastSteps){
                    ed.putInt("laststeps",numSteps);
                    ed.apply();
                    lastSteps = numSteps;
                }
                ed.putInt("steps",numSteps);
                ed.apply();
                sensorManager.unregisterListener(MainActivity5.this);

            }
        });

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
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        SharedPreferences sp = getSharedPreferences("vals",MODE_PRIVATE);

        if(numSteps==lastSteps && numSteps!=0){
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.chyme);
            mediaPlayer.start();
        }
        if(numSteps>=lastSteps){
            tv2.setText("Highest Score : "+numSteps);
        }
        TvSteps.setText(TEXT_NUM_STEPS + numSteps);
    }

    public void resetsteps(View view){
    SharedPreferences sp = getSharedPreferences("vals",MODE_PRIVATE);
    SharedPreferences.Editor ed = sp.edit();
    if(numSteps>lastSteps){
        ed.putInt("laststeps",numSteps);
    }
    ed.putInt("steps",0);
    ed.apply();
    numSteps = 0;
    TvSteps.setText(TEXT_NUM_STEPS + "0");
    }
}