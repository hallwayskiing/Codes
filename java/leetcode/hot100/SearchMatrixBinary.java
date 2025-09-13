package hot100;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class SearchMatrixBinary {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length,n=matrix[0].length;
        int[]firstCol=new int[m];
        for (int i = 0; i < m; i++) {
            firstCol[i]=matrix[i][0];
        }
        int row=getRow(firstCol,target,0,m-1);
        if(row==-1)
            return false;
        return search(matrix[row],target,0,n-1);

    }

    public int getRow(int[]nums,int target,int begin,int end){
        if(begin>=end)
            return nums[begin]<=target?begin:begin-1;

        int mid=(begin+end)/2;
        if(nums[mid]==target)
            return mid;
        else if(nums[mid]>target)
            return getRow(nums,target,begin,mid-1);
        else return getRow(nums,target,mid+1,end);
    }

    public boolean search(int[]nums,int target,int begin,int end){
        if(begin>end)
            return false;

        int mid=(begin+end)/2;
        if(nums[mid]==target)
            return true;
        else if(nums[mid]>target)
            return search(nums,target,begin,mid-1);
        else return search(nums,target,mid+1,end);
    }
}
