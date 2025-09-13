package hot100;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int index=search(nums,target,0,nums.length-1);
        if(index==-1)
            return new int[]{-1,-1};

        int left=searchBound(nums,target,0,index,true);
        int right=searchBound(nums,target,index,nums.length-1,false)-1;

        return new int[]{left,right};
    }
    public int search(int[]nums,int target,int begin,int end){
        if(begin>end)
            return -1;

        int mid=(begin+end)/2;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]>target)
            return search(nums,target,begin,mid-1);
        else return search(nums,target,mid+1,end);
    }

    public int searchBound(int[]nums,int target,int begin,int end,boolean left){
        if(begin>end)
            return begin;

        int mid=(begin+end)/2;
        if(nums[mid]==target)
            if(left) {
                return searchBound(nums, target, begin, mid - 1, left);
            }
            else {
                return searchBound(nums,target,mid+1,end,left);
            }
        else if(nums[mid]>target)
            return searchBound(nums,target,begin,mid-1,left);
        else return searchBound(nums,target,mid+1,end,left);
    }

    public int[] searchRangeII(int[]nums,int target){
        int n=nums.length;
        int begin=0,end=n-1;
        int searchIndex=-1;
        while (begin<=end){
            int mid=(begin+end)/2;
            if(nums[mid]==target){
                searchIndex=mid;
                break;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else {
                begin=mid+1;
            }
        }

        if(searchIndex==-1)
            return new int[]{-1,-1};

        int leftBound=0;
        begin=0;
        end=searchIndex;
        while (begin<=end){
            int mid=(begin+end)/2;
            if(nums[mid]==target){
                leftBound=mid;
                end=mid-1;
            }
            else {
                begin=mid+1;
            }
        }

        int rightBound=0;
        begin=searchIndex;
        end=n-1;
        while (begin<=end){
            int mid=(begin+end)/2;
            if(nums[mid]==target){
                rightBound=mid;
                begin=mid+1;
            }
            else {
                end=mid-1;
            }
        }

        return new int[]{leftBound,rightBound};
    }
}
