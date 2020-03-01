package test.array;

import java.util.ArrayList;

/**
 * arr1 {1,2,3,5,6,7}
 * arr2 {3,5,6,7}
 */
public class MaxCommonSeq {
    public int getMaxCommonSeq(int arr1[], int arr2[]) {
        int arr1Length = arr1.length;
        int arr2Length = arr2.length;

        int m = 0;
        int n = 0;
        int maxLength = 0;
        int sumLength = 0;
        while (m < arr1Length && n < arr2Length) {
            if (arr1[m] > arr2[n]) {
                n++;
                sumLength = 0;
            } else if (arr1[m] < arr2[n]) {
                m++;
                sumLength = 0;
            } else {
                m++;
                n++;
                sumLength++;
            }
            maxLength = Math.max(maxLength, sumLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        MaxCommonSeq maxCommonSeq = new MaxCommonSeq();
        int[] arr1 = {1, 2, 3, 5, 6, 7};
        int[] arr2 = {3, 5, 6, 7};
        maxCommonSeq.getMaxCommonSeq(arr1, arr2);
    }
}
