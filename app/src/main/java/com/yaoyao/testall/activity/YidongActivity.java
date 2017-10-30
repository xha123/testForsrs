package com.yaoyao.testall.activity;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

/**
 * Created by Administrator on 2017/9/27.
 */

public class YidongActivity extends BaseActivity{
    ImageView imageView;
    RelativeLayout relativeLayout;
    float xdown,ydown;
    int Xmove,Ymove;
    int kleft,ktop;
    @Override
    public void inidata() {

    }

    @Override
    public void setCon() {
        setContentView(R.layout.yidong);
    }

    @Override
    public void iniview() {
        imageView = (ImageView) findViewById(R.id.yd_img);
        relativeLayout = (RelativeLayout) findViewById(R.id.yd_rl);
        kleft = 240;
        ktop = 600;
        Log.e(TAG, "iniview: 位置"+imageView.getTop()+"  "+imageView.getLeft() );
    }


    @Override
    public void setview() {
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        relativeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        xdown = event.getRawX();
                        ydown = event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Xmove = (int) (event.getRawX() - xdown);
                        Ymove = (int) (event.getRawY()  - ydown);
                        Log.e(TAG, "onTouch: 移动距离"+Xmove+"  "+Ymove );
                        genMove(Xmove,Ymove);
                        break;
                    case MotionEvent.ACTION_UP:
                        kleft = imageView.getLeft();
                        ktop = imageView.getTop();
                        break;
                }
                return false;
            }
        });
    }

    private void genMove(int xmove,int ymove) {
        //        int left = rawX - view.getWidth() ;
        int left = kleft + xmove;
        int width = left + imageView.getWidth();
        int top =  ktop + ymove ;
//        int width = left + view.getWidth();
        int height = top + imageView.getHeight();
        Log.e(TAG, "moveViewByLayout: "+left+"  "+top +" "+width+" "+height );
        imageView.layout(left, top, width, height);
    }
}
