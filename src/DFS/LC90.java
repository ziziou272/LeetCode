package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//dfs solution 1 分两个叉
public class LC90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDup(nums,0,res,new ArrayList<>());
        return res;
    }

    private void subsetsWithDup(int [] nums, int index, List<List<Integer>> res, List<Integer> level){
        if(index == nums.length){
            res.add(new ArrayList<>(level));
            return;
        }
        Integer temp = nums[index];
        level.add(temp);
        subsetsWithDup(nums,index + 1,res,level);
        level.remove(temp);
        while(index + 1 < nums.length && nums[index] == nums[index + 1]){
            index++;
        }
        subsetsWithDup(nums,index + 1,res,level);

    }
}
