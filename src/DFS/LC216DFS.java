package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC216DFS {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(k == 0 || n == 0 || k > n)
            return res;
        int [] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        combinationSum3(nums, k , n, 0, 0, res, new ArrayList<>());
        return res;
    }

    private void combinationSum3(int [] nums, int k, int n, int sum, int index, List<List<Integer>> res, List<Integer> level){
        if(n > sum || level.size()> k)
            return;
        if(level.size() == k && n == sum){
            res.add(new ArrayList<>(level));
            return;
        }

        for(int i = index; i < nums.length; i++){
            level.add(nums[i]);
            sum += nums[i];
            combinationSum3(nums, k, n, sum, i + 1, res, level);
            level.remove(level.size() - 1);
            sum -= nums[i];
        }
    }
}
