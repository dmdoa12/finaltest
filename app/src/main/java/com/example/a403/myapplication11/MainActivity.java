package com.example.a403.myapplication11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
    Switch swi_start;
    Chronometer crono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swi_start = (Switch)findViewById(R.id.swi_start);
        crono = (Chronometer) findViewById(R.id.chronometer2);

        swi_start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(swi_start.isChecked()){
                    crono.setBase(SystemClock.elapsedRealtime());
                    crono.start();
                } else {

                }
            }
        });
    }
}
