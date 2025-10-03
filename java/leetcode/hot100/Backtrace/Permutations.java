package hot100.Backtrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>order=new ArrayList<>();

        for (int num:nums) order.add(num); //original order

        backtrace(0,nums.length,order,res);

        return res;
    }

    public void backtrace(int curr,int n,List<Integer>order,List<List<Integer>>res){
        if(curr==n) res.add(new ArrayList<>(order));

        for (int i=curr;i<n;i++){
            Collections.swap(order,curr,i);
            backtrace(i,n,order,res);
            Collections.swap(order,curr,i);
        }
    }

}
