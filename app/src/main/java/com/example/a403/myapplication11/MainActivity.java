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
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private double totalAmount=0;
    final int adult=15000;
    final int teenager=12000;
    final int child = 8000;
    EditText et1,et2,et3;
    RadioGroup rg1;
    ImageView iv1;
    TextView tv1,tv2,tv3;
    Button bt1,bt2,bt3,bt4;

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
        bt1 = (Button)findViewById(R.id.complete);
        tv1 = (TextView)findViewById(R.id.textView3);
        tv2 = (TextView)findViewById(R.id.textView4);
        tv3 = (TextView)findViewById(R.id.textView5);

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

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adultCount = Integer.parseInt(et1.getText().toString());
                int teenagerCount = Integer.parseInt(et2.getText().toString());
                int childCount = Integer.parseInt(et3.getText().toString());
                double saleAmount=0;
                totalAmount += adult*adultCount;
                totalAmount += teenager*teenagerCount;
                totalAmount += child*childCount;

                if(adultCount==0  || teenagerCount==0 || childCount==0){
                    Toast.makeText(getApplicationContext(), "인원을 입력하세요", Toast.LENGTH_SHORT).show();
                }

                if(rg1.getCheckedRadioButtonId()==R.id.radioButton) {
                    totalAmount = totalAmount * 0.95;
                    saleAmount = totalAmount * 0.05;
                }
                else if(rg1.getCheckedRadioButtonId()==R.id.radioButton2){
                    totalAmount = totalAmount*0.9;
                    saleAmount = totalAmount * 0.1;
                }
                else if(rg1.getCheckedRadioButtonId()==R.id.radioButton3){
                    totalAmount = totalAmount*0.8;
                    saleAmount = totalAmount * 0.2;
                }
                tv1.setText("총 명수 : "+(adultCount+teenagerCount+childCount));
                String Amount= String.format("%.1f", totalAmount);
                String Amount2 = String.format("%.1f", saleAmount);
                tv2.setText("할인금액: "+saleAmount);
                tv3.setText("결제금액 : "+Amount);
                totalAmount = 0;
            }
        });
    }
}
