package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
//dfs use hashset
public class LC90HashSet {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums,0,res,new ArrayList<>());
        return res;
    }
    private void subsetsWithDup(int [] nums,int index, List<List<Integer>> res, List<Integer> level){
        res.add(new ArrayList<>(level));
        HashSet<Integer> mySet = new HashSet<>();
        for(int i = index; i < nums.length; i++){
            if(mySet.contains(nums[i]))
                continue;
            else
                mySet.add(nums[i]);
            level.add(nums[i]);
            subsetsWithDup(nums, i + 1, res, level);
            //back tracking
            level.remove(level.size() - 1);
        }
    }
}
