package com.example.custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

//引用自定义RecyclerView 设置布局
public class MainActivity extends AppCompatActivity {
    PullRecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    GridLayoutManager gridLayoutManager;
    boolean isLinear = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (PullRecyclerView) findViewById(R.id.rv);

        //添加布局视图内容
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            datas.add("曾鹏翔");
            datas.add("冯阜营");
            datas.add("吴云峰");
            datas.add("黄梁梁");
            datas.add("李龙华");
            datas.add("李辉辉");
            datas.add("沈忱");
            datas.add("符东东");
            datas.add("陆超");
            datas.add("姚三宝");
            datas.add("解春龙");
            datas.add("刘邓");
            datas.add("沈铁");
            datas.add("陈磊");
            datas.add("杨翔");
            datas.add("冯翔");
            datas.add("王维");
        }

        //设置布局管理器以及数据适配器，分隔线
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(linearLayoutManager);

        MyAdapter adapter = new MyAdapter(datas, this);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));
        adapter.setImageResource(R.drawable.army);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_main) {
            if (isLinear) {
                recyclerView.setLayoutManager(gridLayoutManager);
                isLinear = false;
            } else {
                recyclerView.setLayoutManager(linearLayoutManager);
                isLinear = true;
            }
        }
        return true;
    }

}
