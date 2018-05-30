package com.example.custom;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * RecyclerView 子条目布局适配器
 */
public class MyAdapter extends HeaderViewAdapter<ItemViewHolder, String> {
    Context mContext;

    public MyAdapter(List i, Context context) {
        super(i, context);
        mContext = context;
    }

    @Override
    protected void onBindItemViewHolder(ItemViewHolder holder, int position) {
        holder.textView.setText(getItem(position));
        holder.image.setImageResource(R.drawable.three_start);
    }

    @Override
    protected ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }
}

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView image;

        public ItemViewHolder(View itemView) {
            super(itemView);
            image = (ImageView)itemView.findViewById(R.id.image);
            textView = (TextView) itemView.findViewById(R.id.text);
    }

}
