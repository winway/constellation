package com.example.constellation;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.constellation.adapter.LuckAnalysisListAdapter;
import com.example.constellation.bean.LuckAnalysisBean;
import com.example.constellation.bean.LuckAnalysisItemBean;
import com.example.constellation.common.URLHelper;
import com.example.constellation.utils.AsyncTaskUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class LuckAnalysisActivity extends AppCompatActivity implements View.OnClickListener, AsyncTaskUtils.OnReceiveDataListener {

    private static final String ARG_STAR_NAME = "star_name";

    private ImageView mBackIV;
    private TextView mTitleTV;
    private ListView mLV;

    private String mStarName;
    private List<LuckAnalysisItemBean> mAdapterData;
    private LuckAnalysisListAdapter mListAdapter;

    public static void newIntent(Context context, String name) {
        Intent intent = new Intent(context, LuckAnalysisActivity.class);
        intent.putExtra(ARG_STAR_NAME, name);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck_analysis);

        Intent intent = getIntent();
        mStarName = intent.getStringExtra(ARG_STAR_NAME);

        initView();

        String luckURL = URLHelper.getLuckURL(mStarName);
        AsyncTaskUtils task = new AsyncTaskUtils(this, this, true);
        task.execute(luckURL);
    }

    private void initView() {
        mBackIV = findViewById(R.id.header_back_iv);
        mTitleTV = findViewById(R.id.header_title_tv);
        mLV = findViewById(R.id.luck_analysis_lv);

        mTitleTV.setText(mStarName);

        mBackIV.setOnClickListener(this);

        mAdapterData = new ArrayList<>();
        mListAdapter = new LuckAnalysisListAdapter(this, mAdapterData);
        mLV.setAdapter(mListAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.header_back_iv:
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(String result) {
        if (!TextUtils.isEmpty(result)) {
            LuckAnalysisBean luckAnalysisBean = new Gson().fromJson(result, LuckAnalysisBean.class);
            mAdapterData.add(new LuckAnalysisItemBean("综合运势", luckAnalysisBean.getMima().getText().get(0), Color.BLUE));
            mAdapterData.add(new LuckAnalysisItemBean("爱情运势", luckAnalysisBean.getLove().get(0), Color.GRAY));
            mAdapterData.add(new LuckAnalysisItemBean("事业学业", luckAnalysisBean.getCareer().get(0), Color.GREEN));
            mAdapterData.add(new LuckAnalysisItemBean("健康运势", luckAnalysisBean.getHealth().get(0), Color.RED));
            mAdapterData.add(new LuckAnalysisItemBean("财富运势", luckAnalysisBean.getFinance().get(0), Color.BLACK));

            mListAdapter.notifyDataSetChanged();
        }
    }
}