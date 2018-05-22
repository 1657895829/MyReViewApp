package com.example.demo12;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.example.demo12.adapter.MyPagerAdapter;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 只有第一次启动APP出现导航页
   实现导航页的滑动
   滑动到最后一页,显示跳转的按钮
   点击跳转的按钮,跳转到主页
 */
public class DaoActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.linear)
    LinearLayout linear;
    @BindView(R.id.btn_jump)
    Button btn_Jump;
    private List<Integer> list;
    private List<ImageView> imageViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao);
        ButterKnife.bind(this);

        //添加图片的集合
        list = new ArrayList<Integer>();
        list.add(R.drawable.a);
        list.add(R.drawable.b);
        list.add(R.drawable.c);
        list.add(R.drawable.d);
        list.add(R.drawable.e);
        list.add(R.drawable.f);
        
        //初始化小圆点的方法
        initCircle();

        //设置页面图片适配器
        MyPagerAdapter adapter = new MyPagerAdapter(list,DaoActivity.this);
        viewPager.setAdapter(adapter);

        //设置viewpager的监听
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //小圆点与viewPager联动
                for (int i = 0; i < list.size(); i++) {
                    if (i == position) {//当前位置的小圆点应该是红色的
                        imageViewList.get(i).setImageResource(R.drawable.shape_select);
                    }else {
                        imageViewList.get(i).setImageResource(R.drawable.shape_normal);

                    }
                }

                //button的显示与隐藏
                if (position == list.size()-1) {
                    btn_Jump.setVisibility(View.VISIBLE);
                }else {

                    btn_Jump.setVisibility(View.GONE);
                }

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    /**
     * 初始化小圆点的方法
     * 1.imageView...添加到layout
     * 2.创建一个集合记录这些小圆点的图片
     */
    private void initCircle() {
        imageViewList = new ArrayList<ImageView>();

        //for循环创建小圆点,,,加到布局,,,加到集合.....在循环之前先清空一下集合和布局
        linear.removeAllViews();
        imageViewList.clear();

        for (int i = 0; i<list.size();i++){
            ImageView imageView = new ImageView(DaoActivity.this);

            //显示第一张图
            if (i == 0){
                //选中...红色
                imageView.setImageResource(R.drawable.shape_select);
            }else {
                imageView.setImageResource(R.drawable.shape_normal);
            }

            //添加...LayoutParams布局的参数...linearLayout下面的LayoutParams
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            //圆点之间的间距
            params.setMargins(5, 0, 5, 0);
            //添加到布局
            linear.addView(imageView, params );
            //添加到集合
            imageViewList.add(imageView);
        }
    }

    @OnClick({R.id.btn_jump})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;

                //点击跳转至主页
            case R.id.btn_jump:
                Intent intent = new Intent(DaoActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
