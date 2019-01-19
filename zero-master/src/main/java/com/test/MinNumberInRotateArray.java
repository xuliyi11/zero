package com.test;

public class MinNumberInRotateArray {


    public static void main(String[] args) {

        int[] arr = {3, 4, 5, 1, 2};
    }


    public static int minNumberInRotateArray(int[] array) {

        if (array == null) {
            return 0;
        }

        int point = array[0];
        int min;

        for (int i = 0; i <= array.length - 1; i++) {
            if (point > array[i]) {
                return min = array[i];
            }
        }
        return min = 0;
    }
}
