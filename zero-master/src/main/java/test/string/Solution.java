package test.string;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {


    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        Solution solution = new Solution();
        int arr[] = {1, 7, 5, 1, 4, 6};
        solution.maxLongNoRepeat(arr);
        //char[] chars = {'H', 'a', 'n', 'n', 'a', 'h'};
        //solution.reverseString(chars);
        //solution.reverse(-123);
    }


    public void reverseString(char[] s) {
        int m = 0;
        int n = s.length - 1;
        char tem;
        while (n >= m) {
            tem = s[n];
            s[n] = s[m];
            s[m] = tem;
            n--;
            m++;
        }
        System.out.println(s);
    }

    public int reverse(int x) {
        int tem = x;
        if (x == 0) {
            return 0;
        }

        if (x < 0) {
            x = -x;
        }
        int point = 0;
        while (x != 0) {
            point = point * 10 + x % 10;
            x = x / 10;
        }
        return tem > 0 ? point : -point;
    }

    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * int arr {1,7,5,1,4,6}
     *
     * @param arr
     * @return
     */
    public int maxLongNoRepeat(int[] arr) {
        int start = 0;
        int end = 0;
        int max = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hashSet.contains(arr[i])) {
                hashSet.add(arr[i]);
                end++;
                max = Math.max(max, end-start  );
            } else {
                hashSet.remove(arr[start]);
                start++;
            }
        }
        return max;
    }

}
