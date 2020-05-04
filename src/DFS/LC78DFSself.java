package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC78DFSself {//和dfs1类似
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        res.add(new ArrayList<>());
        List<Integer> level = new ArrayList<>();
        dfs(nums, 0, level, res);
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> level, List<List<Integer>> res){
        for(int j = i; j < nums.length; j++){
            level.add(nums[j]);
            res.add(new ArrayList<>(level));
            dfs(nums, j + 1, level, res);
            level.remove(level.size() - 1);
        }
    }
}
