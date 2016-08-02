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

        // 获取Button对象
        Button red =    (Button)   findViewById(R.id.red);
        Button green =  (Button)   findViewById(R.id.green);
        Button blue  =  (Button)   findViewById(R.id.blue);

        // 创建监听器对象
        ColorListener myColorListener = new ColorListener();    // (Alt+Enter->Create inner class)

        // 注册监听器对象
        red.setOnClickListener(myColorListener);                // (Alt+Enter->implements)
        green.setOnClickListener(myColorListener);
        blue.setOnClickListener(myColorListener);
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
