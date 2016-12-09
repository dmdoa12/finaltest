package com.example.a403.myapplication11;

import android.support.v7.app.AppCompatActivity;
import android.os.SystemClock;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Chronometer;
import android.widget.LinearLayout;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private double totalAmount=0;
    final int adult=15000;
    final int teenager=12000;
    final int child = 8000;
    EditText et1,et2,et3;
    RadioGroup rg1;
    ImageView iv1;
    TextView tv1,tv2,tv3;

    Switch swi_start;
    Chronometer crono;
    LinearLayout layand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swi_start = (Switch)findViewById(R.id.swi_start);
        crono = (Chronometer) findViewById(R.id.chronometer2);
        layand = (LinearLayout)findViewById(R.id.landSystem);
        et1 = (EditText)findViewById(R.id.editText1);
        et2 = (EditText)findViewById(R.id.editText2);
        et3 = (EditText)findViewById(R.id.editText3);
        rg1 = (RadioGroup)findViewById(R.id.radioGroup);
        iv1 = (ImageView)findViewById(R.id.imageView);
        swi_start.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(swi_start.isChecked()){
                    crono.setBase(SystemClock.elapsedRealtime());
                    crono.start();
                    layand.setVisibility(View.VISIBLE);
                } else {
                    layand.setVisibility(View.GONE);
                }
            }
        });

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioButton){
                    iv1.setImageResource(R.drawable.land1);
                }
                else if(checkedId==R.id.radioButton2){
                    iv1.setImageResource(R.drawable.land2);
                }
                else{
                    iv1.setImageResource(R.drawable.land3);
                }
            }
        });
    }
}
