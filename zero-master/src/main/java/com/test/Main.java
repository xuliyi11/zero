package com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import sun.net.www.http.HttpClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {



    private static int[] sort(int[] array){

        int right ; //从右从左找奇数
        int left; //从左到右找偶数

        right = array.length-1;
        left = 0;

        boolean findRight = false;
        boolean findLeft = false;

        int tem = 0 ; //临时变量

        //终止条件，右边数组下小于左边
        while (right>=left){

            //从右往左找奇数
           while (right >= left){

               if (array[right] % 2 == 1){

                   //找到奇数，移动数组下标位置
                   findRight = true;
                   break;

               }else {
                   findRight = false;
                   right--;
               }

           }

           //从左往右找到偶数
            while ( right >= left){

                if (array[left] % 2 == 0){

                    tem = array[left];
                    findLeft = true;
                    break;

                }else {
                    findLeft = false;
                    left++;

                }

            }

            if (findLeft && findRight){

                array[left] = array[right];
                array[right] = tem;


            }

        }

        return array;

    }

    //跳台阶
    private static int jump(int n){
        if (n<3){
            return n;
        }
        int count = 0;
        int count1 = 1;
        int count2 = 2;
        for (int i=3;i<=n;i++){
            count = count1+count2;
            count1 = count2;
            count2 = count;
        }
        return count;
    }


    //两个逆序数组组合成正序
    private static int[] assembleArray(int[] A,int[] B){
        if (A == null){
            return A;
        }
        if (B== null){
            return B;
        }
        int m = A.length-1;
        int n = B.length-1;

        int[] newArray = new int[A.length+B.length];
        int k = 0;
        while (m >= 0 && n>= 0){
            if (A[m]>=B[n]){
                newArray[k++] = B[n--];
            }else {
                newArray[k++] = A[m--];
            }
        }
        while (m>=0){
            newArray[k++] = A[m--];
        }

        while (n>=0){
            newArray[k++] = B[n--];
        }

        return newArray;
    }
    public static void main(String[] args) {
        String s = "123";
        String s1 = "123";
        String s2 = "123";
        System.out.println(true);
    }


}

/*
*  1  2  3 4
*  5  6  7 8
*  9 10 11 12
* */
