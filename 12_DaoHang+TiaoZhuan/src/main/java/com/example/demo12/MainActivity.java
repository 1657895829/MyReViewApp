package com.example.demo12;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.demo12.util.SharedUtils;
import java.util.Timer;
import java.util.TimerTask;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  实现启动页倒计时并显示
    启动页要是第一次APP进入,跳转到导航页
    要是第二次进入跳转到主页
    点击 跳过 应该是 跳到主页
 */
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.jump)
    TextView jump;
    private Timer timer  = new Timer();
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    break;

                default:
                        break;
            }
        };
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //调用工具类判断保存的布尔数据值
        boolean flag = SharedUtils.getBooleanData(MainActivity.this, "flag", false);

        //已经进入过，现在是第二次，就直接进入到主页面
        if (flag){
            handler.sendEmptyMessageDelayed(0,0);
        }else {
            //现在是第一次，倒计时进入导航页面
            SharedUtils.savaBooleanData(MainActivity.this,"flag",true);
            TimeAppIntent();
        }
    }


    //首先声明时间初始值：4秒
    int timeInit = 4;

    //设置定时器任务，更新时间,4秒后跳转页面
    private void TimeAppIntent() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //发送消息，更新时间
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // 为TextView控件赋值
                        time.setText("倒计时："+timeInit+" 秒");
                        timeInit--;

                        //当时间为0秒时，跳转至导航页
                        if (timeInit == 0){
                            Intent intent = new Intent(MainActivity.this, DaoActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });

            }
        },1000,1000);
    }

    @OnClick(R.id.jump)
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;

            //文字的点击触发事件
            case R.id.jump:
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

                //点击文字时取消倒计时
                timer.cancel();
                break;
        }
    }
}
