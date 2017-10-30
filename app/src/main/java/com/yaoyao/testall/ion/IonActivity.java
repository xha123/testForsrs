package com.yaoyao.testall.ion;

import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ProgressCallback;
import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

import java.io.File;

/**
 * Created by Administrator on 2017/9/18.
 */

public class IonActivity extends BaseActivity{
    TextView tv;
    ProgressBar progressBar;

    @Override
    public void inidata() {

    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_ion);
    }

    @Override
    public void iniview() {
        tv = (TextView) findViewById(R.id.ion_text);
        progressBar = (ProgressBar) findViewById(R.id.ion_pro);
    }

    @Override
    public void setview() {
        findViewById(R.id.ion_bu1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCall();
            }
        });
        findViewById(R.id.ion_bu2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postCall();
            }
        });
        findViewById(R.id.ion_bu3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proCall();
            }
        });
    }

    private void proCall() {
        Ion.with(this)
                .load("https://raw.githubusercontent.com/jdsjlzx/LRecyclerView/master/app/app-release.apk")
                .progress(progressCallback)
                .write(new File(Environment.getExternalStorageDirectory(), "thisfile0921"))
                .setCallback(new FutureCallback<File>() {
                    @Override
                    public void onCompleted(Exception e, File result) {
                        if (e!=null){
                            Log.e(TAG, "onCompleted: 失败"+e.toString() );
                        }
                        if (result!=null){
                            Log.e(TAG, "onCompleted: 成功"+result.getAbsolutePath() );
                            BaseActivity.showtoast(IonActivity.this,"下载成功");
                        }

                    }

                });

    }

    ProgressCallback progressCallback = new ProgressCallback() {
        @Override
        public void onProgress(long downloaded, long total) {
            int showone = (int) ((downloaded/total)*100);
            progressBar.setProgress(showone);
        }
    };


    private void postCall() {
        Ion.with(this)
                .load("http://203.223.146.182/Takeout/user/front/seebanner")
                .setBodyParameter("loginid","54683154135321")
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        if (e!=null){
                            Log.e(TAG, "onCompleted: 错误"+e.toString() );
                        }
                        tv.setText(result.toString());
                    }
                });
    }

    private void getCall() {
        Ion.with(this)
                .load("http://203.223.146.182/Takeout/user/front/homelink")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        if (e!=null){
                            Log.e(TAG, "onCompleted: 错误"+e.toString() );
                        }
                        tv.setText(result.toString());
                    }
                });
    }
}
