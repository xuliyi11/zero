package com.test;

public class MyQuickSort {
    int partition(int[] arr, int low, int height) {
        int point = arr[low];
        while (low < height) {
            while (low < height && arr[height] > point) {
                height--;
            }
            arr[low] = arr[height];
            while (low < height && arr[low] < point) {
                low++;
            }
            arr[height] = arr[low];
        }
        arr[low] = point;
        return low;
    }
}
