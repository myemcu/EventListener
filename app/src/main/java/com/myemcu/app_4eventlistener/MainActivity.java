package com.myemcu.app_4eventlistener;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt;
    private int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取文本对象
        txt = (TextView) findViewById(R.id.txt);

        //-内部类(颜色)------------------------------------------------------------------------------

        // 获取Button对象
        Button red =    (Button)   findViewById(R.id.red);
        Button green =  (Button)   findViewById(R.id.green);
        Button blue  =  (Button)   findViewById(R.id.blue);

        // 创建监听器对象(颜色监听器)
        ColorListener myColorListener = new ColorListener();    // (Alt+Enter->Create inner class)

        // 注册监听器对象(接口通过内部类实现)
        red.setOnClickListener(myColorListener);                // (Alt+Enter->implements)
        green.setOnClickListener(myColorListener);
        blue.setOnClickListener(myColorListener);

        //-外部类(大小)------------------------------------------------------------------------------

        // 获取对象
        Button bigger =  (Button) findViewById(R.id.bigger);
        Button smaller = (Button) findViewById(R.id.smaller);

        // 创建监听器(尺寸监听器)(接口通过外部类实现)(外部类需要传入参数)
        SizeListener mySizeListener = new SizeListener(txt);   // (Alt+Enter->Create class)(即:外部类)

        // 注册监听器
        bigger.setOnClickListener(mySizeListener);          // // (Alt+Enter->implements)
        smaller.setOnClickListener(mySizeListener);

        //-类自身------------------------------------------------------------------------------------

        //txt.setTypeface(Typeface.DEFAULT);  // 设置字体样式

        // 获取对象
        Button bold   =   (Button)  findViewById(R.id.bold);
        Button italic =   (Button)  findViewById(R.id.italic);
        Button normal =   (Button)  findViewById(R.id.normal);

        // 注册监听器(接口通过主类实现)
        bold.setOnClickListener(this);  // Alt+Enter->implements
        italic.setOnClickListener(this);
        normal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {   // Alt+Enter->implements自动生成
        //Typeface tf = txt.getTypeface();    // 获取当前字体样式
        switch (v.getId()) {

            case R.id.bold:
                if (flag==2 || flag==3) {
                    txt.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
                    flag=3;
                }
                else {
                    txt.setTypeface(Typeface.MONOSPACE,Typeface.BOLD);
                    flag=1;
                }
                break;

            case R.id.italic:
                if (flag==1 || flag==3) {
                    txt.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
                    flag=3;
                }
                else {
                    txt.setTypeface(Typeface.MONOSPACE,Typeface.ITALIC);
                    flag=2;
                }
                break;

            case R.id.normal:
                txt.setTypeface(Typeface.MONOSPACE,Typeface.NORMAL);
                flag=0;
                break;

            default:break;
        }
    }

    // 内部类实现View.OnClickListener接口
    private class ColorListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.red:  txt.setTextColor(Color.RED); break;
                case R.id.green:txt.setTextColor(Color.GREEN);break;
                case R.id.blue: txt.setTextColor(Color.BLUE); break;
                default:break;
            }
        }
    }

}
