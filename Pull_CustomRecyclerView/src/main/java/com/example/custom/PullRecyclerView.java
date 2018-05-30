package com.example.custom;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;

/**
 * 自定义RecyclerView，添加Header
 */
public class PullRecyclerView extends RecyclerView {

    public static final String TAG = PullRecyclerView.class.getSimpleName();

    private FrameLayout mHeaderContainer;

    private int mHeaderHeight;
    private int mScreenWidth;
    private int duration = 1000;
    ValueAnimator valueAnimator;

    private float mLastMotionY = -1.0F;

    public PullRecyclerView(Context context) {
        super(context);
        init();
    }

    public PullRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PullRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    public void setHeaderContainer(FrameLayout headerContainer) {
        mHeaderContainer = headerContainer;
    }

    private void init() {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay()
                .getMetrics(localDisplayMetrics);
        //获取屏幕宽
        mScreenWidth = localDisplayMetrics.widthPixels;
        //固定的header高度
        mHeaderHeight = (int) (9.0F * (mScreenWidth / 16.0F));

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public boolean onTouchEvent(MotionEvent e){
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    valueAnimator.cancel();
                }
                //记录触点Y轴坐标
                mLastMotionY = e.getY();
                Log.e(TAG, "down-->y=" + mLastMotionY);
                break;
            case MotionEvent.ACTION_MOVE:
                //计算deltY
                float Y = e.getY();
                float deltY = Y - mLastMotionY;

                int top  = mHeaderContainer.getTop();
                int height = mHeaderContainer.getHeight();
                int bottom = mHeaderContainer.getBottom();

                Log.e(TAG, "h=" + mHeaderHeight + ", top=" + top + ", height=" + height + ", deltY=" + deltY);

                LayoutManager manager = getLayoutManager();
                LinearLayoutManager linearLayoutManager = null;
                if (manager != null && manager instanceof LinearLayoutManager) {
                    linearLayoutManager = (LinearLayoutManager) manager;
                } else {
                    try {
                        throw new LayoutExcaption();
                    } catch (LayoutExcaption layoutExcaption) {
                        layoutExcaption.printStackTrace();
                    }
                }

                linearLayoutManager.findFirstVisibleItemPosition();
                int firstPos = linearLayoutManager.findFirstVisibleItemPosition();


                //当前
                if (top == 0 && (height > mHeaderHeight || (height == mHeaderHeight && deltY > 0 &&  firstPos == 0) )) {
                    ViewGroup.LayoutParams layoutParams = mHeaderContainer.getLayoutParams();
                    layoutParams.height += deltY;
                    //防止下次收到move事件，getBottom() < mHeaderHeight,导致无法下拉
                    if (layoutParams.height < mHeaderHeight) {
                        layoutParams.height = mHeaderHeight;
                    }

                    mHeaderContainer.setLayoutParams(layoutParams);
                    //更新y值
                    mLastMotionY = Y;
                    //直接返回true，防止RecyclerView对它进行处理，导致整体上滑
                    return true;
                }


                mLastMotionY = Y;
                return super.onTouchEvent(e);

            case MotionEvent.ACTION_UP:
                mLastMotionY = -1;
                //自动收起
                endScaling();
                break;

            default:
                break;
        }
        return super.onTouchEvent(e);
    }



    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void endScaling() {
        valueAnimator = ValueAnimator.ofInt(mHeaderContainer.getHeight(), mHeaderHeight);
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curHeight = (Integer) animation.getAnimatedValue();
                mHeaderContainer.getLayoutParams().height = curHeight;
                mHeaderContainer.requestLayout();
            }
        });
        valueAnimator.setDuration(duration);
        valueAnimator.start();
    }

}

class LayoutExcaption extends Exception {
    @Override
    public String getMessage() {
            return "必须使用LinearLayoutManager或GridLayoutManager";
    }
}