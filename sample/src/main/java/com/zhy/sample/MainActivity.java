package com.zhy.sample;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.zhy.autolayout.AutoLayout;
import com.zhy.autolayout.AutoLayoutActivity;


public class MainActivity extends AutoLayoutActivity
{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoLayout.getInstance().auto(this);
        textView = (TextView) findViewById(R.id.spannable_text);
        SpannableString msp = new SpannableString("字体测试字体大小一半两倍前景色背景色正常粗体斜体粗斜体下划线删除线x1x2电话邮件网站短信彩信地图X轴综合/bot");

        //设置字体(default,default-bold,monospace,serif,sans-serif)
        msp.setSpan(new TypefaceSpan("monospace"), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp.setSpan(new TypefaceSpan("serif"), 2, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体大小(绝对值,单位：像素)
        msp.setSpan(new AbsoluteSizeSpan(20), 4, 6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置相对字体，参数表示默认字体大小的多少倍
        msp.setSpan(new RelativeSizeSpan(0.5f),8,10,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp.setSpan(new RelativeSizeSpan(2.0f),10,12,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体前景色
        msp.setSpan(new ForegroundColorSpan(Color.RED),12,15,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体背景色
        msp.setSpan(new BackgroundColorSpan(Color.CYAN),15,18,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体样式正常，粗体，斜体，粗斜体
        msp.setSpan(new StyleSpan(Typeface.NORMAL),18,20,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp.setSpan(new StyleSpan(Typeface.BOLD),20,22,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp.setSpan(new StyleSpan(Typeface.ITALIC),22,24,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp.setSpan(new StyleSpan(Typeface.ITALIC),24,27,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置下划线
        msp.setSpan(new UnderlineSpan(),27,30,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp.setSpan(new StrikethroughSpan(),30,33,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置上下标
        msp.setSpan(new SubscriptSpan(), 34, 35, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //下标
        msp.setSpan(new SuperscriptSpan(), 36, 37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //上标
        //超级链接(需要添加setMovementMethod方法附加响应)
        msp.setSpan(new URLSpan("tel:110"),37,39,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp.setSpan(new URLSpan("mailto:webmaster@google.com"),39,41,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp.setSpan(new URLSpan("http://www.baidu.com"),41,43,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp.setSpan(new URLSpan("sms:4155551212"), 43, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //短信 使用sms:或者smsto:

        msp.setSpan(new URLSpan("mms:4155551212"), 45, 47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //彩信 使用mms:或者mmsto:

        msp.setSpan(new URLSpan("geo:38.899533,-77.036476"), 47, 49, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); //地图

        Drawable drawable = getResources().getDrawable(R.mipmap.add);

        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());

        msp.setSpan(new ImageSpan(drawable), 53, 57, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(msp);

        textView.setMovementMethod(LinkMovementMethod.getInstance());


    }


}
