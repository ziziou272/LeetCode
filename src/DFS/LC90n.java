package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//dfs solution 1 分n叉
public class LC90n {
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
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }
            Integer temp = nums[i];
            level.add(temp);
            subsetsWithDup(nums, i + 1, res, level);
            level.remove(temp);

        }
    }
}

