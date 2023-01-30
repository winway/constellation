package com.example.constellation.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.constellation.R;
import com.example.constellation.bean.LuckAnalysisItemBean;

import java.util.List;

/**
 * @PackageName: com.example.constellation.adapter
 * @ClassName: LuckAnalysisListAdapter
 * @Author: winwa
 * @Date: 2023/1/29 18:40
 * @Description:
 **/
public class LuckAnalysisListAdapter extends BaseAdapter {
    private Context mContext;
    private List<LuckAnalysisItemBean> mData;

    public LuckAnalysisListAdapter(Context context, List<LuckAnalysisItemBean> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.lvitem_luck_analysis, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        GradientDrawable drawable = (GradientDrawable) holder.mTitleTV.getBackground();
        drawable.setColor(mData.get(i).getColorId());
        holder.mTitleTV.setText(mData.get(i).getTitle());
        holder.mContentTV.setText(mData.get(i).getContent());

        return view;
    }

    class ViewHolder {
        TextView mTitleTV;
        TextView mContentTV;

        public ViewHolder(View view) {
            mTitleTV = view.findViewById(R.id.lvitem_luck_analysis_title_tv);
            mContentTV = view.findViewById(R.id.lvitem_luck_analysis_content_tv);
        }
    }
}
