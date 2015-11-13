package com.handy.fragments;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.KITKAT, qualifiers = "land")
public class MainActivityTest {
    private ActivityController<MainActivity> mActivityController;

    @Before
    public void setUp() throws Exception {
        mActivityController = Robolectric.buildActivity(MainActivity.class);
        mActivityController.create().start().resume().visible();
    }

    @Test
    public void shouldContainFragment1() throws Exception {
        final MainActivity mainActivity = mActivityController.get();
        final Fragment fragment = mainActivity.getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        Assert.assertNotNull(fragment);
        Assert.assertTrue(fragment instanceof Fragment1);
    }

    @Test
    public void shouldContainFragment2() throws Exception {
        final MainActivity mainActivity = mActivityController.get();
        final Fragment fragment = mainActivity.getSupportFragmentManager().findFragmentById(R.id.detailFragmentContainer);
        Assert.assertNotNull(fragment);
        Assert.assertTrue(fragment instanceof Fragment2);
    }

    @Test
    public void shouldChangeTextOnFragment2() throws Exception {
        final MainActivity mainActivity = mActivityController.get();
        final Button button = (Button) mainActivity.findViewById(R.id.fragment1Button);
        final TextView textView = (TextView) mainActivity.findViewById(R.id.fragment2TextView);
        Assert.assertNotNull(button);
        Assert.assertNotNull(textView);
        button.performClick();
        Assert.assertEquals("Fragment1's button is clicked", textView.getText());
    }

}
