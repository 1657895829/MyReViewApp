package com.example.login13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.example.login13.ui.activity.LoginActivity;
import com.example.login13.ui.activity.PersonInfoActivity;
import com.example.login13.util.SharedUtils;

//页面进入页
public class MainActivity extends AppCompatActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Intent intent = new Intent(MainActivity.this, PersonInfoActivity.class);
                    startActivity(intent);
                    finish();
                    break;

                case 1:
                    Intent intent2 = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent2);
                    finish();
                    break;

                default:
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //调用工具类判断保存的布尔值
        boolean b = SharedUtils.getBooleanData(MainActivity.this, "flag", false);

        if (b) {    //已经进入过，现在是第二次
            handler.sendEmptyMessageDelayed(0, 0);
        } else {        //现在是第一次
            SharedUtils.savaBooleanData(MainActivity.this, "flag", true);
            handler.sendEmptyMessageDelayed(1, 0);
        }
    }
}
