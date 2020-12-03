package com.example.highwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView text3;
    Button top;
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        text3= (TextView) findViewById(R.id.text3);
        top = (Button)findViewById(R.id.handle3);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag != true) {
                    flag = true;
                    text3.setText("안녕..!!!");
                    top.setText("정말 끝내고 싶으면 나를 눌러요.!");
                }else{
                    finish();
                }
            }
        });
    }
}