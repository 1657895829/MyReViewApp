package com.example.app.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.app.R;
import com.example.app.SecondActivity;
import com.example.app.bean.EventBusBean;
import com.example.app.bean.WeiXinBean;
import com.facebook.drawee.view.SimpleDraweeView;
import org.greenrobot.eventbus.EventBus;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * 自定义适配器类
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<WeiXinBean.NewslistBean> list;

    public MyAdapter(Context context, List<WeiXinBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //在view视图中设置控件属性
        Uri uri = Uri.parse(list.get(position).getPicUrl());
        holder.draweeView.setImageURI(uri);
        holder.title.setText(list.get(position).getTitle());
        holder.time.setText(list.get(position).getCtime());

        //点击条目进行跳转
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //携带数据，实现点击跳转传值，发送粘性事件
                EventBus.getDefault().postSticky(new EventBusBean(list.get(position).getTitle()));
                context.startActivity(new Intent(context, SecondActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.draweeView)
        SimpleDraweeView draweeView;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.time)
        TextView time;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
