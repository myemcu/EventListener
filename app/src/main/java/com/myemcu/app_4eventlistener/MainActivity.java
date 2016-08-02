package com.myemcu.app_4eventlistener;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-内部类(颜色)------------------------------------------------------------------------------

        // 获取Button对象
        Button red =    (Button)   findViewById(R.id.red);
        Button green =  (Button)   findViewById(R.id.green);
        Button blue  =  (Button)   findViewById(R.id.blue);

        // 创建监听器对象(颜色监听器)
        ColorListener myColorListener = new ColorListener();    // (Alt+Enter->Create inner class)

        // 注册监听器对象
        red.setOnClickListener(myColorListener);                // (Alt+Enter->implements)
        green.setOnClickListener(myColorListener);
        blue.setOnClickListener(myColorListener);

        //-外部类(大小)------------------------------------------------------------------------------

        // 获取对象
        Button bigger =  (Button) findViewById(R.id.bigger);
        Button smaller = (Button) findViewById(R.id.smaller);

        TextView txt = (TextView) findViewById(R.id.txt);

        // 创建监听器(尺寸监听器)(外部类需要传入参数)
        SizeListener mySizeListener = new SizeListener(txt);   // (Alt+Enter->Create class)(即:外部类)

        // 注册监听器
        bigger.setOnClickListener(mySizeListener);          // // (Alt+Enter->implements)
        smaller.setOnClickListener(mySizeListener);
    }

    private class ColorListener implements View.OnClickListener {

        TextView txt = (TextView)  findViewById(R.id.txt); // txt对象的获取位置(哪里使用，哪里获取)

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
