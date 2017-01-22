package com.jessyan.xs.topline.mvp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jessyan.xs.topline.R;
import com.jessyan.xs.topline.uitls.Constants;

/**
 * Created by xiaosong on 2017/1/23.
 */

public class MeFragment extends Fragment{

    public static MeFragment newInstance(String s){
        MeFragment homeFragment = new MeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.ARGS,s);
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_msg, container, false);
        Bundle bundle = getArguments();
        String s = bundle.getString(Constants.ARGS);
        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        textView.setText(s);
        return view;
    }

}
