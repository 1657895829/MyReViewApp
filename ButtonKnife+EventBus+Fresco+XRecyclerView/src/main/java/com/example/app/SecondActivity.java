package com.example.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app.bean.EventBusBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        //初始化EventBus，注册EventBus，订阅粘性事件
        EventBus.getDefault().register(this);
    }

    //主线程UI，注册订阅粘性事件，处理粘性事件函数
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    //下面的写法达到粘性的目的
    public void receiveSticky(EventBusBean busBean){
        Toast.makeText(SecondActivity.this, "处理订阅粘性事件，接收数据", Toast.LENGTH_SHORT).show();
        text.setText(busBean.title);
    }

    //注销EventBus
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().removeAllStickyEvents();
    }
}
