package com.handy.fragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.fragmentContainer, new Fragment1());

        if (findViewById(R.id.detailFragmentContainer) != null)
            transaction.replace(R.id.detailFragmentContainer, new Fragment2());

        transaction.commit();
    }
}
