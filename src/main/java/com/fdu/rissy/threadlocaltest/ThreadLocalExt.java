package com.fdu.rissy.threadlocaltest;

import java.util.Date;

public class ThreadLocalExt extends ThreadLocal {

    @Override
    protected Object initialValue() {
        //return "default value, will not return null at fisrt time";
        return new Date().getTime();
    }
}
