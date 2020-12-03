package com.example.highwidget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Chronometer chronometer;
    Button start, end, calButton, timeButton, nextButton;
    CalendarView calendarView;
    TimePicker timePicker;
    int year, month, date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = (Chronometer) findViewById(R.id.ch);
        start = (Button) findViewById(R.id.start);
        end = (Button) findViewById(R.id.end);
        calButton = (Button) findViewById(R.id.calbutton);
        timeButton = (Button) findViewById(R.id.timebutton);
        nextButton = (Button) findViewById(R.id.nextbutton);
        calendarView = (CalendarView) findViewById(R.id.cal);
        timePicker = (TimePicker) findViewById(R.id.timer);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                chronometer.setTextColor(Color.RED);
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.stop();
                chronometer.setTextColor(Color.RED);
                Toast.makeText(getApplicationContext(), chronometer.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //AM/PM에 따라 시간과 분이 달라짐.
                int t = timePicker.getHour();
                int m = timePicker.getMinute();
                Toast.makeText(getApplicationContext(), t + "시 " + m + "분 ", Toast.LENGTH_SHORT).show();
            }
        });
        calButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (year != 0) {
                    Toast.makeText(getApplicationContext(), year + "년 "  + month + "월 " + date + "일 ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "날짜를 먼저 선택해주세요.!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
       calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
           @Override
           public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
               year = i; month = i1+1; date = i2;
               Toast.makeText(getApplicationContext(), year + "년 "  + month + "월 " + date + "일 ", Toast.LENGTH_SHORT).show();
           }
       });
       nextButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
               startActivity(intent);
           }
       });

    }
}