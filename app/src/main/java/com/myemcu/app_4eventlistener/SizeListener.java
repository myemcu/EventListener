package com.myemcu.app_4eventlistener;

import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/2.
 */
public class SizeListener implements View.OnClickListener {

    private TextView tv; // 定义外部类文本显示控件变量(该外部类需要操作Activity文本)

    public SizeListener (TextView tv) { // 构造器
        this.tv=tv;                     // 外部类.tv=传入TextView tv
    }

    @Override
    public void onClick(View v) {

        float f = tv.getTextSize(); // 获取当前字体大小

        switch (v.getId()) {
            case R.id.bigger:   f+=2; break;
            case R.id.smaller:  f-=2; break;
            default:break;
        }

        if (f>160) {f=160;}
        if (f<8) {f=8;}

        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX,f);
    }
}
