package com.example.newframe_09.ui.adapter;

import android.content.Context;
import com.example.newframe_09.R;
import com.example.newframe_09.bean.Bean;
import com.example.newframe_09.common.CommonAdapter;
import com.example.newframe_09.common.ViewHolder;
import java.util.List;

/**
 * 搜索框 适配器
 */

public class SearchAdapter extends CommonAdapter<Bean> {

    public SearchAdapter(Context context, List<Bean> data, int layoutId) {
        super(context, data, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, int position) {
        holder.setImageResource(R.id.item_search_iv_icon,mData.get(position).getIconId())
                .setText(R.id.item_search_tv_title,mData.get(position).getTitle())
                .setText(R.id.item_search_tv_content,mData.get(position).getContent())
                .setText(R.id.item_search_tv_comments,mData.get(position).getComments());
    }

}
