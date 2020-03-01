package test.Algorithm;

import java.util.*;

public class Solution {
//
//    /**
//     * {1,3,5,1,4,2,7,4}
//     *
//     * @param arr
//     * @return
//     */
//    public int[] longestNoRepeat(int[] arr) {
//        Map<Integer, ArrayList<Integer>> integerMap = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            if (integerMap.containsKey(i)) {
//
//            } else {
//                ArrayList<Integer> arrayList = new ArrayList<>();
//                arrayList.add(i);
//                arrayList.add(i);
//                //integerMap.put(arr[i],)
//                for (Integer integer : integerMap.keySet()) {
//                    integerMap.get(integer).indexOf(1);
//                    //  integerMap.put(integer,);
//                }
//            }
//        }
//        return null;
//    }
//
//
//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        return doSearch(0, nums.length - 1, target, nums);
//    }
//
//    public int doSearch(int l, int r, int target, int[] nums) {
//        while (l <= r) {
//            int mid = (l + r) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[mid] >= nums[l] && nums[mid] > target) {
//                if (target >= nums[l]) {
//                    r = mid - 1;
//                } else {
//                    l = mid + 1;
//                }
//            } else if (nums[mid] >= nums[l] && nums[mid] < target) {
//                l = mid + 1;
//            } else if (nums[mid] <= nums[l] && nums[mid] > target) {
//                r = mid - 1;
//            } else if (nums[mid] <= nums[l] && nums[mid] < target) {
//                if (nums[r] >= target) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            } else {
//                return -1;
//            }
//        }
//        return -1;
//    }
//
//
//    public static class Node {
//        private int data;
//        private Node leftNode;
//        private Node rightNode;
//
//        public Node(int data, Node leftNode, Node rightNode) {
//            this.data = data;
//            this.leftNode = leftNode;
//            this.rightNode = rightNode;
//        }
//
//        public int getData() {
//            return data;
//        }
//
//        public void setData(int data) {
//            this.data = data;
//        }
//
//        public Node getLeftNode() {
//            return leftNode;
//        }
//
//        public void setLeftNode(Node leftNode) {
//            this.leftNode = leftNode;
//        }
//
//        public Node getRightNode() {
//            return rightNode;
//        }
//
//        public void setRightNode(Node rightNode) {
//            this.rightNode = rightNode;
//        }
//    }
//
//    public static Node init() {//注意必须逆序建立，先建立子节点，再逆序往上建立，因为非叶子结点会使用到下面的节点，而初始化是按顺序初始化的，不逆序建立会报错
//        Node J = new Node(8, null, null);
//        Node H = new Node(4, null, null);
//        Node G = new Node(2, null, null);
//        Node F = new Node(7, null, J);
//        Node E = new Node(5, H, null);
//        Node D = new Node(1, null, G);
//        Node C = new Node(9, F, null);
//        Node B = new Node(3, D, E);
//        Node A = new Node(6, B, C);
//        return A;   //返回根节点
//    }
//
//    public static void theInOrderTraversal_Stack(Node root) {  //中序遍历
//        Stack<Node> stack = new Stack<Node>();
//        Node node = root;
//        while (node != null || stack.size() > 0) {
//            if (node != null) {
//                stack.push(node);   //直接压栈
//                node = node.getLeftNode();
//            } else {
//                node = stack.pop(); //出栈并访问
//                node = node.getRightNode();
//            }
//        }
//    }
//
//    public static boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//        ListNode p1 = head;
//        ListNode p2 = head;
//        while (p2.next != null && p2.next.next != null) {
//            p1 = p1.next;
//            p2 = p2.next.next;
//        }
//        ListNode p2Pre = null;
//        ListNode cur = p1.next;
//        ListNode nextNode;
//        while (cur != null) {
//            nextNode = cur.next;
//            cur.next = p2Pre;
//            p2Pre = cur;
//            cur = nextNode;
//        }
//        ListNode p2Head = p2Pre;
//        while (head != null && p2Head != null) {
//            if (head.val != p2Head.val) {
//                return false;
//            }
//            head = head.next;
//            p2Head = p2Head.next;
//        }
//        return head != null || p2Head != null;
//
//    }
//
//    public static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int x) {
//            val = x;
//        }
//    }
//
//    public int[] searchRange(int[] nums, int target) {
//        int[] result = {-1, -1};
//        int point = -1;
//        int l = 0, r = nums.length - 1;
//        int mid;
//        while (l < r) {
//            mid = (l + r) / 2;
//            if (nums[mid] == target) {
//                point = mid;
//                break;
//            } else if (nums[mid] > target) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        if (point == -1)
//            return result;
//        int lPoint = point;
//        for (int i = lPoint; lPoint >= 0; lPoint--) {
//            if (nums[i] != target) {
//                result[0] = i + 1;
//            }
//        }
//        for (int i = point; i < nums.length - 1; i++) {
//            if (nums[i] != nums[i + 1]) {
//                result[1] = i;
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 寻找到数据的一个低谷，数组满足以下条件
//     * 1 A1 > A2 && Ai-2 < Ai-1
//     * { 5,4,3,2,4,7}
//     * -1 代表不存在
//     *
//     * @param arr
//     * @return
//     */
//    private static int findLowEbb(int[] arr) {
//        if (arr == null || arr.length < 3)
//            return -1;
//        int l = 0;
//        int r = arr.length - 1;
//        while (l < r) {
//            int mid = (l + r) / 2;
//            if (arr[mid] > arr[mid + 1]) {
//                l = mid + 1;
//            } else {
//                r = mid;
//            }
//        }
//        return l;
//    }
//
//    /*访问记录为一个数组 [a,b,a,c,d,b,a,c,c,c,a] 寻找访问第二多的 可以看出来是a*/
//    public static String kTh(String[] products, int k) {
//        Map<String, Integer> map = new HashMap<>();
//        for (String s : products) {
//            map.put(s, map.getOrDefault(s, 0) + 1);
//        }
//        Queue<String> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
//
//        for (String s : map.keySet()) {
//            if (queue.size() < k) {
//                queue.add(s);
//            } else {
//                queue.add(s);
//                queue.poll();
//            }
//        }
//
//        return queue.poll();
//    }
//
//    /**
//     * 1 -> 2 -> 3 ->4 -> 5 -> null
//     *
//     * @param head
//     * @return
//     */
//    public static ListNode oddEvenList(ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//        ListNode odd = head;
//        ListNode temOdd = odd;
//
//        ListNode even = head.next;
//        ListNode temEven = even;
//
//        while (odd != null && odd.next != null) {
//            odd.next = odd.next.next;
//            odd = odd.next;
//        }
//
//        while (even != null && even.next != null) {
//            even.next = even.next.next;
//            even = even.next;
//        }
//        odd.next = temEven;
//        return temOdd;
//    }
//
//
//    public static boolean increasingTriplet(int[] nums) {
//        if (nums == null || nums.length < 3) {
//            return false;
//        }
//        for (int i = 0; i < nums.length - 2; i++) {
//
//            if (nums[i] < nums[i + 1] && nums[i + 1] < nums[i + 2]) {
//                return true;
//
//            }
//        }
//        return false;
//    }
//
//    public static int maxAreaOfIsland(int[][] grid) {
//        if (grid == null || grid.length == 0)
//            return 0;
//        int row = grid.length;
//        int col = grid[0].length;
//        int max = 0;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                max = Math.max(max, getMaxArea(grid, i, j, row, col));
//            }
//        }
//        return max;
//    }
//
//    public static int getMaxArea(int[][] grid, int row, int col, int maxRow, int maxCol) {
//        if (row < 0 || row >= maxRow || col < 0 || col >= maxCol || grid[row][col] == 0) {
//            return 0;
//        }
//        grid[col][row] = 0;
//        return 1 + getMaxArea(grid, row - 1, col, maxRow, maxCol) + getMaxArea(grid, row + 1, col, maxRow, maxCol) + getMaxArea(grid, row, col - 1, maxRow, maxCol) + getMaxArea(grid, row, col + 1, maxRow, maxCol);
//    }
//
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
//
//    private static HashMap<Integer, Integer> inorder_map = new HashMap<Integer, Integer>();
//    private static int[] pre_order;
//    private static int index = 0;
//
//    private static void buildTree(int[] preorder, int[] inorder) {
//        for (int i = 0; i < inorder.length; i++) {
//            inorder_map.put(inorder[i], i);
//        }
//        pre_order = preorder;
//        bulid(0, inorder.length - 1);
//    }
//
//    private static TreeNode bulid(int start, int end) {
//        if (start > end) {
//            return null;
//        }
//        int now = pre_order[index];
//        TreeNode root = new TreeNode(pre_order[index++]);
//        root.left = bulid(start, inorder_map.get(now) - 1);
//        root.right = bulid(inorder_map.get(now) + 1, end);
//        return root;
//    }
//
//
//    public static int hammingWeight(int n) {
//        int count = 0;
//        if (n == 0)
//            return count;
//        while (n != 0) {
//            int i = 0;
//            n = n & (n - 1);
//            count++;
//        }
//        return count;
//    }
//
//    private static int[] changeAddAndEven(int[] nums) {
//        int length = nums.length;
//        int before = 0;
//        int after = 0;
//        while (before < length && after < length) {
//            while (before < length) {
//                if (nums[before] % 2 == 0) {
//                    break;
//                }
//                before++;
//            }
//            after = before + 1;
//            while (after < length) {
//                if (nums[after] % 2 != 0) {
//                    break;
//                }
//                after++;
//            }
//            if (after < length && before < after) {
//                int tem = nums[after];
//                for (int i = after - 1; i >= before; i--) {
//                    nums[i + 1] = nums[i];
//                }
//                nums[before] = tem;
//            }
//        }
//        return nums;
//    }
//
//
//    public static void testPosition() {
//        int a = 2;
//        int b = 6;
//        int r = 1, base = a;
//        while (b != 0) {
//            if ((b & 1) != 0) {
//                r *= base;
//            }
//            base *= base;
//            b >>= 1;
//        }
//        System.out.println(a + "的" + b + "次方 = " + r);
//    }
//
//    public static void testFast() {
//        int a = 2;
//        int b = 6;
//        int i = 1;
//        int r = 1, base = a;
//        while (b != 0) {
//            if (b % 2 != 0) {
//                r *= base;
//            }
//            base *= base;
//            b /= 2;
//            i++;
//        }
//    }
//
//
//    public static int titleToNumber(String s) {
//        int i = s.length() - 1;
//        int point = 0;
//        for (int j = i; j >= 0; j--) {
//            point += Math.pow(26, i - j) * ((s.charAt(j) - 'A') + 1);
//        }
//        return point;
//    }
//
//    static int trailingZeroes(int n) {
//        int m = 0, sum = 0;
//        while (n / 5 != 0) {
//            sum = sum + n / 5;
//            n = n / 5;
//        }
//
//        return sum;
//    }
//
//    static int trailingZeroes1(int n) {
//        int sum = 0;
//        while (n >= 5) {
//            sum = sum + n / 5;
//            n = n / 5;
//        }
//        return sum;
//    }
//
//
//    public static void main(String[] args) {
//        int[] coins = {1};
//        int amount = 1;
//        coinChange(coins,amount);
//
//    }
//
//
//    public static int coinChange(int[] coins, int amount) {
//        if (amount == 0)
//            return 0;
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp,amount+1);
//        dp[0] = 0;
//        for(int i = 1;i<=amount;i++){
//            for(int j : coins){
//                if(i>=j){
//                    dp[i] = Math.min(dp[i],dp[i-j]+1);
//                }
//            }
//        }
//        return dp[amount] == amount+1 ? -1 : dp[amount];
//    }
//
//    public static String longestPalindrome(String s) {
//        if (s == null || s.equals("")) {
//            return "";
//        }
//        int length = s.length();
//        boolean[][] dp = new boolean[length][length];
//        int maxLong = 0;
//        String point = "";
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j <= i; j++) {
//                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
//                    dp[j][i] = true;
//                    if (i - j >= maxLong) {
//                        maxLong = i - j;
//                        point = s.substring(j, i + 1);
//                    }
//                }
//            }
//        }
//        return point;
//    }


}
