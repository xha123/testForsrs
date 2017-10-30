package com.yaoyao.testall.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

/**
 * Created by Administrator on 2017/9/29.
 */

public class ShowActivity extends BaseActivity{
    String showone;
    @Override
    public void inidata() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle!=null){
            showone = bundle.getString("url");
        }
    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_show);
    }

    @Override
    public void iniview() {
        TextView textView = (TextView) findViewById(R.id.show_tv);
        textView.setText(showone);
    }

    @Override
    public void setview() {

    }
}
