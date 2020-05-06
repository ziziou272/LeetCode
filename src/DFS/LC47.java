package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC47 {
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
class solutionCleanFast{
    // 2^n(length of array), 2^n
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res= new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            //deal duplicate
            if(used[i] || (i - 1 >= 0 && nums[i] == nums[i - 1] && !used[i - 1])){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(res, path, nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
