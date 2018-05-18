package shop.example.com.newframe.ui.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import shop.example.com.newframe.R;
import shop.example.com.newframe.bean.ShopBean;

/**
 * RecyclerView 展示数据
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewholder> {
    private Context context;
    private List<ShopBean.DataBean> list;

    public MyAdapter(Context context) {
        this.context = context;
    }

    //添加数据的方法
    public void addData(ShopBean bean){
        if (this.list == null){
            this.list = new ArrayList<>();
        }
        this.list.addAll(bean.getData());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter, null);
        MyViewholder holder = new MyViewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        //加载布局
        String[] split = list.get(position).getImages().split("\\|");
        holder.draweeView.setImageURI(split[0]);
        holder.title.setText(list.get(position).getTitle());

        //原价设置删除线
        holder.price.setText("原价："+list.get(position).getPrice());
        holder.price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中间横线（删除线）
        holder.price.getPaint().setAntiAlias(true);// 抗锯齿

        holder.bargainPrice.setText("优惠价："+list.get(position).getBargainPrice());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    static class MyViewholder extends RecyclerView.ViewHolder {
        @BindView(R.id.draweeView)
        SimpleDraweeView draweeView;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.price)
        TextView price;
        @BindView(R.id.bargainPrice)
        TextView bargainPrice;

        MyViewholder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
