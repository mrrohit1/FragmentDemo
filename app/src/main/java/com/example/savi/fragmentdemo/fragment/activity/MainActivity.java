package com.example.savi.fragmentdemo.fragment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.savi.fragmentdemo.fragment.fragment.EducationalDetailFragment;
import com.example.savi.fragmentdemo.fragment.interfaces.OnButtonClickListener;
import com.example.savi.fragmentdemo.fragment.model.PersonalDetail;
import com.example.savi.fragmentdemo.fragment.fragment.PersonalDetailFragment;
import com.example.savi.fragmentdemo.fragment.fragment.ProfessionalDetailFragment;
import com.example.savi.fragmentdemo.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final FragmentManager fragmentManager = getSupportFragmentManager();

        final PersonalDetailFragment personaldetailFragment = PersonalDetailFragment.newInstance();
        personaldetailFragment.setOnbuttonClickListener(new OnButtonClickListener() {
            @Override
            public void onNextButtonClick(PersonalDetail personalDetail) {
                final ProfessionalDetailFragment professionalDetailFragment = ProfessionalDetailFragment.newInstance(personalDetail);
                professionalDetailFragment.setOnbuttonClickListener(new OnButtonClickListener() {
                    @Override
                    public void onNextButtonClick(PersonalDetail personalDetail) {
                        EducationalDetailFragment educationalDetailFragment = EducationalDetailFragment.newInstance(personalDetail);
                        educationalDetailFragment.setOnbuttonClickListener(new OnButtonClickListener() {
                            @Override
                            public void onNextButtonClick(PersonalDetail personalDetail) {
                                Bundle bundle = new Bundle();
                                bundle.putString("name", personalDetail.getName());
                                bundle.putString("age", personalDetail.getAge());
                                bundle.putString("gender", personalDetail.getGender());
                                bundle.putString("contactNo", personalDetail.getContactNo());
                                bundle.putString("company name", personalDetail.getCompanyName());
                                bundle.putString("Experience", personalDetail.getExperience());
                                bundle.putString("Salary", personalDetail.getSalary());
                                bundle.putString("Passing year", personalDetail.getYearOfPssing());
                                bundle.putString("Experience", personalDetail.getExperience());
                                bundle.putString("University Name", personalDetail.getUniverssityName());
                                bundle.putString("percentage", personalDetail.getPercentage());
                                Intent intent = new Intent(getApplicationContext(), PersonalDetailActivity.class);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }

                            @Override
                            public void onPreviousButtonClick() {
                                fragmentManager.beginTransaction().replace(R.id.main_container, professionalDetailFragment).commit();
                            }
                        });
                        fragmentManager.beginTransaction().replace(R.id.main_container, educationalDetailFragment).commit();
                    }

                    @Override
                    public void onPreviousButtonClick() {
                        fragmentManager.beginTransaction().replace(R.id.main_container, personaldetailFragment).commit();
                    }
                });
                fragmentManager.beginTransaction().replace(R.id.main_container, professionalDetailFragment).commit();
            }

            @Override
            public void onPreviousButtonClick() {

            }
        });
        fragmentManager.beginTransaction().add(R.id.main_container, personaldetailFragment).commit();


    }
}
