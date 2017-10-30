package com.yaoyao.testall.chanel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/26.
 */

public class ChanPagerAdapter  extends PagerAdapter {
    List<View> list;
    Context context;

    public ChanPagerAdapter(Context context) {
        this.context = context;
        list=new ArrayList<View>();
    }

    public List<View> getList() {
        return list;
    }

    public void setList(List<View> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }


    //判断有没有显示错
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    //创建以及布局
    @Override
    public Object instantiateItem(ViewGroup parent, int position) {
        View view=list.get(position);//获得要显示的布局
        parent.addView(view);//把布局加到Viewpager的控件组里面
//        Log.i("msg",position+"加载");
        return view;//显示要显示的布局
    }


    //销毁方法
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view=list.get(position);//获得要被销毁的view
        container.removeView(view);//执行从父控件组中的移除
//        Log.i("msg",position+"销毁");
    }
}
