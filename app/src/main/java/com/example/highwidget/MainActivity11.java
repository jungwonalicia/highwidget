package com.example.highwidget;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;

public class MainActivity11 extends AppCompatActivity {
    Button raw_read, sd_read, sd_write, sd_dir_mk, sd_dir_del, sd_list;
    EditText raw_data, raw_data2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        raw_read = findViewById(R.id.raw_read);
        raw_data = findViewById(R.id.raw_data);
        raw_data2 = findViewById(R.id.raw_data2);
        sd_read = findViewById(R.id.sd_read);
        sd_write = findViewById(R.id.sd_write);
        sd_dir_mk = findViewById(R.id.sd_dir_mk);
        sd_dir_del = findViewById(R.id.sd_dir_del);
        sd_list = findViewById(R.id.sd_list);
//permission획득!!
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
//res.raw.raw_test.txt에서 읽어들여!!

        raw_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = getResources().openRawResource(R.raw.raw_test);
                    byte[] txt = new byte[inputStream.available()];
                    inputStream.read(txt);
                    raw_data.setText(new String(txt));
                    inputStream.close();
                }catch (FileNotFoundException e1){
                    e1.printStackTrace();
                    Log.d("raw파일 존재 결과 >>>>", "파일이 존재하지 않음.");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("raw파일 읽기 결과 >>>>", "파일을 읽는 중 에러 발생");
                }
            }
        });


        sd_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream fileOutputStream = null;

                try {
                    fileOutputStream = new FileOutputStream("/sdcard/out.txt");
                    String str = "i will be back!!!";
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                    print("sdcard/out.txt 파일이 생성됨.");
                }catch (Exception e){
                    print("sdcard/out.txt 파일생성에 문제가 있음.");
                    e.printStackTrace();
                }
            }
        });

        sd_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    InputStream inputStream = new FileInputStream("sdcard/out.txt");
                    byte[] txt = new byte[inputStream.available()];
                    inputStream.read(txt);
                    raw_data2.setText(new String(txt));
                    inputStream.close();
                }catch (FileNotFoundException e1){
                    e1.printStackTrace();
                    print("out.txt파일 존재 결과 >>>> 파일이 존재하지 않음.");
                } catch (IOException e) {
                    e.printStackTrace();
                    print("out.txt파일 읽기 결과 >>>> 파일을 읽는 중 에러 발생");
                }
            }
        });
        final String strSDPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        final File myDir = new File(strSDPath + "/mydir");

        sd_dir_mk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.mkdir();
            }
        });

        sd_dir_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDir.delete();
            }
        });

        sd_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sysDir = Environment.getRootDirectory().getAbsolutePath();
                File[] sysFiles = (new File(sysDir).listFiles());

                String string;
                for(int i=0; i<sysFiles.length; i++){
                    if(sysFiles[i].isDirectory() != true){
                        string = "- 폴더>> " + sysFiles[i].toString();
                    }else{
                        string = "- 파일>> " + sysFiles[i].toString();
                    }
                    sd_list.setText(sd_list.getText() + "\n" + string);
                }

            }
        });

    }
    public void print(String result){
        Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
    }
}