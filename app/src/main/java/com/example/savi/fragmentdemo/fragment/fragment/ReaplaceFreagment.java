package com.example.savi.fragmentdemo.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.savi.fragmentdemo.R;


public class ReaplaceFreagment extends Fragment {
    int countShow = 0;

    public static ReaplaceFreagment newInstance(int count) {
        ReaplaceFreagment fragment = new ReaplaceFreagment();
        fragment.countShow = count;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_replace_layout, container, false);
        TextView textView = (TextView) view.findViewById(R.id.text_view_replace_number);
        textView.setText(String.valueOf(countShow));
        return view;
    }
}

