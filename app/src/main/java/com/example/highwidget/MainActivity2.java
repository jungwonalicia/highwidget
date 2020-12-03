package com.example.highwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import java.util.StringTokenizer;

public class MainActivity2 extends AppCompatActivity {
    AutoCompleteTextView auto;
    MultiAutoCompleteTextView multi;
    Button getBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //2글자는 써주어야 해야 인식함.
        String[] items = {"CSI-뉴욕", "CSI-라스베가스", "CSI-마이애미", "Friends", "Fringe", "Lost"};

        auto = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        multi = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);
        getBtn = findViewById(R.id.getBtn);

        //배열의 값들을 textView에 자동으로 넣어주는 클래스(어댑터클래스, 붙여주는 클래스)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        //선택된 단어들을 콤마로 연결해서 텍스트뷰에 넣어주는 클래스
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(token);
        multi.setAdapter(adapter);

        getBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String auto2 = auto.getText().toString();
                String multi2 = multi.getText().toString();
                String total = auto2 + "," + multi2;
                Toast.makeText(getApplicationContext(), "전체 선택한 텍스트 리스트: " + total, Toast.LENGTH_SHORT).show();
                //split메서드 사용하여 분리하여 볼 것.
                StringTokenizer tokenizer = new StringTokenizer(total);
                int count = tokenizer.countTokens();
                Log.d("token1>>>>>>>> ",tokenizer.nextToken(","));
                Log.d("token2>>>>>>>> ",tokenizer.nextToken(","));
                Log.d("token3>>>>>>>> ",tokenizer.nextToken(",").trim());

                LinearLayout linearLayout = findViewById(R.id.linear1);

                Button btn = new Button(getApplicationContext()); //버튼을 선언
                btn.setText("나는 새로 만들어지는 버튼이야.");
                btn.setWidth(66);
                btn.setTextSize(11);
                btn.setId(100);
                linearLayout.addView(btn);

                Button btn2 = new Button(getApplicationContext()); //버튼을 선언
                btn2.setText("나는 새로 만들어지는 버튼이야.2");
                btn2.setWidth(66);
                btn2.setTextSize(11);
                btn2.setId(200);
                linearLayout.addView(btn2);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("새로 생긴 버튼을 눌렀어>>>>> " , view.getId() + "야");
                        if (view.getId() == 100){
                            Log.d("100번을 선택했네..>>> ", "신기하다!!!");
                        }
                    }
                });

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d("새로 생긴 버튼을 눌렀어>>>>> ", view.getId() + "야");
                    }
                });
            }
        });




    }
}