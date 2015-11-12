package com.handy.fragments;

public class MyStringBuilder {
    private String string = "";

    public void appendString(String text) {
        string += text;
    }

    public String getString() {
        return string;
    }
}
