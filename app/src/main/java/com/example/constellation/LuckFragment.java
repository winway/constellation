package com.example.constellation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.constellation.adapter.LuckGridAdapter;
import com.example.constellation.bean.ConstellationBean;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LuckFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LuckFragment extends Fragment {

    private static final String ARG_CONSTELLATION_INFO = "constellation_info";

    private GridView mGV;

    private ConstellationBean mConstellationBean;
    private List<ConstellationBean.StarinfoBean> mAdapterData;
    private LuckGridAdapter mGridAdapter;

    public LuckFragment() {
        // Required empty public constructor
    }

    public static LuckFragment newInstance(ConstellationBean constellationBean) {
        LuckFragment fragment = new LuckFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_luck, container, false);
        mGV = view.findViewById(R.id.luck_gv);

        mGridAdapter = new LuckGridAdapter(getContext(), mAdapterData);
        mGV.setAdapter(mGridAdapter);

        mGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ConstellationBean.StarinfoBean starinfoBean = mAdapterData.get(i);
                LuckAnalysisActivity.newIntent(getActivity(), starinfoBean.getName());
            }
        });

        return view;
    }
}