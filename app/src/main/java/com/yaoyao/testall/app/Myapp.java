package com.yaoyao.testall.app;

import android.app.Application;
import android.content.Context;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/8.
 */

public class Myapp extends Application {
    private static Map<String, Object> hashMap = null;
    private static Object object = null;
    public static Context context;
    public static int CID = 0;
    public static String APPKEY = "1c369c73b3efc";
    public static String APPSECRET = "1eebb5f4806a89391ac56dfcd051830b";

    public static String USERID_KEY = "userid";
    public static String PASSWORD_KEY = "password";


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        setHashMap(new HashMap<String, Object>());

    }


    public static Map<String, Object> getHashMap()
    {
        return hashMap;
    }

    public static void setHashMap(Map<String, Object> map) {
        hashMap = map;
    }

    public static Context getAppContext() {
        return context;
    }

    public static Object getObject() {
        return object;
    }

    public static void setObject(Object object) {
        Myapp.object = object;
    }
}
