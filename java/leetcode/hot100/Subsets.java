package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            List<Integer>output=new ArrayList<>();
            output.add(nums[i]);
            backtrace(nums,i,output,res);
        }
        return res;
    }

    public void backtrace(int[]nums,int first,List<Integer>output,List<List<Integer>>res){
        res.add(new ArrayList<>(output));
        for (int i = first+1; i < nums.length; i++) {
            output.add(nums[i]);
            backtrace(nums,i,output,res);
            output.remove(output.size()-1);
        }
    }
}
