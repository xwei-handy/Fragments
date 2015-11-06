package com.handy.fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.Fragment1Callback {

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

    @Override
    public void button1Clicked() {
        Fragment2 fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.detailFragmentContainer);
        if (fragment2 == null)
            Toast.makeText(this, "There isn't a fragment 2", Toast.LENGTH_SHORT).show();
        else
            fragment2.changeText("Fragment1's button is clicked");
    }
}
