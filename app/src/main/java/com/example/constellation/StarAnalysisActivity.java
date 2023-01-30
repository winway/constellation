package com.example.constellation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.constellation.adapter.StarAnalysisListAdapter;
import com.example.constellation.bean.ConstellationBean;
import com.example.constellation.bean.StarAnalysisItemBean;
import com.example.constellation.utils.AssetsUtils;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StarAnalysisActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String ARG_STAR_INFO = "star";

    private ImageView mBackIV;
    private TextView mTitleTV;
    private CircleImageView mLogoIV;
    private TextView mNameTV;
    private TextView mDateTV;
    private ListView mLV;
    private TextView mAnalysisContentTV;

    private ConstellationBean.StarinfoBean mStarinfoBean;
    private List<StarAnalysisItemBean> mAdapterData;
    private StarAnalysisListAdapter mListAdapter;

    public static void newIntent(Context context, ConstellationBean.StarinfoBean starinfoBean) {
        Intent intent = new Intent(context, StarAnalysisActivity.class);
        intent.putExtra(ARG_STAR_INFO, starinfoBean);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_analysis);

        Intent intent = getIntent();
        mStarinfoBean = (ConstellationBean.StarinfoBean) intent.getSerializableExtra(ARG_STAR_INFO);

        initView();

        mAdapterData = new ArrayList<>();
        mListAdapter = new StarAnalysisListAdapter(this, mAdapterData);
        mLV.setAdapter(mListAdapter);

        setAdapterData();
    }

    private void setAdapterData() {
        mAdapterData.clear();

        mAdapterData.add(new StarAnalysisItemBean("性格特点：", mStarinfoBean.getTd(), R.color.lightblue));
        mAdapterData.add(new StarAnalysisItemBean("掌管宫位：", mStarinfoBean.getGw(), R.color.lightpink));
        mAdapterData.add(new StarAnalysisItemBean("显阴阳性：", mStarinfoBean.getYy(), R.color.lightgreen));
        mAdapterData.add(new StarAnalysisItemBean("最大特征：", mStarinfoBean.getTz(), R.color.purple));
        mAdapterData.add(new StarAnalysisItemBean("主管星球：", mStarinfoBean.getZg(), R.color.orange));
        mAdapterData.add(new StarAnalysisItemBean("幸运颜色：", mStarinfoBean.getYs(), R.color.darkgreen));
        mAdapterData.add(new StarAnalysisItemBean("搭配珠宝：", mStarinfoBean.getZb(), R.color.lightred));
        mAdapterData.add(new StarAnalysisItemBean("幸运号码：", mStarinfoBean.getHm(), R.color.grey));
        mAdapterData.add(new StarAnalysisItemBean("相配金属：", mStarinfoBean.getJs(), R.color.darkblue));

        mListAdapter.notifyDataSetChanged();
    }

    private void initView() {
        mBackIV = findViewById(R.id.header_back_iv);
        mTitleTV = findViewById(R.id.header_title_tv);
        mLogoIV = findViewById(R.id.star_analysis_logo_iv);
        mNameTV = findViewById(R.id.star_analysis_name_tv);
        mDateTV = findViewById(R.id.star_analysis_date_tv);
        mLV = findViewById(R.id.star_analysis_lv);

        View footView = LayoutInflater.from(this).inflate(R.layout.lvfooter_star_analysis, null);
        mLV.addFooterView(footView);
        mAnalysisContentTV = footView.findViewById(R.id.lvfooter_star_analysis_content_tv);

        mBackIV.setOnClickListener(this);

        mTitleTV.setText("星座详情");
        mLogoIV.setImageBitmap(AssetsUtils.getCartoonLogoBitmapFromMap(mStarinfoBean.getLogoname()));
        mNameTV.setText(mStarinfoBean.getName());
        mDateTV.setText(mStarinfoBean.getDate());
        mAnalysisContentTV.setText(mStarinfoBean.getInfo());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.header_back_iv:
                finish();
                break;
        }
    }
}