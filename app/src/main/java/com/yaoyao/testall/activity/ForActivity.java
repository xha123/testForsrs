package com.yaoyao.testall.activity;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

/**
 * Created by Administrator on 2017/9/15.
 */

public class ForActivity extends BaseActivity{

    TextView tv;
    int showone;
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
                    if (showone<1000){
                        showone++;
                        tv.setText(showone+"");
                        handler.sendEmptyMessageDelayed(1,1000);
                    }
                    break;
            }
        }
    };

}
