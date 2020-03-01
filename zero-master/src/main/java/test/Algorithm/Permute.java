package test.Algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
给定一个没有重复数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  //基本思想：回溯思想进行每一层循环

 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        huisu(nums, l, result);
        return result;
    }

    public void huisu(int[] nums, List<Integer> l, List<List<Integer>> result) {
        if (l.size() == nums.length) {
            //指向新的一片地址空间使其变成不在跟随l改变而改变
            result.add(new ArrayList<Integer>(l));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                //判断
                if (l.contains(nums[i])) continue;
                l.add(nums[i]);
                huisu(nums, l, result);
                //退回一格
                l.remove(l.size() - 1);
            }
        }
    }


    public static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int longestSubString = 0;
        Set<Character> cSet = new HashSet<>();
        int start = 0, end = 0;
        while (end < s.length() && start < s.length()) {
            if (!cSet.contains(s.charAt(end))) {
                cSet.add(s.charAt(end++));
            } else {
                cSet.remove(s.charAt(start++));
            }
            longestSubString = Math.max(longestSubString, end - start);
        }
        String s1 = "";
        String s2 = "";

        return longestSubString;
    }

    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        find(list, nums, 0, nums.length - 1);
        return list;
    }

    public List<Integer> set(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list;
    }

    public void swap(int[] nums, int L, int R) {
        int tmp = nums[L];
        nums[L] = nums[R];
        nums[R] = tmp;
        return;
    }

    public void find(List<List<Integer>> list, int[] nums, int L, int R) {
        if (L == R) {//只有一位的时候，直接set
            list.add(set(nums));
        } else {
            for (int i = L; i <= R; i++) {
                swap(nums, L, i);//将第i个数放到第一位固定，然后去排后面的，这样就不用使用hash表来保存使用了多少数字，以及哪些数字没有使用了
                int[] nums_tmp = nums.clone();
                find(list, nums_tmp, L + 1, R);
            }
        }
        return;
    }


    public static boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        Boolean result = false;
        for (int i = 0; i <= (length2 - length1); i++) {
            result = commonChar(s2.substring(i, i + length1), s1);
            if (result) {
                return true;
            }
        }
        return false;

    }

    public static boolean commonChar(String s1, String s2) {

        String[] sArr = s1.split(" ");

        int length1 = s1.length();
        int length2 = s2.length();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < length1; i++) {
            arr1[s1.charAt(i) - 'a'] = ++arr1[s1.charAt(i) - 'a'];
        }
        for (int i = 0; i < length2; i++) {
            arr2[s2.charAt(i) - 'a'] = ++arr2[s2.charAt(i) - 'a'];
        }

        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static String reverseWords(String s) {
        String newS = "";
        String[] sArr = s.split(" ");
        for (int i = sArr.length - 1; i >= 0; i--) {
            if (sArr[i].equals(""))
                continue;
            if (newS.equals("")) {
                newS = sArr[i];
            } else {
                newS = newS + " " + sArr[i];
            }
        }
        return newS;
    }

    public static int findAroundMax(int[][] nums, int x, int y) {
        int row = nums.length;
        int col = nums[0].length;
        int max = nums[x][y];
        int maxX = x;
        int maxY = y;
        while (x >= 0 && x < row && y >= 0 && y < col) {
            if (x - 1 >= 0 && nums[x - 1][y] > max) {
                max = nums[x - 1][y];
                maxX = x - 1;
                maxY = y;
            }
            if (x + 1 < row && nums[x + 1][y] > max) {
                max = nums[x + 1][y];
                maxX = x + 1;
                maxY = y;
            }

            if (y - 1 > 0 && nums[x ][y - 1] > max) {
                max = nums[x + 1][y];
                maxX = x ;
                maxY = y -1;
            }

            if (y + 1 < col && nums[x ][y + 1] > max) {
                max = nums[x + 1][y];
                maxX = x ;
                maxY = y + 1;
            }

            if (max == nums[x][y])
                break;
            x = maxX;
            y = maxY;
        }
        return max;
    }

    public static int findLengthOfLCIS(int[] nums) {
        int start = 0;
        int max = 0;
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1]){
                start = i;
            }
            max = Math.max(max,i-start);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        //lengthOfLongestSubstring("abcabcbb");
        //checkInclusion("hello","ooolleoooleh");
        //reverseWords(" 1");
        int[] ints = {1,3,5,4,7};
        findLengthOfLCIS(ints);
    }
}
