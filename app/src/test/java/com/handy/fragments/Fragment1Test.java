package com.handy.fragments;

import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.KITKAT)
public class Fragment1Test {

    private Fragment1 mFragment;

    @Before
    public void setUp() throws Exception
    {
        mFragment = new Fragment1();
        SupportFragmentTestUtil.startFragment(mFragment, MainActivity.class);
    }

    @Test
    public void shouldContainInitialContentText() throws Exception
    {
        TextView textView = (TextView) mFragment.getView().findViewById(R.id.fragment1TextView);
        Assert.assertNotNull(textView);
        Assert.assertEquals("This is fragment 1", textView.getText());
    }

    @Test
    public void shouldContainInitialButtonText() throws Exception
    {
        Button button = (Button) mFragment.getView().findViewById(R.id.fragment1Button);
        Assert.assertNotNull(button);
        Assert.assertEquals("New Button", button.getText());
    }
}
