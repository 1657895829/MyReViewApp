package com.example.customtitleview;

import android.os.Bundle;
/**
 * MainActivity中调用时直接 extends TitleActivity，使用在TitleActivity中定义的方法
 */
public class MainActivity extends TitleActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("标题栏");
        showBackwardView(R.string.text_back,true);
        showForwardView(R.string.text_forward,true);
    }
}

