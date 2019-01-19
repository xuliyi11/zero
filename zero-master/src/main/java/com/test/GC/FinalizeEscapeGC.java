package com.test.GC;

import java.sql.SQLOutput;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVA_HOOK = null;

    public void iaAlive(){
        System.out.println("yes still alive");
    }

    public void finalize(){

    }
}
