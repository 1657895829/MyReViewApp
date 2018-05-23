package com.example.wangguo20180514;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.wangguo20180514.fragment.Foure;
import com.example.wangguo20180514.fragment.One;
import com.example.wangguo20180514.fragment.Teo;
import com.example.wangguo20180514.fragment.Three;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fl)
    FrameLayout fl;
    private ArrayList<Fragment> fragments;
    @BindView(R.id.rbHome)
    RadioButton rbHome;
    @BindView(R.id.rbShop)
    RadioButton rbShop;
    @BindView(R.id.rbMessage)
    RadioButton rbMessage;
    @BindView(R.id.rbMine)
    RadioButton rbMine;
    @BindView(R.id.rgTools)
    RadioGroup rgTools;
    @BindView(R.id.ll)
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragments = new ArrayList<>();
        addFragment();
        //设置默认被选中的RadioButton
        rgTools.check(R.id.rbHome);
        switchFragment(0);
        rgTools.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                        case R.id.rbHome:
                            switchFragment(0);
                            break;
                        case R.id.rbShop:
                            switchFragment(1);
                            break;
                            case R.id.rbMessage:
                                switchFragment(2);
                                break;
                                case R.id.rbMine:
                                    switchFragment(3);
                                    break;

            }}
        });
    }
    /**
     * 创建fragment实例并把他们加入集合
     */

    public void addFragment() {
        fragments.add(new One());
        fragments.add(new Teo());
        fragments.add(new Three());
        fragments.add(new Foure());
    }

    /**
     * 点击切换fragment
     *
     * @param position
     */
    public void switchFragment(int position) {
        //开启事务
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        //遍历集合
        for (int i = 0; i <fragments.size() ; i++) {
            Fragment fragment = fragments.get(i);
            if (i==position){
                //显示fragment
                if (fragment.isAdded()){
                    //如果这个fragment已经被事务添加,显示
                    fragmentTransaction.show(fragment);
                }else{
                    //如果这个fragment没有被事务添加过,添加
                    fragmentTransaction.add(R.id.fl,fragment);
                }
            }else{
                //隐藏fragment
                if (fragment.isAdded()){
                    //如果这个fragment已经被事务添加,隐藏
                    fragmentTransaction.hide(fragment);
                }
            }
        }
        //提交事务
        fragmentTransaction.commit();
    }
}
