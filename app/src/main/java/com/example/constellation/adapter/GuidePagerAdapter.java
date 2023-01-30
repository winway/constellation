package com.example.constellation.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * @PackageName: com.example.constellation.adapter
 * @ClassName: GuidePagerAdapter
 * @Author: winwa
 * @Date: 2023/1/30 8:20
 * @Description:
 **/
public class GuidePagerAdapter extends PagerAdapter {
    private List<ImageView> mData;

    public GuidePagerAdapter(List<ImageView> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = mData.get(position);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ImageView imageView = mData.get(position);
        container.removeView(imageView);
    }
}
