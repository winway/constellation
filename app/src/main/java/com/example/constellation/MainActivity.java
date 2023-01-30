package com.example.constellation;

import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.constellation.bean.ConstellationBean;
import com.example.constellation.utils.AssetsUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private static final String TAG = "MainActivity";

    private RadioGroup mNaviRG;

    private Fragment mStarFragment;
    private Fragment mPartnerFragment;
    private Fragment mLuckFragment;
    private Fragment mMeFragment;
    private List<Fragment> mFragmentList;
    private FragmentManager mFragmentManager;

    private ConstellationBean mConstellationBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNaviRG = findViewById(R.id.main_navigate_rg);
        mNaviRG.setOnCheckedChangeListener(this);

        mConstellationBean = loadData();

        initFragment();
    }

    private ConstellationBean loadData() {
        String s = AssetsUtils.getStringFromFile(MainActivity.this, "xzcontent/xzcontent.json");
        ConstellationBean constellationBean = new Gson().fromJson(s, ConstellationBean.class);
        AssetsUtils.loadLogo(MainActivity.this, constellationBean);
        return constellationBean;
    }

    private void initFragment() {
        mStarFragment = StarFragment.newInstance(mConstellationBean);
        mPartnerFragment = PartnerFragment.newInstance(mConstellationBean);
        mLuckFragment = LuckFragment.newInstance(mConstellationBean);
        mMeFragment = MeFragment.newInstance(mConstellationBean);

        mFragmentList = new ArrayList<>();
        mFragmentList.add(mStarFragment);
        mFragmentList.add(mPartnerFragment);
        mFragmentList.add(mLuckFragment);
        mFragmentList.add(mMeFragment);

        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        for (Fragment frag : mFragmentList) {
            transaction.add(R.id.main_body_ll, frag);
            transaction.hide(frag);
        }

        transaction.show(mStarFragment);

        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.main_star_rb:
                navigateTo(mStarFragment);
                break;
            case R.id.main_partner_rb:
                navigateTo(mPartnerFragment);
                break;
            case R.id.main_luck_rb:
                navigateTo(mLuckFragment);
                break;
            case R.id.main_me_rb:
                navigateTo(mMeFragment);
                break;
        }
    }

    private void navigateTo(Fragment fragment) {
        Log.i(TAG, "navigateTo: " + fragment.getClass().getName());

        FragmentTransaction transaction = mFragmentManager.beginTransaction();

        for (Fragment frag : mFragmentList) {
            if (frag == fragment) {
                transaction.show(frag);
            } else {
                transaction.hide(frag);
            }
        }

        transaction.commit();
    }
}