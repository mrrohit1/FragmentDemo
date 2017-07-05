package com.example.savi.fragmentdemo.fragment.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.savi.fragmentdemo.R;
import com.example.savi.fragmentdemo.fragment.fragment.ReaplaceFreagment;


public class FragmentBackStackActivity extends AppCompatActivity {
    int count=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.back_stack_activity);



        final FragmentManager manager = getSupportFragmentManager();


        Button buttonReplace = (Button)findViewById(R.id.button_replace_fragment);
        buttonReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                ReaplaceFreagment reaplaceFreagment = ReaplaceFreagment.newInstance(count);
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container_back_stack,reaplaceFreagment);
                if(count%2==0){
                transaction.addToBackStack(count+"");
                }
                transaction.commit();
                Log.e("fragment count", getSupportFragmentManager().getBackStackEntryCount()+"");
            }
        });
    }

}
