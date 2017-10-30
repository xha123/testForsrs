package com.yaoyao.testall.chanel;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

import java.util.ArrayList;

import fr.castorflex.android.verticalviewpager.VerticalViewPager;

/**
 * Created by Administrator on 2017/9/26.
 */

public class ChanActivity extends BaseActivity{
    VerticalViewPager viewPager;
    private ArrayList<View> listimage;
    @Override
    public void inidata() {
        listimage = new ArrayList<>();
    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_chan);
    }

    @Override
    public void iniview() {

        viewPager = (VerticalViewPager) findViewById(R.id.chan_viewpager);
    }

    @Override
    public void setview() {
        listimage = new ArrayList<>();
        final View view1 = LayoutInflater.from(this).inflate(R.layout.pager_view,null);
        ImageView image1 = (ImageView) view1.findViewById(R.id.pager_iv);
        image1.setImageResource(R.drawable.m1);
        listimage.add(view1);
        View view2 = LayoutInflater.from(this).inflate(R.layout.pager_view,null);
        ImageView image2 = (ImageView) view2.findViewById(R.id.pager_iv);
        image2.setImageResource(R.drawable.m2);
        listimage.add(view2);
        View view3 = LayoutInflater.from(this).inflate(R.layout.pager_view,null);
        ImageView image3 = (ImageView) view3.findViewById(R.id.pager_iv);
        image3.setImageResource(R.drawable.m3);
        listimage.add(view3);
        View view4 = LayoutInflater.from(this).inflate(R.layout.pager_view,null);
        ImageView image4 = (ImageView) view4.findViewById(R.id.pager_iv);
        image4.setImageResource(R.drawable.m4);
        listimage.add(view4);
        View view5 = LayoutInflater.from(this).inflate(R.layout.pager_view,null);
        ImageView image5 = (ImageView) view5.findViewById(R.id.pager_iv);
        image5.setImageResource(R.drawable.m5);
        listimage.add(view5);
        View view6 = LayoutInflater.from(this).inflate(R.layout.pager_view,null);
        ImageView image6 = (ImageView) view6.findViewById(R.id.pager_iv);
        image6.setImageResource(R.drawable.m6);
        listimage.add(view6);

        ChanPagerAdapter chanPagerAdapter = new ChanPagerAdapter(this);
        chanPagerAdapter.setList(listimage);
        viewPager.setAdapter(chanPagerAdapter);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setPageMargin(20);//设置viewpager间距

        viewPager.setCurrentItem(0);
    }
}
