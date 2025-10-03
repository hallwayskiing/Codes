package hot100.Hash;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();

        for(String str:strs){
            char[]chars=str.toCharArray();
            Arrays.sort(chars);
            String sorted=new String(chars);

            if(map.containsKey(sorted)){
                map.get(sorted).add(str);
            }
            else {
                List<String>newList=new ArrayList<>();
                newList.add(str);
                map.put(sorted,newList);
            }
        }

        return map.values().stream().toList();
    }
}
