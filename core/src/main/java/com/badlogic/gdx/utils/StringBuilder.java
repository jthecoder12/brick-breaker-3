package com.badlogic.gdx.utils;

// Required for the latest stable version of VisUI to work with libGDX 1.14.0 since that release removed StringBuilder

@SuppressWarnings("unused")
public class StringBuilder extends CharArray {
    public StringBuilder() {
        super();
    }

    public StringBuilder(int capacity) {
        super(capacity);
    }

    public StringBuilder(String str) {
        super(str);
    }
}
