package com.example.savi.fragmentdemo.fragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class ProfessionalDetailFragment extends Fragment {

    PersonalDetail mPersonaDetail = new PersonalDetail();
    OnButtonClickListener onButtonClickListener;

    public static ProfessionalDetailFragment newInstance(PersonalDetail personaDetail) {
        ProfessionalDetailFragment fragment = new ProfessionalDetailFragment();
        fragment.mPersonaDetail = personaDetail;
        return fragment;
    }

    public void setOnbuttonClickListener(OnButtonClickListener listener) {
        onButtonClickListener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_professional_detail, container, false);
        final EditText editTextCompanyName = (EditText) rootView.findViewById(R.id.edit_text_company_name_professional);
        final EditText editTextExperience = (EditText) rootView.findViewById(R.id.edit_text_experience_professional);
        final EditText editTextSalary = (EditText) rootView.findViewById(R.id.edit_text_salary_professional);

        TextView textViewName = (TextView) rootView.findViewById(R.id.text_view_name_professional);
        TextView textViewGender = (TextView) rootView.findViewById(R.id.text_view_gender_professional);
        TextView textViewAge = (TextView) rootView.findViewById(R.id.text_view_age_professional);
        TextView textViewNumber = (TextView) rootView.findViewById(R.id.text_view_contact_number_professional);

        textViewName.setText(mPersonaDetail.getName());
        textViewGender.setText(mPersonaDetail.getGender());
        textViewAge.setText(mPersonaDetail.getAge());
        textViewNumber.setText(mPersonaDetail.getContactNo());

        Button buttonSubmit = (Button) rootView.findViewById(R.id.button_professinal_submit);
        final Button buttonNext = (Button) rootView.findViewById(R.id.button_professinal_next);
        Button buttonPrevious = (Button) rootView.findViewById(R.id.button_professinal_previous);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPersonaDetail.setCompanyName(editTextCompanyName.getText().toString());
                mPersonaDetail.setExperience(editTextExperience.getText().toString());
                mPersonaDetail.setSalary(editTextSalary.getText().toString());
                onButtonClickListener.onNextButtonClick(mPersonaDetail);
            }
        });
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonNext.performClick();
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
