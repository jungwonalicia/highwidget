package com.example.highwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity12 extends AppCompatActivity {
    EditText edtUrl2;
    Button btnGo2, btnBack2;
    WebView webView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);

        edtUrl2 = findViewById(R.id.edtUrl2);
        btnGo2 = findViewById(R.id.btnGo2);
        btnBack2 = findViewById(R.id.btnBack2);
        webView2 = findViewById(R.id.webView2);

        webView2.setWebViewClient(new MyWebViewClient());
        WebSettings webSettings = webView2.getSettings();
        webSettings.setBuiltInZoomControls(true);

        btnGo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "GO버튼을 눌렀음. " + edtUrl2.getText().toString(), Toast.LENGTH_SHORT).show();
                webView2.loadUrl(edtUrl2.getText().toString());
            }
        });

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "BACK버튼을 눌렀음.", Toast.LENGTH_SHORT).show();
                webView2.goBack();
            }
        });
    }

    public class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

}

