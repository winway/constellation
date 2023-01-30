package com.example.constellation;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.constellation.adapter.LuckGridAdapter;
import com.example.constellation.bean.ConstellationBean;
import com.example.constellation.utils.AssetsUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_CONSTELLATION_INFO = "constellation_info";

    private CircleImageView mLogoIV;
    private TextView mNameTV;

    private ConstellationBean mConstellationBean;
    private List<ConstellationBean.StarinfoBean> mAdapterData;

    private SharedPreferences mPreferences;
    private int mChoosePos;

    public MeFragment() {
        // Required empty public constructor
    }

    public static MeFragment newInstance(ConstellationBean constellationBean) {
        MeFragment fragment = new MeFragment();
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
            mAdapterData = mConstellationBean.getStarinfo();
        }

        mPreferences = getContext().getSharedPreferences("choose_star", Context.MODE_PRIVATE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        mLogoIV = view.findViewById(R.id.me_logo_iv);
        mNameTV = view.findViewById(R.id.me_name_tv);

        String name = mPreferences.getString("name", "白羊座");
        String logoName = mPreferences.getString("logo_name", "baiyang");

        mLogoIV.setImageBitmap(AssetsUtils.getCartoonLogoBitmapFromMap(logoName));
        mNameTV.setText(name);

        mLogoIV.setOnClickListener(this);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        ConstellationBean.StarinfoBean starinfoBean = mAdapterData.get(mChoosePos);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString("name", starinfoBean.getName());
        editor.putString("logo_name", starinfoBean.getLogoname());
        editor.apply();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.me_logo_iv:
                showDialog();
                break;
        }
    }

    private void showDialog() {
        Dialog dialog = new Dialog(getContext());
        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_me, null);
        dialog.setContentView(dialogView);
        dialog.setTitle("请选择您的星座：");
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        GridView dialogGV = dialogView.findViewById(R.id.me_dialog_gv);
        LuckGridAdapter gridAdapter = new LuckGridAdapter(getContext(), mAdapterData);
        dialogGV.setAdapter(gridAdapter);

        dialogGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ConstellationBean.StarinfoBean starinfoBean = mAdapterData.get(i);
                mLogoIV.setImageBitmap(AssetsUtils.getCartoonLogoBitmapFromMap(starinfoBean.getLogoname()));
                mNameTV.setText(starinfoBean.getName());
                mChoosePos = i;
                dialog.cancel();
            }
        });

        dialog.show();
    }
}