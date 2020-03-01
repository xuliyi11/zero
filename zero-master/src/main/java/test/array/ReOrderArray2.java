package test.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReOrderArray2 {


    public static int[] getReOrderArray2(int[] arr) {
        int i = 0, j;
        while (i < arr.length) {
            while (i < arr.length && arr[i] < 0) {
                i++;
            }
            j = i + 1;
            while (j < arr.length && arr[j] > 0) {
                j++;
            }
            if (j < arr.length) {
                int tem = arr[j];
                for (int n = j - 1; n >= i; n--) {
                    arr[n + 1] = arr[n];
                }
                arr[i] = tem;
            } else {
                break;
            }

        }
        return arr;
    }

    /**
     * 查找链表环的入口
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode meetNode = null;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p1 != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                meetNode = p1;
                break;
            }
        }
        if (meetNode == null) {
            return null;
        }
        while (head != null && meetNode != null) {
            if (meetNode == head) {
                return meetNode;
            }
            meetNode = meetNode.next;
            head = head.next;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 众数
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int point  = nums[0];
        int count = 1;
        for(int i = 1;i<nums.length-1;i++){
            if(nums[i] == point){
                count++;
            }else {
                count--;
                if(count == 0){
                    point = nums[++i];
                    count = 1;
                }
            }
        }
        count = 0;
        for(int i : nums){
            if(i == point){
                count++;
            }
        }
        return nums.length/2>count ? 0 : point;
    }

    public static boolean isPowerOfTwo(int n) {
        if(n == 0){
            return false;
        }
        if(n<0){
            n = -n;
        }
        while(n>1){
            if(n % 2 != 0){
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    public static void sort(int[] arr,int left,int right,int[] tem){
        if (left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,tem);
            sort(arr,mid+1,right,tem);
            merge(arr,left,mid,right,tem);
        }
    }

    public static void merge(int[] arr,int left,int mid ,int right,int[] tem){
        int i = 0;
        while(left<mid && right>mid){
            if (arr[left]>arr[right]){
                tem[i++] = arr[right++];
            }else {
                tem[i++] = arr[left++];
            }
        }
        while (left<mid){
            tem[i++] = arr[left++];
        }
        while (right>mid){
            tem[i++] = arr[right++];
        }
        i = 0;
        while (left<right){
            arr[left++] = tem[i++];
        }
    }

    /**
     * 1 2 3 4
     * 5 6 7 8
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0){
            return list;
        }
       int start  = 0;

       int row = matrix.length-1;
       int col = matrix[0].length-1;
       while (start<row && start<col){

          for (int i = start;i<=col;i++){
              list.add(matrix[start][i]);
          }
          for (int i = start+1;i<=row;i++){
              list.add(matrix[i][col]);
          }
          for (int i =col -1;i>=start;i--){
              list.add(matrix[row][i]);
          }
          for (int i = row-1;i>start;i--){
              list.add(matrix[i][start]);
          }
          start++;
          row--;
          col--;
       }
        if (start == row){
            for (int i = start;i<=col;i++){
                list.add(matrix[row][i]);
            }
        }else if (start == col){
            for (int i = start;i<=row;i++){
                list.add(matrix[i][col]);
            }
        }
        return list;
    }

    public static boolean isPowerOfThree(int n) {
        if(n == 1){
            return true;
        }
        while(n>=3){
            if(n%3 != 0){
                return false;
            }
            n = n / 3;
            if(n == 1){
                return true;
            }
        }

        return false;
    }


    public static String multiply(String num1, String num2) {
        int num1Length = num1.length() ;
        int num2Length = num2.length() ;
        int[] nums = new int[num1Length+num2Length];
        Arrays.fill(nums,0);
        int length = num1Length+num2Length-2;

        for(int i =num1Length-1;i>=0;i-- ){
            for(int j=num2Length-1;j>=0;j--){
                nums[length-i-j] = nums[length-i-j] + (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }

        for(int i = 0;i<nums.length-1;i++){
            while(nums[i]>=10){
                nums[i+1] = nums[i+1]+ nums[i] / 10;
                nums[i] = nums[i] % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = nums.length-1;
        while (i>0 && nums[i] == 0 ){
            i--;
        }
        while (i>=0){
            sb.append(nums[i]);
            i--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //int[] a = {1, -3, 5, 4, 9, -1};
        //getReOrderArray2(a);

        //ListNode a = new ListNode(3);
        //ListNode b = new ListNode(2);
        //ListNode c = new ListNode(0);
        //ListNode d = new ListNode(-4);

        //a.next = b;
        //b.next = c;
        //c.next = d;
        //d.next = b;

        //detectCycle(a);
        //majorityElement(new int[]{3,2,3});
        //isPowerOfTwo(-16);
        //int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        //spiralOrder(arr);
        //System.out.println(isPowerOfThree(27));
        //System.out.println(multiply("1234567","7654321"));
        ReOrderArray2 reOrderArray2 = new ReOrderArray2();

        TreeNode treeNode1 = new TreeNode(15);
        TreeNode treeNode2 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(9);
        TreeNode treeNode5 = new TreeNode(-10);
        treeNode3.left = treeNode1;
        treeNode3.right = treeNode2;
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode3;
        maxPathSum(treeNode5);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }

    static int   maxPath = 0;
    public static int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        int maxLeft = maxPathSum(root.left);
        int maxRight = maxPathSum(root.right);
        maxPath = maxLeft + maxRight + root.val > maxPath ? maxLeft + maxRight + root.val : maxPath;
        return maxPath;
    }
}
