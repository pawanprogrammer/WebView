package com.trishasofttech.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.webview);
        /*webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.loadUrl("https://wakeuptechnology.co.in/");*/

        setupWebView();
    }

    private void setupWebView() {
        webView.getSettings().setSaveFormData(false);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT)
            webView.getSettings().setSavePassword(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        webView.getSettings().setAppCacheEnabled(true);
        webView.loadUrl("https://wakeuptechnology.co.in/");
        webView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                //progressBar.setVisibility(View.GONE);
                webView.loadUrl("https://wakeuptechnology.co.in/");

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                //progressBar.setVisibility(View.GONE);
            }

        });
    }
}