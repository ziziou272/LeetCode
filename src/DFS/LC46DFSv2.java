package DFS;

import java.util.ArrayList;
import java.util.List;

public class LC46DFSv2 {//根据上课的思路 比较clean
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        dfs(res, nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] nums, int index){
        if(index == nums.length - 1){
            List<Integer> level = new ArrayList<>();
            for(int num : nums){
                level.add(num);
            }
            res.add(level);
            return;
        }
        for(int i = index; i < nums.length; i++){
            swap(nums, i, index);
            dfs(res, nums, index + 1);
            swap(nums, i, index);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
}
