package test.Thread;


public class Main {
    public static void main(String[] args) {
        mySqrt(8);
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums == null)
            return 0;
        int length = nums.length;
        if(length == 0)
            return 0;
        int[] s = new int[length];
        s[0] = 1;
        for(int i=0;i<length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    s[i] = Math.max(s[i],s[j]+1);
                }
            }
            if (s[i] == 0){
                s[i] = 1;
            }
        }
        int max = 0;
        for(int i : s){
            if(i>max){
                max = i;
            }
        }
        return max;
    }


    public static boolean canJump(int[] nums) {
        if(nums == null)
            return false;
        int length = nums.length;
        if(length == 0)
            return false;
        int[] s = new int[length];
        s[0] = nums[0];
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0 && s[i] == 0){
                return false;
            }
            int tem = nums[i];
            for(int j=i;j<=i+nums[i] && j<length;j++){
                s[j] = tem--;
            }
        }
        return true;
    }


    public static int mySqrt(int x) {
        int l = 0 , r = x ;
        int mid ;
        while(l<r){
            mid = (l+r) / 2;
            if(mid * mid == x){
                return mid;
            }else if(mid * mid > x){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return  l * l < x ? l : l -1;
    }
}
