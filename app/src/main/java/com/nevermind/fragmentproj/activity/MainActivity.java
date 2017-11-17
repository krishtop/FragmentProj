package com.nevermind.fragmentproj.activity;



import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nevermind.fragmentproj.R;
import com.nevermind.fragmentproj.fragments.MyFragment1;
import com.nevermind.fragmentproj.model.Place;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.frgmContainer, new MyFragment1())
                .commit();

    }

}
