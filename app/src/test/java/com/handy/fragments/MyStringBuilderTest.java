package com.handy.fragments;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyStringBuilderTest {
    private MyStringBuilder myStringBuilder;

    @Before
    public void setUp() throws Exception {
        myStringBuilder = new MyStringBuilder();
    }

    @Test
    public void shouldAppendString() {
        myStringBuilder.appendString("Hello");
        Assert.assertEquals("Hello", myStringBuilder.getString());
        myStringBuilder.appendString(" World");
        Assert.assertEquals("Hello World", myStringBuilder.getString());
    }
}
