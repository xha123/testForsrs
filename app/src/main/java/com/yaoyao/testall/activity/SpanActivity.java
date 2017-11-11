package com.yaoyao.testall.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/11.
 */

public class SpanActivity extends BaseActivity{
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    @Override
    public void inidata() {

    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_span);
    }

    @Override
    public void iniview() {
       tv1 = (TextView) findViewById(R.id.span_tv1);
       tv2 = (TextView) findViewById(R.id.span_tv2);
       tv3 = (TextView) findViewById(R.id.span_tv3);
       tv4 = (TextView) findViewById(R.id.span_tv4);
       tv5 = (TextView) findViewById(R.id.span_tv5);
       tv6 = (TextView) findViewById(R.id.span_tv6);
       tv7 = (TextView) findViewById(R.id.span_tv7);
    }

    @Override
    public void setview() {


        tv1.setText("我还清晰的记得刚开始做项目那会，\n" +
                "    做出这样的效果图需要2个TextView，9月一个；22日一个，", TextView.BufferType.SPANNABLE);
        getEachParagraph(tv1);
        tv1.setMovementMethod(LinkMovementMethod.getInstance());

        SpannableString spannableString = new SpannableString("背景色BackgroundColorSpan");
        BackgroundColorSpan colorSpan = new BackgroundColorSpan(Color.parseColor("#AC00FF30"));
        spannableString.setSpan(colorSpan, 3, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv2.setText(spannableString);

        SpannableString spannableString3 = new SpannableString("9月22日");
        RelativeSizeSpan sizeSpan = new RelativeSizeSpan(2.0f);
        spannableString3.setSpan(sizeSpan, 0, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv3.setText(spannableString3);

        SpannableString spannableString4 = new SpannableString("为文字设置粗体,斜体风格");
        StyleSpan styleSpan_B = new StyleSpan(Typeface.BOLD);
        StyleSpan styleSpan_I = new StyleSpan(Typeface.ITALIC);
        spannableString4.setSpan(styleSpan_B, 5, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString4.setSpan(styleSpan_I, 8, 10, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv4.setText(spannableString4);

        SpannableString spannableString5 = new SpannableString("在文本中添加xx");
        Drawable drawable = getResources().getDrawable(R.drawable.m1);
        int drawHeight = drawable.getMinimumHeight();
        drawable.setBounds(0, 0, drawHeight, drawHeight);
        ImageSpan imageSpan = new ImageSpan(drawable);
        spannableString5.setSpan(imageSpan, 6, 8, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv5.setText(spannableString5);


    }


    public void getEachParagraph(TextView textView) {
        Spannable spans = (Spannable) textView.getText();
        Integer[] indices = getIndices(
                textView.getText().toString().trim(), ',');
        int start = 0;
        int end = 0;
        // recycle
        for (int i = 0; i <= indices.length; i++) {
            ClickableSpan clickSpan = getClickableSpan();
            //setspan
            end = (i < indices.length ? indices[i] : spans.length());
            spans.setSpan(clickSpan, start, end,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            start = end + 1;
        }
        //改变选中文本的高亮颜色
        textView.setHighlightColor(Color.BLUE);
    }

    //click
    private ClickableSpan getClickableSpan() {
        return new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                TextView tv = (TextView) widget;
                String s = tv
                        .getText()
                        .subSequence(tv.getSelectionStart(),
                                tv.getSelectionEnd()).toString();
                Log.e("onclick--:", s);
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(Color.BLACK);
                ds.setUnderlineText(false);
            }
        };
    }

    //array
    public static Integer[] getIndices(String s, char c) {
        int pos = s.indexOf(c, 0);
        List<Integer> indices = new ArrayList<Integer>();
        while (pos != -1) {
            indices.add(pos);
            pos = s.indexOf(c, pos + 1);
        }
        return (Integer[]) indices.toArray(new Integer[0]);
    }
}
