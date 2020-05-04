package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution78DFS2 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> listSubset = new ArrayList();
        if (nums == null) return res;
        dfs(nums, 0, listSubset, res);
        return res;
    }

    void dfs(int[] nums, int index, List<Integer> listSubset, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList(listSubset));
            return;
        }

        listSubset.add(nums[index]);
        dfs(nums, index + 1, listSubset, res);
        listSubset.remove(listSubset.size() - 1);

        dfs(nums, index + 1, listSubset, res);
    }
}
