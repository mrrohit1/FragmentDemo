package com.example.savi.fragmentdemo.fragment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.savi.fragmentdemo.R;

public class PersonalDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_detail);
        Bundle bundle1 = getIntent().getExtras();

        TextView textViewName = (TextView) findViewById(R.id.text_view_show_name);
        textViewName.setText(bundle1.getString("name"));

        TextView textViewAge = (TextView) findViewById(R.id.text_view_show_age);
        textViewAge.setText(bundle1.getString("age"));

        TextView textViewGender = (TextView) findViewById(R.id.text_view_show_gender);
        textViewGender.setText(bundle1.getString("gender"));

        TextView textViewContactNo = (TextView) findViewById(R.id.text_view_show_contact_number);
        textViewContactNo.setText(bundle1.getString("contactNo"));

        TextView textViewCompanyName = (TextView) findViewById(R.id.text_view_show_company_name);
        textViewCompanyName.setText(bundle1.getString("company name"));

        TextView textViewExperience = (TextView) findViewById(R.id.text_view_show_experience);
        textViewExperience.setText(bundle1.getString("Experience"));

        TextView textViewSalary = (TextView) findViewById(R.id.text_view_show_salary);
        textViewSalary.setText(bundle1.getString("Salary"));

        TextView textViewPassingYear = (TextView) findViewById(R.id.text_view_show_passing_year);
        textViewPassingYear.setText(bundle1.getString("Passing year"));

        TextView textViewPercentage = (TextView) findViewById(R.id.text_view_show_percentage);
        textViewPercentage.setText(bundle1.getString("percentage"));

        TextView textViewUniversityName = (TextView) findViewById(R.id.text_view_show_university_name);
        textViewUniversityName.setText(bundle1.getString("University Name"));



    }







}
