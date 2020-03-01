package test.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums ={3,2,1};
        doQuickSort(0,2,nums);
    }
    public static void doQuickSort(int l , int r, int[] nums) {
        if (l>=r){
            return;
        }
        int point = nums[l];
        int mid = 0;
        int tem ;
        int i = l+1;
        int j = r;
        if (i < j) {
            while (i < j && nums[j] > point)
                j--;
            while (i< j && nums[i]<point)
                i++;
            if (i<j){
                tem = nums[i];
                nums[i] = nums[j];
                nums[j] = tem;
            }
            mid = i;
            nums[l] = nums[i];
            nums[i] = point;
        }
        doQuickSort(l,mid-1,nums);
        doQuickSort(mid+1,r,nums);
    }
}

