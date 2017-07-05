package com.example.savi.fragmentdemo.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.savi.fragmentdemo.fragment.interfaces.OnButtonClickListener;
import com.example.savi.fragmentdemo.fragment.model.PersonalDetail;
import com.example.savi.fragmentdemo.R;

public class EducationalDetailFragment extends Fragment {
    OnButtonClickListener onButtonClickListener;

    PersonalDetail mPersonalDetail = new PersonalDetail();

    public static EducationalDetailFragment newInstance(PersonalDetail personalDetail) {
        EducationalDetailFragment fragment = new EducationalDetailFragment();
        fragment.mPersonalDetail = personalDetail;
        return fragment;
    }

    public void setOnbuttonClickListener(OnButtonClickListener listener) {
        onButtonClickListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_educational_detail, container, false);
        final EditText editTextPassingYear = (EditText) rootView.findViewById(R.id.edit_text_passing_year);
        final EditText editTextPercentage = (EditText) rootView.findViewById(R.id.edit_text_percentage);
        final EditText editTextUniversity = (EditText) rootView.findViewById(R.id.edit_text_university_name);

        TextView textViewName = (TextView) rootView.findViewById(R.id.text_view_name_educational);
        textViewName.setText(mPersonalDetail.getName());

        TextView textViewGender = (TextView) rootView.findViewById(R.id.text_view_gender_educational);
        textViewGender.setText(mPersonalDetail.getGender());

        TextView textViewAge = (TextView) rootView.findViewById(R.id.text_view_age_educational);
        textViewAge.setText(mPersonalDetail.getAge());

        TextView textViewNumber = (TextView) rootView.findViewById(R.id.text_view_contact_number_educational);
        textViewNumber.setText(mPersonalDetail.getName());

        TextView textViewCompanyName = (TextView) rootView.findViewById(R.id.text_view_company_name_educational);
        textViewCompanyName.setText(mPersonalDetail.getName());

        TextView textViewExperience = (TextView) rootView.findViewById(R.id.text_view_experiance_educational);
        textViewExperience.setText(mPersonalDetail.getExperience());

        TextView textViewSalary = (TextView) rootView.findViewById(R.id.text_view_salary_educational);
        textViewSalary.setText(mPersonalDetail.getSalary());


        Button buttonSubmit = (Button) rootView.findViewById(R.id.button_educational_submit);
        Button buttonPrevious = (Button) rootView.findViewById(R.id.button_educational_previous);
        final FloatingActionButton FABShowDetail = (FloatingActionButton) rootView.findViewById(R.id.FAB_show);
        FABShowDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPersonalDetail.setYearOfPssing(editTextPassingYear.getText().toString());
                mPersonalDetail.setPercentage(editTextPercentage.getText().toString());
                mPersonalDetail.setUniverssityName(editTextUniversity.getText().toString());
                onButtonClickListener.onNextButtonClick(mPersonalDetail);
            }
        });
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FABShowDetail.performClick();
            }
        });
        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClickListener.onPreviousButtonClick();
            }
        });
        return rootView;
    }
}
