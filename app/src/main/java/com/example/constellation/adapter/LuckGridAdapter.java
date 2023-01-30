package com.example.constellation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.constellation.R;
import com.example.constellation.bean.ConstellationBean;
import com.example.constellation.utils.AssetsUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @PackageName: com.example.constellation.adapter
 * @ClassName: LuckGridAdapter
 * @Author: winwa
 * @Date: 2023/1/29 17:57
 * @Description:
 **/
public class LuckGridAdapter extends BaseAdapter {
    private Context mContext;
    private List<ConstellationBean.StarinfoBean> mData;

    public LuckGridAdapter(Context context, List<ConstellationBean.StarinfoBean> data) {
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
            view = LayoutInflater.from(mContext).inflate(R.layout.gvitem_luck, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.mLogoIV.setImageBitmap(AssetsUtils.getCartoonLogoBitmapFromMap(mData.get(i).getLogoname()));
        holder.mNameTV.setText(mData.get(i).getName());

        return view;
    }

    class ViewHolder {
        CircleImageView mLogoIV;
        TextView mNameTV;

        public ViewHolder(View view) {
            mLogoIV = view.findViewById(R.id.gvitem_luck_logo_iv);
            mNameTV = view.findViewById(R.id.gvitem_luck_name_tv);
        }
    }
}
