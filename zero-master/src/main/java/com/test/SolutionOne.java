package com.test;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class SolutionOne {

    //找出数组中超过一半的数字
    private static int MoreThanHalfNum_Solution(int[] array) {

        //存储数字出现的次数 key 数字 val 次数
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i : array) {

            if (numbers.containsKey(i)) {
                numbers.put(i, numbers.get(i) + 1);
            } else {
                numbers.put(i, 1);
            }

        }

        for (Integer j : numbers.keySet()) {
            if (numbers.get(j) > array.length / 2) {
                return j;
            }
        }

        return 0;

    }

    //链表翻转
    private static ListNode reserveListNode(ListNode head) {

        ListNode preNode = null;
        ListNode currentNode = head;
        ListNode nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;

            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = nextNode;

        }


        return preNode;


    }

    //奇数位于偶数前面
    private static void reOrderArray(int[] array) {

        int i = array.length - 1;
        int j = 0;
        int tem;

        while (j < i) {

            //找奇数
            while (j < i && array[i] % 2 != 1) {
                i--;
            }

            //找偶数
            while (j < i && array[j] % 2 != 0) {

                j++;

            }

            tem = array[i];
            array[i] = array[j];
            array[j] = tem;


        }
        System.out.println(array);

    }

    //从数组中找出和为目标值的两个数
    private static int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (integerMap.containsKey(target - nums[i])) {
                return new int[]{i, integerMap.get(target - nums[i])};
            } else {
                integerMap.put(nums[i], i);
            }
        }
        return null;
    }

    //反转整数 123 -123
    private static boolean reverse(int x) {


        int newX;
        if (x > 0) {
            StringBuilder stringBuffer = new StringBuilder(Integer.valueOf(x).toString());
            newX = Integer.valueOf(stringBuffer.reverse().toString());
        } else {
            StringBuilder stringBuffer = new StringBuilder(Integer.valueOf(-x).toString());
            newX = -Integer.valueOf(stringBuffer.reverse().toString());
        }


        return newX == x;

    }


    //有效的括号
    private static boolean isValid(String s) {


        if (StringUtils.isEmpty(s)) {
            return false;
        }

        Stack<String> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (!stack.empty() && ("{".equals(stack.pop()) && "}".equals(String.valueOf(c)) ||
                    "(".equals(stack.pop()) && ")".equals(String.valueOf(c)) ||
                    "[".equals(stack.pop()) && "]".equals(String.valueOf(c))
            )) {
                stack.pop();
            } else {
                stack.push(String.valueOf(c));
            }
        }

        return stack.empty();
    }

    //两句话中的不常见单词
    private static String[] uncommonFromSentences(String A, String B) {

        if (A == null || A.equals("")) {
            return B.split(" ");
        }
        if (B == null || B.equals("")) {
            return A.split(" ");
        }

        Map<String, Integer> map = new HashMap<>();

        for (String a : A.split(" ")) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        for (String b : B.split(" ")) {
            if (map.containsKey(b)) {
                map.put(b, map.get(b) + 1);
            } else {
                map.put(b, 1);
            }
        }

        List<String> strings = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                strings.add(s);
            }
        }
        return strings.toArray(new String[0]);
    }

    //输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        if (array[0] > sum) {
            return new ArrayList<>();
        }
        int i = 0, j = array.length - 1;
        Map<Integer, Integer> result = new HashMap<>();
        while (i < j) {
            if (array[i] + array[j] == sum) {
                result.put(i, j);
                i++;
                j--;
            } else if (array[i] + array[j] >= sum) {
                j--;
            } else {
                i++;
            }
        }

        if (result.size() == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> integers = new ArrayList<>();
        if (result.size() == 1) {
            for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
                integers.add(array[entry.getKey()]);
                integers.add(array[entry.getValue()]);
            }
        } else {

            int min = Integer.MAX_VALUE;
            Stack<Map.Entry<Integer, Integer>> entryStack = new Stack<>();
            for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
                if (array[entry.getKey()] * array[entry.getValue()] > min) {
                    continue;
                } else {
                    min = array[entry.getKey()] * array[entry.getValue()];
                    entryStack.push(entry);
                }
            }

            Map.Entry<Integer, Integer> entry = entryStack.pop();
            integers.add(array[entry.getKey()]);
            integers.add(array[entry.getValue()]);
        }

        return integers;
    }


    //左旋转字符串
    private static String LeftRotateString(String str, int n) {
        if (str.length() == 0) {
            return null;
        }
        String s1 = str.substring(0, n);
        String s2 = str.substring(n);


        return s2 + s1;
    }

    //翻转单词顺序列
    private static String ReverseSentence(String str) {

        String newString;
        if (str == null) {
            newString = null;
        } else if (str.trim().equals("")) {
            newString = str;
        } else {
            String[] strS = str.split(" ");
            newString = strS[strS.length - 1];
            for (int i = strS.length - 2; i >= 0; i--) {
                newString = newString + " " + strS[i];
            }
        }
        return newString;


    }

    //扑克牌顺子
    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> noZero = new ArrayList<>();
        for (int i : numbers) {
            if (i == 0) {
                list.add(0);
            } else {
                noZero.add(i);
            }
        }

        Collections.sort(noZero);
        int needCount = 0;
        for (int j = 0; j < noZero.size() - 1; j++) {
            if (noZero.get(j + 1) - noZero.get(j) == 1) {
                continue;
            } else if (noZero.get(j + 1) - noZero.get(j) == 0) {
                return false;
            } else {
                needCount = needCount + noZero.get(j + 1) - noZero.get(j) - 1;
            }
        }

        return list.size() >= needCount;

    }

    //最小路径和
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length; //行
        int n = grid[0].length; //列
        int[][] newGrid = new int[m][n];
        newGrid[0][0] = grid[0][0];
        //获取行
        for (int i = 1; i < n; i++) {
            newGrid[0][i] = grid[0][i] + newGrid[0][i - 1];
        }
        for (int j = 1; j < m; j++) {
            newGrid[j][0] = grid[j][0] + newGrid[j - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                newGrid[i][j] = Math.min(newGrid[i][j - 1], newGrid[i - 1][j]) + grid[i][j];
            }
        }
        return newGrid[m - 1][n - 1];
    }

    //滑动窗口最大值
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        if (num == null) {
            return null;
        }
        if (num.length < size) {
            return new ArrayList<>();
        }
        int i = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        while (i + size <= num.length) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + size; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            integers.add(max);
            i++;
        }
        return integers;
    }

    //三角形最小路径和
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int tem = triangle.get(m - 1).size();

        int[][] newTriangle = new int[m][n];

        int a = 0;
        for (int i = m - 1; i >= 0; i--) {
            n = triangle.get(i).size();
            for (int j = 0; j < n; j++) {
                newTriangle[a][j] = triangle.get(i).get(j);
            }
            ++a;
        }

        for (int k = 1; k < m; k++) {
            for (int b = 0; b < tem - 1; b++) {
                newTriangle[k][b] = Math.min(newTriangle[k - 1][b], newTriangle[k - 1][b + 1]) + newTriangle[k][b];
            }
        }


        return newTriangle[m - 1][0];
    }

    //两个数组的交集
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (integerHashMap.containsKey(nums1[i])) {
                integerHashMap.put(nums1[i], integerHashMap.get(nums1[i]) + 1);
            } else {
                integerHashMap.put(nums1[i], 1);
            }
        }

        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (integerHashMap.containsKey(nums2[i])) {
                integers.add(nums2[i]);
                int count = integerHashMap.get(nums2[i]) - 1;
                if (count == 0) {
                    integerHashMap.remove(nums2[i]);
                } else {
                    integerHashMap.put(nums2[i], count);
                }
            }
        }
        int[] result = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            result[i] = integers.get(i);
        }

        return result;
    }

    //移动0
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (count != 0) {
                nums[i] = 0;
                count--;
            }
        }
    }

    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0 ){
            return 0;
        }
        int maxValu = nums[0];
        int maxBefore = 0;
        for (int i:nums){
            if (maxBefore>0){
                maxBefore = maxBefore+i;
            }else {
                maxBefore = i;
            }
            maxValu = Math.max(maxBefore,maxValu);
        }
        return maxValu;

    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(nums);
    }

}
