package com.yaoyao.testall.chanel;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

/**
 * Created by Administrator on 2017/9/26.
 */

public class ChanelActivity extends BaseActivity{
    ImageView iv1,iv2,iv3,iv4,iv5,iv6;
    RelativeLayout chanel_rl;
    int hight,allhight;
    int showimg ;
    int top1,top2,top3,top4,top5,top6;
    float xdown,ydown;
    int Ymove,Xmove;
    boolean isone;
    boolean ishuadong;

    @Override
    public void inidata() {
        showimg = 6;
    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_chanel);
    }

    @Override
    public void iniview() {
        iv1 = (ImageView) findViewById(R.id.chanel_iv1);
        iv2 = (ImageView) findViewById(R.id.chanel_iv2);
        iv3 = (ImageView) findViewById(R.id.chanel_iv3);
        iv4 = (ImageView) findViewById(R.id.chanel_iv4);
        iv5 = (ImageView) findViewById(R.id.chanel_iv5);
        iv6 = (ImageView) findViewById(R.id.chanel_iv6);
        chanel_rl = (RelativeLayout) findViewById(R.id.chanel_rl);

        hight = iv1.getLayoutParams().height;

    }

    @Override
    public void setview() {
        chanel_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        chanel_rl.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                            isone= true;
                            top1 = iv1.getTop();
                            top2 = iv2.getTop();
                            top3 = iv3.getTop();
                            top4 = iv4.getTop();
                            top5 = iv5.getTop();
                            top6 = iv6.getTop();
                            Log.e(TAG, "iniview: top"+top1+"  "+top2+"  "+top3+"  "+top4+"  "+top5+"  "+top6+"  " );
                        xdown = event.getRawX();
                        ydown = event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Xmove = (int) (event.getRawX() - xdown);
                        Ymove = (int) (event.getRawY()  - ydown);
//                        genMove(Ymove);
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.e(TAG, "onTouch: "+Xmove+"   "+Ymove );
//                        if (ishuadong){
//                            break;
//                        }else {
                            ishuadong = true;

                            if (Ymove>20){//往下滑动
                                setXia(0);

                            }else if(Ymove<-20){//往上滑动
                                setShang(0);
                            }
//                        }

                        break;
                }
                return false;
            }
        });
    }

    private void genMove(int moveY) {
        Log.e(TAG, "genMove: Y轴移动"+moveY );
        if (showimg==6){
            if (moveY>0){
                return;
            }
            moveViewByLayout(iv6,top6, moveY);
            if (moveY<-hight+top5){
                moveViewByLayout(iv5,top5,moveY+top5-hight);
                moveViewByLayout(iv4,top4,moveY+top5-hight);
                moveViewByLayout(iv3,top3, moveY+top5-hight);
            }

        }else if (showimg==5){
            moveViewByLayout(iv6,top6, moveY);
            moveViewByLayout(iv5,top5,moveY);
            moveViewByLayout(iv4,top4,moveY);
            moveViewByLayout(iv3,top3, moveY);
            moveViewByLayout(iv2,top2,moveY);
        }else if (showimg==4){
            moveViewByLayout(iv4,top4,moveY);
        }else if (showimg==3){
            moveViewByLayout(iv3,top3, moveY);
        }else if (showimg==2){
            moveViewByLayout(iv2,top2,moveY);
        }else if (showimg==1){
            if (moveY<0){
                return;
            }
            moveViewByLayout(iv1,top1, (int) moveY);
        }
    }

    /**
     * 通过layout方法，移动view
     * 优点：对view所在的布局，要求不苛刻，不要是RelativeLayout，而且可以修改view的大小
     *
     * @param view //移动的view
     * @param ktop  //距离顶部
     * @param rawY  //移动距离
     */
    private void moveViewByLayout(View view, int ktop, int rawY) {
        int left = 0;
        int width = left + view.getWidth();
        int top = ktop + rawY;
//        int width = left + view.getWidth();
        int height = top + view.getHeight();
//        Log.e(TAG, "moveViewByLayout: "+left+"  "+top +" "+width+" "+height );
        view.layout(left, top, width, height);
    }

    //往上滑动
    private void setShang(int ymove) {
        if (showimg==6){
            TranslateAnimation animation1 = new TranslateAnimation(0,0,0,-hight-ymove);
            animation1.setDuration(600);
            animation1.setFillAfter(true);
            iv6.startAnimation(animation1);

            TranslateAnimation animation2 = new TranslateAnimation(0,0,0,-300-ymove);
            animation2.setDuration(600);
            animation2.setFillAfter(true);
            iv5.startAnimation(animation2);

            TranslateAnimation animation3 = new TranslateAnimation(0,0,0,-300-ymove);
            animation3.setDuration(600);
            animation3.setFillAfter(true);
            iv4.startAnimation(animation3);

            TranslateAnimation animation4 = new TranslateAnimation(0,0,0,-150-ymove);
            animation4.setDuration(600);
            animation4.setFillAfter(true);
            iv3.startAnimation(animation4);

//            TranslateAnimation animation5 = new TranslateAnimation(0,0,0,-150);
//            animation5.setDuration(600);
//            animation5.setFillAfter(true);
//            iv2.startAnimation(animation5);

//            TranslateAnimation animation6 = new TranslateAnimation(0,0,0,-150);
//            animation6.setDuration(600);
//            animation6.setFillAfter(true);
//            iv1.startAnimation(animation6);
            showimg--;
        }else if (showimg==5){
            TranslateAnimation animation2 = new TranslateAnimation(0,0,-300,-hight-300-ymove);
            animation2.setDuration(600);
            animation2.setFillAfter(true);
            iv5.startAnimation(animation2);

            TranslateAnimation animation3 = new TranslateAnimation(0,0,-300,-300-300-ymove);
            animation3.setDuration(600);
            animation3.setFillAfter(true);
            iv4.startAnimation(animation3);

            TranslateAnimation animation4 = new TranslateAnimation(0,0,-150,-300-150-ymove);
            animation4.setDuration(600);
            animation4.setFillAfter(true);
            iv3.startAnimation(animation4);

            TranslateAnimation animation5 = new TranslateAnimation(0,0,0,-150-ymove);
            animation5.setDuration(600);
            animation5.setFillAfter(true);
            iv2.startAnimation(animation5);

//            TranslateAnimation animation6 = new TranslateAnimation(0,0,0,-150);
//            animation6.setDuration(600);
//            animation6.setFillAfter(true);
//            iv1.startAnimation(animation6);

            showimg--;
        }else if (showimg==4){
            TranslateAnimation animation3 = new TranslateAnimation(0,0,-600,-hight-300-300);
            animation3.setDuration(600);
            animation3.setFillAfter(true);
            iv4.startAnimation(animation3);

            TranslateAnimation animation4 = new TranslateAnimation(0,0,-450,-300-300-200);
            animation4.setDuration(600);
            animation4.setFillAfter(true);
            iv3.startAnimation(animation4);

            TranslateAnimation animation5 = new TranslateAnimation(0,0,-150,-300-150);
            animation5.setDuration(600);
            animation5.setFillAfter(true);
            iv2.startAnimation(animation5);

            TranslateAnimation animation6 = new TranslateAnimation(0,0,0,-150);
            animation6.setDuration(600);
            animation6.setFillAfter(true);
            iv1.startAnimation(animation6);

            showimg--;

        }else if (showimg==3){
            TranslateAnimation animation4 = new TranslateAnimation(0,0,-800,-hight-600-200);
            animation4.setDuration(600);
            animation4.setFillAfter(true);
            iv3.startAnimation(animation4);

            TranslateAnimation animation5 = new TranslateAnimation(0,0,-450,-300-300-200);
            animation5.setDuration(600);
            animation5.setFillAfter(true);
            iv2.startAnimation(animation5);

            TranslateAnimation animation6 = new TranslateAnimation(0,0,-150,-300);
            animation6.setDuration(600);
            animation6.setFillAfter(true);
            iv1.startAnimation(animation6);

            showimg--;
        }else if (showimg==2){
            TranslateAnimation animation5 = new TranslateAnimation(0,0,-800,-hight-300-300-200);
            animation5.setDuration(600);
            animation5.setFillAfter(true);
            iv2.startAnimation(animation5);

            TranslateAnimation animation6 = new TranslateAnimation(0,0,-300,-300-300-200);
            animation6.setDuration(600);
            animation6.setFillAfter(true);
            iv1.startAnimation(animation6);

            showimg--;
        }else if (showimg==1){
            BaseActivity.showtoast(this,"到底啦！！！");
        }

    }

    //往下滑动
    private void setXia(int ymove) {
        if (showimg==6){
            BaseActivity.showtoast(this,"到头啦！！！");
        }else if (showimg==5){
            TranslateAnimation animation1 = new TranslateAnimation(0,0,-300,0);
            animation1.setDuration(600);
            animation1.setFillAfter(true);
            iv5.startAnimation(animation1);
            TranslateAnimation animation2 = new TranslateAnimation(0,0,-hight,0);
            animation2.setDuration(600);
            animation2.setFillAfter(true);
            iv6.startAnimation(animation2);

            TranslateAnimation animation3 = new TranslateAnimation(0,0,-300,0);
            animation3.setDuration(600);
            animation3.setFillAfter(true);
            iv4.startAnimation(animation3);

            TranslateAnimation animation4 = new TranslateAnimation(0,0,-150,0);
            animation4.setDuration(600);
            animation4.setFillAfter(true);
            iv3.startAnimation(animation4);

//            TranslateAnimation animation5 = new TranslateAnimation(0,0,-150,0);
//            animation5.setDuration(600);
//            animation5.setFillAfter(true);
//            iv2.startAnimation(animation5);
//
//            TranslateAnimation animation6 = new TranslateAnimation(0,0,-150,0);
//            animation6.setDuration(600);
//            animation6.setFillAfter(true);
//            iv1.startAnimation(animation6);
            showimg++;
        }else if (showimg==4){
            TranslateAnimation animation1 = new TranslateAnimation(0,0,-hight-300,-300);
            animation1.setDuration(600);
            animation1.setFillAfter(true);
            iv5.startAnimation(animation1);

            TranslateAnimation animation3 = new TranslateAnimation(0,0,-300-300,-300);
            animation3.setDuration(600);
            animation3.setFillAfter(true);
            iv4.startAnimation(animation3);

            TranslateAnimation animation4 = new TranslateAnimation(0,0,-150-300,-150);
            animation4.setDuration(600);
            animation4.setFillAfter(true);
            iv3.startAnimation(animation4);

            TranslateAnimation animation5 = new TranslateAnimation(0,0,-150,0);
            animation5.setDuration(600);
            animation5.setFillAfter(true);
            iv2.startAnimation(animation5);
//
//            TranslateAnimation animation6 = new TranslateAnimation(0,0,-150,0);
//            animation6.setDuration(600);
//            animation6.setFillAfter(true);
//            iv1.startAnimation(animation6);
            showimg++;
        }else if (showimg==3){
            TranslateAnimation animation3 = new TranslateAnimation(0,0,-hight-300-300,-300-300);
            animation3.setDuration(600);
            animation3.setFillAfter(true);
            iv4.startAnimation(animation3);

            TranslateAnimation animation4 = new TranslateAnimation(0,0,-200-300-300,-450);
            animation4.setDuration(600);
            animation4.setFillAfter(true);
            iv3.startAnimation(animation4);

            TranslateAnimation animation5 = new TranslateAnimation(0,0,-450,-150);
            animation5.setDuration(600);
            animation5.setFillAfter(true);
            iv2.startAnimation(animation5);

            TranslateAnimation animation6 = new TranslateAnimation(0,0,-150,0);
            animation6.setDuration(600);
            animation6.setFillAfter(true);
            iv1.startAnimation(animation6);
            showimg++;
        }else if (showimg==2){
            TranslateAnimation animation4 = new TranslateAnimation(0,0,-hight-200-300-300,-200-300-300);
            animation4.setDuration(600);
            animation4.setFillAfter(true);
            iv3.startAnimation(animation4);

            TranslateAnimation animation5 = new TranslateAnimation(0,0,-200-300-300,-150-300);
            animation5.setDuration(600);
            animation5.setFillAfter(true);
            iv2.startAnimation(animation5);

            TranslateAnimation animation6 = new TranslateAnimation(0,0,-300,-150);
            animation6.setDuration(600);
            animation6.setFillAfter(true);
            iv1.startAnimation(animation6);
            showimg++;
        }else if (showimg==1){
            TranslateAnimation animation5 = new TranslateAnimation(0,0,-hight-800,-800);
            animation5.setDuration(600);
            animation5.setFillAfter(true);
            iv2.startAnimation(animation5);

            TranslateAnimation animation6 = new TranslateAnimation(0,0,-800,-300);
            animation6.setDuration(600);
            animation6.setFillAfter(true);
            iv1.startAnimation(animation6);
            showimg++;
        }
    }
}
