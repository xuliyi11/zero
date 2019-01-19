package com.test;

public class ChinaQuickSort {
    public static void quickSort(int[] arr){
        qsort(arr, 0, arr.length-1);
    }
    private static void qsort(int[] arr, int low, int high){
        if (low < high){
            int pivot=partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot-1);                   //递归排序左子数组
            qsort(arr, pivot+1, high);                  //递归排序右子数组
        }
    }
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];     //枢轴记录
        while (low<high){
            while (low<high && arr[high]>=pivot){
                --high;
            }
            arr[low]=arr[high];
            while (low<high && arr[low]<=pivot){
                ++low;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int arr[] = {3,2,5,1,4};
        quickSort(arr);
        for (int i:arr){
            System.out.println(i);
        }
    }
}
