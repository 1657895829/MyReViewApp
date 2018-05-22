package com.example.demo12.adapter;

import java.util.List;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

//导航页面的图片展示页
public class MyPagerAdapter extends PagerAdapter{
	List<Integer> list;
	Context context;
	
	public MyPagerAdapter(List<Integer> list, Context context) {
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		//两件事
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(list.get(position));
		//设置
		imageView.setScaleType(ScaleType.FIT_XY);
		
		//添加
		container.addView(imageView);
		return imageView;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		//移除
		container.removeView((View) object);
	}

}
