package com.example.constellation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.constellation.R;
import com.example.constellation.bean.StarAnalysisItemBean;

import java.util.List;

/**
 * @PackageName: com.example.constellation.adapter
 * @ClassName: StarAnalysisListAdapter
 * @Author: winwa
 * @Date: 2023/1/27 10:57
 * @Description:
 **/
public class StarAnalysisListAdapter extends BaseAdapter {
    private static final String TAG = "StarAnalysisListAdapter";

    private Context mContext;
    private List<StarAnalysisItemBean> mData;

    public StarAnalysisListAdapter(Context context, List<StarAnalysisItemBean> data) {
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
            view = LayoutInflater.from(mContext).inflate(R.layout.lvitem_star_analysis, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        StarAnalysisItemBean starAnalysisBean = mData.get(i);
        holder.mPropertyNameTV.setText(starAnalysisBean.getPropertyName());
        holder.mPropertyContentTV.setText(starAnalysisBean.getPropertyContent());
        holder.mPropertyContentTV.setBackgroundResource(starAnalysisBean.getPropertyColor());

        return view;
    }

    class ViewHolder {
        TextView mPropertyNameTV;
        TextView mPropertyContentTV;

        public ViewHolder(View view) {
            mPropertyNameTV = view.findViewById(R.id.lvitem_star_analysis_property_name_tv);
            mPropertyContentTV = view.findViewById(R.id.lvitem_star_analysis_property_content_tv);
        }
    }
}
