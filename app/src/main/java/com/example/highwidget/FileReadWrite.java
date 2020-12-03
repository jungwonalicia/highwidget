package com.example.highwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWrite extends AppCompatActivity {
    Button btnRead, btnWrite, open, save;
    EditText t1, t2, t3, t4, query;
    TextView list;

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

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream fileOutputStream = openFileOutput("out2.txt", Context.MODE_PRIVATE);
                    String str = "내가 파일에 들어가요...!!";
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(), "파일이 생성됨.", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream inputStream = openFileInput("out2.txt");
                    byte[] txt = new byte[256];
                    inputStream.read(txt);
                    String str = new String(txt);
                    inputStream.close();
                    Toast toast = new Toast(getApplicationContext());
                    View view1 = (View) View.inflate(getApplicationContext(), R.layout.toast1, null);
                    TextView text = (TextView)view1.findViewById(R.id.toastText);
                    text.setText(str);
                    toast.show();
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "파일없음.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

    }
}