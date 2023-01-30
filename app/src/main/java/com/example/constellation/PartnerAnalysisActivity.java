package com.example.constellation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.constellation.bean.PartnerAnalysisBean;
import com.example.constellation.common.URLHelper;
import com.example.constellation.utils.AssetsUtils;
import com.example.constellation.utils.AsyncTaskUtils;
import com.google.gson.Gson;

public class PartnerAnalysisActivity extends AppCompatActivity implements View.OnClickListener, AsyncTaskUtils.OnReceiveDataListener {

    private ImageView mBackIV;
    private TextView mTitleTV;
    private ImageView mMaleLogoIV;
    private ImageView mFemaleLogoIV;
    private TextView mMaleNameTV;
    private TextView mFemaleNameTV;
    private TextView mPdTV;
    private TextView mVsTV;
    private TextView mPfTV;
    private TextView mBzTV;
    private TextView mJxTV;
    private TextView mZyTV;

    private String mMaleName;
    private String mMaleLogoname;
    private String mFemaleName;
    private String mFemaleLogoname;

    public static void newIntent(Context context, String maleName, String maleLogoName,
                                 String femaleName, String femaleLogoName) {
        Intent intent = new Intent(context, PartnerAnalysisActivity.class);
        intent.putExtra("male_name", maleName);
        intent.putExtra("male_logoname", maleLogoName);
        intent.putExtra("female_name", femaleName);
        intent.putExtra("female_logoname", femaleLogoName);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner_analysis);

        Intent intent = getIntent();
        mMaleName = intent.getStringExtra("male_name");
        mMaleLogoname = intent.getStringExtra("male_logoname");
        mFemaleName = intent.getStringExtra("female_name");
        mFemaleLogoname = intent.getStringExtra("female_logoname");

        initView();

        String url = URLHelper.getPartnerURL(mMaleName, mFemaleName);
        AsyncTaskUtils task = new AsyncTaskUtils(this, this, true);
        task.execute(url);
    }

    private void initView() {
        mBackIV = findViewById(R.id.header_back_iv);
        mTitleTV = findViewById(R.id.header_title_tv);
        mMaleLogoIV = findViewById(R.id.partner_analysis_male_logo_iv);
        mFemaleLogoIV = findViewById(R.id.partner_analysis_female_logo_iv);
        mMaleNameTV = findViewById(R.id.partner_analysis_male_name_iv);
        mFemaleNameTV = findViewById(R.id.partner_analysis_female_name_iv);
        mPdTV = findViewById(R.id.partner_analysis_pd_tv);
        mVsTV = findViewById(R.id.partner_analysis_vs_tv);
        mPfTV = findViewById(R.id.partner_analysis_pf_tv);
        mBzTV = findViewById(R.id.partner_analysis_bz_tv);
        mJxTV = findViewById(R.id.partner_analysis_jx_tv);
        mZyTV = findViewById(R.id.partner_analysis_zy_tv);

        mTitleTV.setText("配对详情");

        mMaleLogoIV.setImageBitmap(AssetsUtils.getCartoonLogoBitmapFromMap(mMaleLogoname));
        mFemaleLogoIV.setImageBitmap(AssetsUtils.getCartoonLogoBitmapFromMap(mFemaleLogoname));
        mMaleNameTV.setText(mMaleName);
        mFemaleNameTV.setText(mFemaleName);
        mPdTV.setText("星座配对-" + mMaleName + "和" + mFemaleName + "配对");
        mVsTV.setText(mMaleName + " vs " + mFemaleName);

        mBackIV.setOnClickListener(this);
    }

    @Override
    public void onSuccess(String result) {
        if (!TextUtils.isEmpty(result)) {
            PartnerAnalysisBean partnerAnalysisBean = new Gson().fromJson(result, PartnerAnalysisBean.class);
            PartnerAnalysisBean.ResultBean resultBean = partnerAnalysisBean.getResult();

            mPfTV.setText("配对评分：" + resultBean.getZhishu() + "  " + resultBean.getJieguo());
            mBzTV.setText("星座比重：" + resultBean.getBizhong());
            mJxTV.setText("解析：\n\n" + resultBean.getLianai());
            mZyTV.setText("注意事项：\n\n" + resultBean.getZhuyi());
        }
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