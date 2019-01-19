package com.test;

public class Fibonacci {

    public static int fibonacci(int n) {
        if(n ==1 || n ==2){
            return 1;
        }else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public static void test(){
        String number ="117716345we";
        String [] arg = number.split("");
        int tem=0;
        for(int i=0;i<arg.length;i++){
            if(Integer.valueOf(arg[i])==1){
                tem++ ;
            }
        }
        System.out.println(tem);
    }
    public static void main(String[] args) {

       char c = 1;
        System.out.println(Integer.valueOf(c));
        String arg="124561234w";
        char[] chararr = arg.toCharArray();
        int tem = 0;
        for(int i=0;i<chararr.length;i++){
            if(Integer.valueOf(chararr[i]).equals(1))
                tem++;
        }
        System.out.println(tem);


    }

}
