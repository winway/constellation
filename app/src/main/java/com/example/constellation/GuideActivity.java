package com.example.constellation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.constellation.adapter.GuidePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {

    private ViewPager mVP;

    private int mImgIds[] = {R.mipmap.loading1, R.mipmap.loading2, R.mipmap.loading3};

    private List<ImageView> mAdapterData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        mVP = findViewById(R.id.guide_vp);

        mAdapterData = new ArrayList<>();

        initPager();
    }

    private void initPager() {
        for (int i = 0; i < mImgIds.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(mImgIds[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
            mAdapterData.add(imageView);
        }

        GuidePagerAdapter guidePagerAdapter = new GuidePagerAdapter(mAdapterData);
        mVP.setAdapter(guidePagerAdapter);

        ImageView imageView = mAdapterData.get(mAdapterData.size() - 1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}