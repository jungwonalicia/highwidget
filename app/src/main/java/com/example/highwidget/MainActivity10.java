package com.example.highwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity10 extends AppCompatActivity {

    Button btnRead, btnWrite, open, save;
    EditText t1, t2, t3, t4, query;
    TextView list;

    Toast toast;
    View view1;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        btnRead = findViewById(R.id.btnRead);
        btnWrite = findViewById(R.id.btnWrite);
        open = findViewById(R.id.open);
        save = findViewById(R.id.save);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        query = findViewById(R.id.query);
        list = findViewById(R.id.list);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t1Text = t1.getText().toString();
                String t2Text = t2.getText().toString();
                String t3Text = t3.getText().toString();
                String t4Text = t4.getText().toString();
                Log.d("t1>>  " , t1Text);
                Log.d("t2>>  " , t2Text);
                Log.d("t3>>  " , t3Text);
                Log.d("t4>>  " , t4Text);

                try {
                    FileOutputStream outputStream = openFileOutput(t1Text + ".txt", Context.MODE_PRIVATE);
                    String str = t1Text + "\n" + t2Text + "\n" + t3Text + "\n" + t4Text + "\n" ;
                    outputStream.write(str.getBytes());
                    outputStream.close();
                    Toast.makeText(getApplicationContext(), t1Text + ".txt 파일이 생성됨.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outputStream = openFileOutput("file.txt", Context.MODE_PRIVATE);
                    String str = "내가 파일에 들어간다.";
                    outputStream.write(str.getBytes());
                    outputStream.close();
                    Toast.makeText(getApplicationContext(), "파일이 생성됨.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inputStream = openFileInput("out.txt");
                    byte[] txt = new byte[256];
                    inputStream.read(txt);
                    String str = new String(txt);
                    inputStream.close();
                    //Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    toast = new Toast(MainActivity10.this);
                    view1 = (View) View.inflate(MainActivity10.this, R.layout.toast1, null);
                    toast.setView(view1);
                    text = (TextView)view1.findViewById(R.id.toastText);
                    text.setText(str);
                    toast.show();
                } catch (Exception e) {
                    //Toast.makeText(getApplicationContext(), "파일없음.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        open.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    String queryName = query.getText().toString();
                    FileInputStream inputStream = openFileInput(queryName + ".txt");
                    byte[] txt = new byte[256];
                    inputStream.read(txt);
                    String str = new String(txt);
                    Log.d("읽어온 내용은 " , str);
                    Toast toast = new Toast(getApplicationContext());
                    View view1 = (View) View.inflate(getApplicationContext(), R.layout.toast1, null);
                    TextView text = (TextView)view1.findViewById(R.id.toastText);
                    text.setText(str);
                    toast.show();
                    String[] strArray = str.split("\n");
                    for (String s: strArray){
                        Log.d("분리된 단어는 " , s);
                    }
                    inputStream.close();
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    list.setText(str);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "에러!" , Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });
    }
}