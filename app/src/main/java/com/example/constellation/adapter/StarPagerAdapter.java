package com.example.constellation.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * @PackageName: com.example.constellation.adapter
 * @ClassName: StarPagerAdapter
 * @Author: winwa
 * @Date: 2023/1/26 17:58
 * @Description:
 **/
public class StarPagerAdapter extends PagerAdapter {
    private List<ImageView> mViewList;

    public StarPagerAdapter(List<ImageView> viewList) {
        mViewList = viewList;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = mViewList.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ImageView imageView = mViewList.get(position);
        container.removeView(imageView);
    }
}
