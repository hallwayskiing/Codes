package hot100;

import java.util.PriorityQueue;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class FindKthLargest {
    //计数排序
    public int findKthLargest(int[] nums, int k) {
        int offset=10000;
        int[]arr=new int[20001];
        for (int num:nums){
            arr[num+offset]++;
        }

        for (int i = 20000; i >=0 ; i--) {
            k-=arr[i];
            if(k<=0)
                return i-offset;
        }
        return 0;
    }

    //快速排序变形
    public int findKthLargestII(int[]nums,int k){
        int n=nums.length;
        return quickSelect(nums,0,n-1,n-k);
    }

    public int quickSelect(int[]nums,int left,int right,int k){
        if(left==right)
            return nums[k];
        int pivot=nums[left];
        int begin=left-1,end=right+1;
        while (begin<end){
            do begin++; while (nums[begin]<pivot);
            do end--; while (nums[end]>pivot);
            if(begin<end){
                int temp=nums[begin];
                nums[begin]=nums[end];
                nums[end]=temp;
            }
        }
        if(k<=end)
            return quickSelect(nums,left,end,k);
        else
            return quickSelect(nums,end+1,right,k);
    }

    public static void main(String[] args) {
        new FindKthLargest().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4);
    }
}
