package com.example.constellation;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.constellation.adapter.StarGridAdapter;
import com.example.constellation.adapter.StarPagerAdapter;
import com.example.constellation.bean.ConstellationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StarFragment extends Fragment {

    private static final String TAG = "StarFragment";

    private static final String ARG_CONSTELLATION_INFO = "constellation_info";
    private static final int MSG_BANNER_AUTO_PLAY = 0;

    private ViewPager mVP;
    private LinearLayout mLL;
    private GridView mGV;

    private int[] mBannerImageList = {R.mipmap.pic_guanggao, R.mipmap.pic_star};
    private List<ImageView> mBannerImageViewList;
    private List<ImageView> mBannerIndicatorList;
    private StarPagerAdapter mPagerAdapter;

    private ConstellationBean mConstellationBean;
    private List<ConstellationBean.StarinfoBean> mData;
    private StarGridAdapter mGridAdapter;

    public StarFragment() {
        // Required empty public constructor
    }

    public static StarFragment newInstance(ConstellationBean constellationBean) {
        StarFragment fragment = new StarFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CONSTELLATION_INFO, constellationBean);
        fragment.setArguments(args);
        return fragment;
    }    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if (msg.what == MSG_BANNER_AUTO_PLAY) {
                int currentPos = mVP.getCurrentItem();
                if (currentPos == mBannerImageViewList.size() - 1) {
                    currentPos = 0;
                } else {
                    currentPos += 1;
                }
                mVP.setCurrentItem(currentPos);

                mHandler.sendEmptyMessageDelayed(MSG_BANNER_AUTO_PLAY, 5000);
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mConstellationBean = (ConstellationBean) getArguments().getSerializable(ARG_CONSTELLATION_INFO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_star, container, false);

        mVP = view.findViewById(R.id.star_vp);
        mLL = view.findViewById(R.id.star_indicator_ll);
        mGV = view.findViewById(R.id.star_gv);

        mVP.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mBannerIndicatorList.size(); i++) {
                    mBannerIndicatorList.get(i).setImageResource(R.mipmap.point_normal);
                }
                mBannerIndicatorList.get(position).setImageResource(R.mipmap.point_focus);
            }
        });

        initBanner();

        mData = mConstellationBean.getStarinfo();
        mGridAdapter = new StarGridAdapter(getContext(), mData);
        mGV.setAdapter(mGridAdapter);

        mGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ConstellationBean.StarinfoBean starinfoBean = mData.get(i);
                StarAnalysisActivity.newIntent(getActivity(), starinfoBean);
            }
        });

        mHandler.sendEmptyMessageDelayed(MSG_BANNER_AUTO_PLAY, 5000);

        return view;
    }

    private void initBanner() {
        mBannerImageViewList = new ArrayList<>();
        mBannerIndicatorList = new ArrayList<>();

        mLL.removeAllViews();

        for (int i = 0; i < mBannerImageList.length; i++) {
            ImageView picIV = new ImageView(getContext());
            picIV.setImageResource(mBannerImageList[i]);
            picIV.setScaleType(ImageView.ScaleType.FIT_XY);
            picIV.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            mBannerImageViewList.add(picIV);

            ImageView indicatorIV = new ImageView(getContext());
            indicatorIV.setImageResource(R.mipmap.point_normal);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(20, 0, 0, 0);
            indicatorIV.setLayoutParams(layoutParams);
            mBannerIndicatorList.add(indicatorIV);
            mLL.addView(indicatorIV);
        }

        mBannerIndicatorList.get(0).setImageResource(R.mipmap.point_focus);

        mPagerAdapter = new StarPagerAdapter(mBannerImageViewList);
        mVP.setAdapter(mPagerAdapter);
    }




}