package com.example.wangguo20180514.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.wangguo20180514.R;
import com.example.wangguo20180514.bean.User;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2018/5/14.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private User user;

    public MyAdapter(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.iv1.setImageURI((String) user.getData().get(position).getUser().getIcon());
        holder.tv1.setText(user.getData().get(position).getUser().getNickname());
        holder.tv2.setText(user.getData().get(position).getCreateTime());
        holder.tv3.setText(user.getData().get(position).getContent());
        holder.iv2.setImageURI((String) user.getData().get(position).getImgUrls());
    }

    @Override
    public int getItemCount() {
        return user.getData() == null ? 0 : user.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv1)
        SimpleDraweeView iv1;
        @BindView(R.id.tv1)
        TextView tv1;
        @BindView(R.id.tv2)
        TextView tv2;
        @BindView(R.id.tv3)
        TextView tv3;
        @BindView(R.id.iv2)
        SimpleDraweeView iv2;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
