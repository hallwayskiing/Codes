package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        backtrace(candidates,target,0,0,new ArrayList<>(),res);
        return res;
    }

    public void backtrace(int[]candidates,int target,int curr,int sum,List<Integer>combination,List<List<Integer>>res){
        if(sum>target)
            return;
        if(sum==target){
            res.add(new ArrayList<>(combination));
            return;
        }

        for (int i=curr;i<candidates.length;i++){
            int candidate=candidates[i];
            combination.add(candidate);
            backtrace(candidates,target,i,sum+candidate,combination,res);
            combination.remove(combination.size()-1);
        }
    }
}
