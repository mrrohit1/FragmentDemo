package com.example.savi.fragmentdemo.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.savi.fragmentdemo.fragment.interfaces.OnButtonClickListener;
import com.example.savi.fragmentdemo.fragment.model.PersonalDetail;
import com.example.savi.fragmentdemo.R;

public class PersonalDetailFragment extends Fragment {


    OnButtonClickListener onButtonClickListener;

    public static PersonalDetailFragment newInstance() {
        return new PersonalDetailFragment();
    }

    public void setOnbuttonClickListener(OnButtonClickListener listener) {
        onButtonClickListener = listener;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_personal_details, container, false);
        final EditText editTextName = (EditText) rootView.findViewById(R.id.edit_text_name);
        final EditText editTextAge = (EditText) rootView.findViewById(R.id.edit_text_age);
        final EditText editTextGender = (EditText) rootView.findViewById(R.id.edit_text_gender);
        final EditText editTextContactNo = (EditText) rootView.findViewById(R.id.edit_text_contact_number);

        final Button buttonSubmit = (Button) rootView.findViewById(R.id.button_personal_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalDetail mPersonalDetail = new PersonalDetail();
                mPersonalDetail.setName(editTextName.getText().toString());
                mPersonalDetail.setGender(editTextGender.getText().toString());
                mPersonalDetail.setAge(editTextAge.getText().toString());
                mPersonalDetail.setContactNo(editTextContactNo.getText().toString());
                onButtonClickListener.onNextButtonClick(mPersonalDetail);
            }
        });
        Button buttonNext = (Button) rootView.findViewById(R.id.button_next_personal);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSubmit.performClick();
            }
        });
        return rootView;

    }
}
