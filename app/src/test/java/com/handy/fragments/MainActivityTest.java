package com.handy.fragments;

import android.os.Build;
import android.support.v4.app.Fragment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.KITKAT)
public class MainActivityTest
{
    private ActivityController<MainActivity> mActivityController;

    @Before
    public void setUp() throws Exception
    {
        mActivityController = Robolectric.buildActivity(MainActivity.class);
    }

    @Test
    public void shouldContainFragment1() throws Exception
    {
        mActivityController.create().start().resume().visible();

        final MainActivity mainActivity = mActivityController.get();
        final Fragment fragment = mainActivity.getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        Assert.assertNotNull(fragment);
        Assert.assertTrue(fragment instanceof Fragment1);
    }
}