package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        List<int[]>freq=new ArrayList<>();
        for (Map.Entry<Integer,Integer>entry:map.entrySet()){
            freq.add(new int[]{entry.getKey(),entry.getValue()});
        }

        int[]res=new int[k];
        quickSelect(freq,0,freq.size()-1,res,0,k);
        return res;
    }

    public void quickSelect(List<int[]>freq,int left,int right,int[]res,int resIndex,int k){
        if(left==right) {
            res[resIndex]=freq.get(left)[0];
            return;
        }

        int pivot=freq.get(left)[1];
        int begin=left-1,end=right+1;
        while (begin<end){
            do begin++; while (freq.get(begin)[1]>pivot);
            do end--; while (freq.get(end)[1]<pivot);
            if(begin<end){
                int[]temp=freq.get(begin);
                freq.set(begin,freq.get(end));
                freq.set(end,temp);
            }
        }

        int count = end - left + 1;
        if (k <= count) {
            quickSelect(freq, left, end, res, resIndex, k);
        } else {
            for (int p = left; p <= end; p++) {
                res[resIndex++] = freq.get(p)[0];
            }
            quickSelect(freq, end + 1, right, res, resIndex, k - count);
        }
    }

    public static void main(String[] args) {
        new TopKFrequent().topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
}
