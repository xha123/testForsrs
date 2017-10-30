package com.yaoyao.testall.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.yaoyao.testall.app.AppManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Activity基类 解决代码复用性
 * Created on 2016/11/16.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public static final String TAG = "msg";

//    private ProgressDialogFragment _progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //透明状态栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        //透明导航栏
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        AppManager.getAppManager().addActivity(this);
        inidata();
        setCon();
        iniview();
        setview();

    }


    public abstract void inidata();
    public abstract void setCon();
    public abstract void iniview();
    public abstract void setview();
//    public abstract void setOnclick();

    @Override
    protected void onDestroy() {
        AppManager.getAppManager().finishActivity(this);
        super.onDestroy();
    }

    @Override//设置字体不随系统改变
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale != 1)//非默认值
            getResources();
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (res.getConfiguration().fontScale != 1) { //非默认值
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();  //设置默认
            res.updateConfiguration(newConfig, res.getDisplayMetrics());
        }
        return res;
    }

    /**
     * 通过时间戳获取年月日
     * @param time
     * @return
     */
    public static String getTime(long time){
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd");
        String d = format.format(time);
        try {
            Date date=format.parse(d);
//            Log.e("msg", "onBindViewHolder: "+d );
//            Log.e("msg", "onBindViewHolder: "+date );
            return d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getNowTime(long time){
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String d = format.format(time);
        try {
            Date date=format.parse(d);
            return d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /** 改变键盘输入法的状态，如果已经弹出就关闭，如果关闭了就强制弹出 */
    public static void chageInputState(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /** 强制关闭软键盘 */
    public static void closeKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     *  去重吐司
     * @param context 上下文
     * @param text 显示信息
     */
    static Toast mToast;
    public static void showtoast(Context context, String text){
        if (mToast==null){
            mToast = Toast.makeText(context,text,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * 带参跳转
     * @param aClass 目标activity
     * @param bundle bundle

     */
    public void intent(Class aClass,Bundle bundle){
        Intent intent = new Intent(this,aClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    /**
     * 跳转
     * @param aClass 目标activity
     */
    public void intent(Class aClass){
        Intent intent = new Intent(this,aClass);
        startActivity(intent);
    }

    /**
     *  判断网络
     * @param context
     * @return
     */
    public static boolean wangLuo(Context context){
        // 1.获取系统服务
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // 2.获取net信息
        NetworkInfo info = cm.getActiveNetworkInfo();
        // 3.判断网络是否可用
        if (info != null && info.isConnected()) {
            return true;
        } else {
            return false;
        }
    }

}
