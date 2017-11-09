package com.yaoyao.testall.activity;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

/**
 * Created by Administrator on 2017/9/15.
 */

public class ForActivity extends BaseActivity{

    TextView tv;
    int showone,forone;
    EditText for_ed;
    @Override
    public void inidata() {
        
    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_for);
      
    }

    @Override
    public void iniview() {
        tv = (TextView) findViewById(R.id.for_text);
        for_ed = (EditText) findViewById(R.id.for_ed);
        findViewById(R.id.for_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Timer timer = new Timer();
//                timer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//
//                    }
//                });
                handler.sendEmptyMessageDelayed(1,1000);
                findViewById(R.id.for_bu).setClickable(false);
            }
        });
    }

    @Override
    public void setview() {
        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;

        Log.e(TAG, "setview: "+xdpi+"  "+ydpi );
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    forone = Integer.parseInt(for_ed.getText().toString());
                    if (showone<forone){
                        showone++;
                        Log.e(TAG, "handleMessage: "+showone );
//                        new Thread(new Runnable() {
//                            @Override
//                            public void run() {
////                                getIon();
//                            }
//                        }).start();
                        tv.setText(showone+"");
                        handler.sendEmptyMessageDelayed(1,1000);
                    }
                    break;
            }
        }
    };

    private void getIon() {
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

                    }
                });
    }

}
