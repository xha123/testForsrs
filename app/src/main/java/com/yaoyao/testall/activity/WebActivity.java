package com.yaoyao.testall.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;


/**  网络展示页面
 * Created by Administrator on 2017/6/29.
 */

public class WebActivity extends BaseActivity {
    WebView webView;
    String mUrl,title;
    TextView title_tv;
    ImageView back_iv;
    ProgressBar progressBar;
    @Override
    public void inidata() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!=null){
            mUrl = bundle.getString("url");
            title = bundle.getString("title");
            if (mUrl.contains("http://")||mUrl.contains("https://")){
                Log.e(TAG, "inidata: "+mUrl );
            }else {
                mUrl = "http://"+mUrl;
            }
        }
    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_webpay);
    }

    @Override
    public void iniview() {
        webView = (WebView) findViewById(R.id.webpay_web);
        progressBar = (ProgressBar) findViewById(R.id.web_pro);
        back_iv = (ImageView) findViewById(R.id.title_back_iv);
        title_tv = (TextView) findViewById(R.id.title_tv);
        title_tv.setText(title);
        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void setview() {

        WebSettings mWebSettings = webView.getSettings();
        mWebSettings.setSupportZoom(true);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setUseWideViewPort(true);
//        mWebSettings.setSupportZoom(true);
//        mWebSettings.setBuiltInZoomControls(true);
//        mWebSettings.setDisplayZoomControls(false);
        mWebSettings.setDefaultTextEncodingName("utf-8");
        mWebSettings.setLoadsImagesAutomatically(true);
        webView.setWebViewClient(webViewClient);
        webView.loadUrl(mUrl);

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress ==100){
                    progressBar.setVisibility(View.GONE);
                }else {
                    progressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });

    }

    WebViewClient webViewClient = new WebViewClient(){


        /**
         * 多页面在同一个WebView中打开，就是不新建activity或者调用系统浏览器打开
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.e(TAG, "shouldOverrideUrlLoading: "+url );
            view.loadUrl(url);
            return true;
        }

    };


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
