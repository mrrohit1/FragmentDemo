package com.example.savi.fragmentdemo.fragment.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.savi.fragmentdemo.R;
import com.example.savi.fragmentdemo.fragment.fragment.FourFragment1;
import com.example.savi.fragmentdemo.fragment.fragment.FourFragment2;
import com.example.savi.fragmentdemo.fragment.fragment.FourFragment3;
import com.example.savi.fragmentdemo.fragment.fragment.FourFragment4;

public class FourFragmentActivity extends AppCompatActivity {
    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_fragment);

        final FragmentManager manager = getSupportFragmentManager();


        Button button = (Button) findViewById(R.id.button_move_number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCount++;
                FourFragment1 fourFragment1 = FourFragment1.newInstance(mCount+0);
               FourFragment2 fourFragment2 = FourFragment2.newInstance(mCount+1);
                FourFragment3 fourFragment3 = FourFragment3.newInstance(mCount+2);
                FourFragment4 fourFragment4 = FourFragment4.newInstance(mCount+3);

                manager.beginTransaction().replace(R.id.container_1, fourFragment1).commit();
               manager.beginTransaction().replace(R.id.container_2, fourFragment2).commit();
                manager.beginTransaction().replace(R.id.container_3, fourFragment3).commit();
               manager.beginTransaction().replace(R.id.container_4, fourFragment4).commit();

            }
        });

    }
}
