package com.example.custom;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.Collections;
import java.util.List;

/**
 * RecyclerView 整体布局适配器
 */
public abstract class HeaderViewAdapter<VH extends RecyclerView.ViewHolder, I> extends RecyclerView.Adapter<VH> {
    private static final String TAG = "PullToZoomListView";

    protected static final int TYPE_HEADER = -2;
    protected static final int TYPE_ITEM = -1;
    public static final int DEFAULT_RESOURCE = -1;

    private List<I> item = Collections.EMPTY_LIST;
    private Context mContext;

    private FrameLayout mHeaderContainer;
    private ImageView mHeaderImage;
    private PullRecyclerView mRecyclerView;
    private int mResourceId = DEFAULT_RESOURCE;

    public HeaderViewAdapter(List<I> i, Context context) {
        item = i;
        mContext = context;
    }

    @Override
    public final VH onCreateViewHolder(ViewGroup parent, int viewType) {
        VH viewHolder;
        if (viewType == TYPE_HEADER) {
            //生成头部布局
            mHeaderContainer = generaterHeaderContainer();
            mRecyclerView.setHeaderContainer(mHeaderContainer);
            viewHolder = (VH) new HeaderHolder(mHeaderContainer);
        } else {
            viewHolder = onCreateItemViewHolder(parent, viewType);
        }
        return viewHolder;
    }

    @Override
    public final void onBindViewHolder(VH holder, int position) {
        int type = getItemViewType(position);
        if (type == TYPE_HEADER) {
            //TODO
        } else {
            onBindItemViewHolder(holder, position);
        }
    }

    //子类复写
    protected abstract void onBindItemViewHolder(VH holder, int position);


    //子类复写
    protected abstract VH onCreateItemViewHolder(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        return item.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_ITEM;
        }
    }

    public I getItem(int position) {
        return item.get(position - 1);
    }

    /**
     * 生成头部布局
     */
    private FrameLayout generaterHeaderContainer() {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay()
                .getMetrics(localDisplayMetrics);
        //获取屏幕的高
        int screenHeight = localDisplayMetrics.heightPixels;
        //获取屏幕宽
        int screenWidth = localDisplayMetrics.widthPixels;
        int headerHeight = (int) (9.0F * (screenWidth / 16.0F));

        //创建一个FrameLayout
        mHeaderContainer = new FrameLayout(mContext);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(screenWidth, headerHeight);
        mHeaderContainer.setLayoutParams(layoutParams);
        //创建一个ImageView
        mHeaderImage = new ImageView(mContext);
        //TODO 由外部设置
        if (mResourceId != -1) {
            mHeaderImage.setImageResource(mResourceId);
        }

        //设置缩放类型
        mHeaderImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //为ImageView设置布局参数
        FrameLayout.LayoutParams imageLayoutParams = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mHeaderImage.setLayoutParams(imageLayoutParams);

        //将ImageView加入FrameLayout中
        mHeaderContainer.addView(this.mHeaderImage);

        return mHeaderContainer;
    }

    public void setImageResource(int resourceId) {
        mResourceId = resourceId;
    }

    public void setData(List<I> data) {
        item = data;
        notifyDataSetChanged();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = (PullRecyclerView) recyclerView;

        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridManager = ((GridLayoutManager) manager);
            gridManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position) == TYPE_HEADER
                            ? gridManager.getSpanCount() : 1;
                }
            });

        }
    }

}

class HeaderHolder extends RecyclerView.ViewHolder {
    FrameLayout root;

    public HeaderHolder(View itemView) {
        super(itemView);
        root = (FrameLayout) itemView;
    }
}