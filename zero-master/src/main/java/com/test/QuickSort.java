package com.test;

public class QuickSort {

    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // 记录小于基准值的index
        for (int j=low; j<high; j++)
        {
            //遍历，寻找到小于基准值的数，并且交换位置
            if (arr[j] <= pivot)
            {
                i++;

                // j的位置数值小于基准值，i的数值大于基准值
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 将基准值交换到适合的位置
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    private static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = {1,2,3,10, 5};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }

}
