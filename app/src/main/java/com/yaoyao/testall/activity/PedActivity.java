package com.yaoyao.testall.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Administrator on 2017/9/19.
 */

public class PedActivity extends BaseActivity{
    Button bu1,bu2;

    @Override
    public void inidata() {

    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_ped);
    }

    @Override
    public void iniview() {
        findViewById(R.id.ped_bu1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(PedActivity.this)
                        .setTitleText("Here's a message!")
                        .show();
            }
        });
        findViewById(R.id.ped_bu2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SweetAlertDialog pDialog = new SweetAlertDialog(PedActivity.this, SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("Loading");
                pDialog.setCancelable(true);
                pDialog.show();
            }
        });

        findViewById(R.id.ped_bu3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(PedActivity.this)
                        .setTitleText("Here's a message!")
                        .setContentText("It's pretty, isn't it?")
                        .show();
            }
        });

        findViewById(R.id.ped_bu4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(PedActivity.this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Something went wrong!")
                        .show();
            }
        });
        findViewById(R.id.ped_bu5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(PedActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .show();
            }
        });

        findViewById(R.id.ped_bu6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(PedActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Good job!")
                        .setContentText("You clicked the button!")
                        .show();
            }
        });

        findViewById(R.id.ped_bu7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(PedActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("Sweet!")
                        .setContentText("Here's a custom image.")
                        .setCustomImage(R.drawable.custom_img)
                        .show();
            }
        });

    }

    @Override
    public void setview() {

    }
}
