package hot100.Backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * <p>
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * <p>
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        backtrace(candidates,target,0,new ArrayList<>(),0,res);
        return res;
    }

    public void backtrace(int[] candidates,int target, int curr, List<Integer>combination, int sum, List<List<Integer>>res){
        if(sum>target) return;

        if(sum==target){
            res.add(new ArrayList<>(combination));
            return;
        }


        for (int i = curr; i < candidates.length; i++) {
            combination.add(candidates[i]);
            sum+=candidates[i];
            backtrace(candidates,target,curr,combination,sum,res);
            combination.remove(combination.size()-1);
            sum-=candidates[i];
        }
    }
}
