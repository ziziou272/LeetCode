package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC47swap {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        dfs(nums, res, 0);
        return res;
    }
    private void dfs(int[] nums, List<List<Integer>> res, int level){
        //base case
        if(level == nums.length - 1){
            List<Integer> cur = new ArrayList<>();
            for(int num : nums){
                cur.add(num);
            }
            res.add(cur);
            return;
        }
        HashSet<Integer> mySet = new HashSet<>();
        for(int i = level; i < nums.length; i++){
            if(mySet.contains(nums[i]))
                continue;
            mySet.add(nums[i]);
            swap(nums, level, i);
            dfs(nums, res, level + 1);
            swap(nums, level, i);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
}
