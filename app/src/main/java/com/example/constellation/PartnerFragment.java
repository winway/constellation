package com.example.constellation;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.example.constellation.bean.ConstellationBean;
import com.example.constellation.utils.AssetsUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PartnerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartnerFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private static final String TAG = "PartnerFragment";

    private static final String ARG_CONSTELLATION_INFO = "constellation_info";

    private ImageView mMaleIV;
    private ImageView mFemaleIV;
    private Spinner mMaleSP;
    private Spinner mFemaleSP;
    private Button mPrizeBTN;
    private Button mAnalysisBTN;

    private ConstellationBean mConstellationBean;
    private List<ConstellationBean.StarinfoBean> mStarinfoBeanList;

    private List<String> mSpinAdapterData;

    public PartnerFragment() {
        // Required empty public constructor
    }

    public static PartnerFragment newInstance(ConstellationBean constellationBean) {
        PartnerFragment fragment = new PartnerFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_CONSTELLATION_INFO, constellationBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mConstellationBean = (ConstellationBean) getArguments().getSerializable(ARG_CONSTELLATION_INFO);
            mStarinfoBeanList = mConstellationBean.getStarinfo();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_partner, container, false);

        initView(view);

        initSpinner();

        return view;
    }

    private void initView(View view) {
        mMaleIV = view.findViewById(R.id.partner_male_logo_iv);
        mFemaleIV = view.findViewById(R.id.partner_female_logo_iv);
        mMaleSP = view.findViewById(R.id.partner_male_sp);
        mFemaleSP = view.findViewById(R.id.partner_female_sp);
        mPrizeBTN = view.findViewById(R.id.partner_prize_btn);
        mAnalysisBTN = view.findViewById(R.id.partner_analysis_btn);

        mPrizeBTN.setOnClickListener(this);
        mAnalysisBTN.setOnClickListener(this);
    }

    private void initSpinner() {
        mSpinAdapterData = new ArrayList<>();
        for (int i = 0; i < mStarinfoBeanList.size(); i++) {
            mSpinAdapterData.add(mStarinfoBeanList.get(i).getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), R.layout.spitem_partner, R.id.spitem_partner_tv, mSpinAdapterData);
        mMaleSP.setAdapter(arrayAdapter);
        mFemaleSP.setAdapter(arrayAdapter);

        mMaleIV.setImageBitmap(AssetsUtils.getCartoonLogoBitmapFromMap(mStarinfoBeanList.get(0).getLogoname()));
        mFemaleIV.setImageBitmap(AssetsUtils.getCartoonLogoBitmapFromMap(mStarinfoBeanList.get(0).getLogoname()));

        mMaleSP.setOnItemSelectedListener(this);
        mFemaleSP.setOnItemSelectedListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.partner_prize_btn:
                break;
            case R.id.partner_analysis_btn:
                int malePos = mMaleSP.getSelectedItemPosition();
                int femalePos = mFemaleSP.getSelectedItemPosition();
                PartnerAnalysisActivity.newIntent(getActivity(),
                        mStarinfoBeanList.get(malePos).getName(),
                        mStarinfoBeanList.get(malePos).getLogoname(),
                        mStarinfoBeanList.get(femalePos).getName(),
                        mStarinfoBeanList.get(femalePos).getLogoname()
                );
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i(TAG, "onItemSelected: " + adapterView.getId());
        switch (adapterView.getId()) {
            case R.id.partner_male_sp:
                Log.i(TAG, "onItemSelected: male");
                mMaleIV.setImageBitmap(AssetsUtils.getCartoonLogoBitmapFromMap(mStarinfoBeanList.get(i).getLogoname()));
                break;
            case R.id.partner_female_sp:
                Log.i(TAG, "onItemSelected: female");
                mFemaleIV.setImageBitmap(AssetsUtils.getCartoonLogoBitmapFromMap(mStarinfoBeanList.get(i).getLogoname()));
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}