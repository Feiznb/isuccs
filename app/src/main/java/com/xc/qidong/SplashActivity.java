package com.xc.qidong;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class SplashActivity extends Activity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 直接创建WebView，不依赖布局文件
        webView = new WebView(this);
        setContentView(webView);

        // 隐藏状态栏和导航栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );
        }

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new AndroidInterface(), "android");
        webView.loadUrl("file:///android_asset/splash.html");
    }

    public class AndroidInterface {
        @JavascriptInterface
        public void onAnimationFinished() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // 动画结束后跳转到主界面，不再闪退
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        // 禁用返回键，防止用户中途退出动画
    }
}
