package com.test;

public class OnlyTest {
    private int a;
    private static OnlyTest onlyTest;

    private OnlyTest(int a) {
        this.a = a;
    }

    public static OnlyTest getOnlyTest(){
        if(onlyTest!=null){
            return onlyTest;
        }else {
            onlyTest = new OnlyTest(1);
            return onlyTest;
        }

    }
}
