package com.yaoyao.testall.androidCrop;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

/**
 * Created by Administrator on 2017/10/31.
 */

public class AcropActivity extends BaseActivity{
    ImageView showimg;

    @Override
    public void inidata() {

    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_acrop);
    }

    @Override
    public void iniview() {
        showimg = (ImageView) findViewById(R.id.acrop_img);
        showimg.setImageResource(R.mipmap.uc4);
    }

    @Override
    public void setview() {
        findViewById(R.id.acrop_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
