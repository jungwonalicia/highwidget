package com.example.highwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    ScrollView scrollView;
    HorizontalScrollView scrollView3;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        scrollView = (ScrollView) findViewById(R.id.scrollView);

        //스크롤이 시작하자 마자 가장 아래부분으로 내려가고 하게 싶을
//        scrollView.post(new Runnable() {
//            public void run() {
//                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
//            }
//        });
        scrollView3 = (HorizontalScrollView) findViewById(R.id.scrollView3);
        textView2 = (TextView) findViewById(R.id.textView2);
        scrollView3.post(new Runnable() {
            public void run() {
                scrollView3.fullScroll(ScrollView.FOCUS_UP);
            }
        });

    }
}