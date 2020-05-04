package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution78DFS1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> listSubset = new ArrayList();
        if (nums == null) return res;
        dfs(nums, 0, listSubset, res);
        return res;
    }

    void dfs(int[] nums, int index, List<Integer> listSubset, List<List<Integer>> res) {
        res.add(new ArrayList(listSubset));
        for (int i = index; i < nums.length; i++) {
            listSubset.add(nums[i]);
            dfs(nums, i + 1, listSubset, res);
            listSubset.remove(listSubset.size() - 1);
        }
    }
}
