package com.example.unit09.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.unit09.R;
import com.example.unit09.bean.NewsBean;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * //XRecyclerView多条目展示数据适配器
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<NewsBean.NewslistBean> list;

    public MyAdapter(Context context) {
        this.context = context;
    }

    //声明数据来源，添加数据
    public void addData(NewsBean bean) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(bean.getNewslist());
        notifyDataSetChanged();
    }

    //创建条目布局
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0){
            View view01 = LayoutInflater.from(context).inflate(R.layout.adapter01, parent, false);
            return new MyViewHolder01(view01);
        }else {
            View view02 = LayoutInflater.from(context).inflate(R.layout.adapter02, parent, false);
            return new MyViewHolder02(view02);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //判断加载布局的类型
        if (holder instanceof MyViewHolder01){
            MyViewHolder01 holder01 = (MyViewHolder01) holder;
            holder01.draweeView.setImageURI(list.get(position).getPicUrl());
            holder01.title.setText(list.get(position).getTitle());
        }else if (holder instanceof MyViewHolder02) {
            MyViewHolder02 holder02 = (MyViewHolder02) holder;
            holder02.draweeView.setImageURI(list.get(position).getPicUrl());
            holder02.title.setText(list.get(position).getTitle());
        }
    }

    @Override
    public int getItemViewType(int position) {
        //判断布局类型，加载不同数据
        if (position % 2 == 0){
            return 0;
        }else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0:list.size();
    }

    static class MyViewHolder01 extends RecyclerView.ViewHolder {
        @BindView(R.id.draweeView)
        SimpleDraweeView draweeView;
        @BindView(R.id.title)
        TextView title;
        public MyViewHolder01(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    static class MyViewHolder02 extends RecyclerView.ViewHolder {
        @BindView(R.id.draweeView)
        SimpleDraweeView draweeView;
        @BindView(R.id.title)
        TextView title;
        public MyViewHolder02(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
