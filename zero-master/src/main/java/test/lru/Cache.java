package test.lru;

import java.util.*;

public class Cache {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("asbdbhc"));

    }

    //判断是否是回文字
    private static boolean isSame(int i) {
        StringBuilder s2 = new StringBuilder(i);
        String s1 = Integer.toString(i);
        return s2.reverse().toString().equals(s1);
    }

    //数组中三个数
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        return nums[0] * nums[1] > nums[length - 3] * nums[length - 2] ? nums[0] * nums[1] * nums[length - 1] : nums[length - 3] * nums[length - 2] * nums[length - 1];
    }

    public static int isTheSame(int i) {
        int old = i;
        int newNum = 0;
        while (i > 0) {
            int j = i % 10;
            newNum = newNum * 10 + j;
            i = i / 10;
        }
        return newNum;
    }


    /**
     * 找出数组中最长的不重复子串
     * 【1,2,4,1,5,6】
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int end=0,start=0;
        Set<Character> set=new HashSet<>();
        while(start<n && end<n){
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(start++));
            }else{
                set.add(s.charAt(end++));
                res=Math.max(res,end-start);
            }
        }
        return res;
    }
}
