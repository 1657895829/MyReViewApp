package app.example.unit07.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import app.example.unit07.R;
import app.example.unit07.bean.NewsBean;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * RecyclerView展示数据
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<NewsBean.NewslistBean> list;

    public MyAdapter(Context context) {
        this.context = context;
    }

    //声明数据来源，添加数据
    public void addData(NewsBean bean){
        if (this.list == null){
            this.list = new ArrayList<>();
        }
        this.list.addAll(bean.getNewslist());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //加载布局
        holder.draweeView.setImageURI(list.get(position).getPicUrl());
        holder.title.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0:list.size();
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.draweeView)
        SimpleDraweeView draweeView;
        @BindView(R.id.title)
        TextView title;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
