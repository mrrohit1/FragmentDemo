package com.example.savi.fragmentdemo.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.savi.fragmentdemo.R;


public class FourFragment3 extends Fragment {

    int mCount;

    public static FourFragment3 newInstance(int count) {
        FourFragment3 fragment = new FourFragment3();
        fragment.mCount = count;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.four_fragment_3, container, false);
        TextView textView = (TextView) view.findViewById(R.id.text_view_four_fragment_3);
        textView.setText(String.valueOf(mCount));
        return view;
    }
}
