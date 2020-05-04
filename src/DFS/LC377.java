package DFS;
//dfs time limit exceed
import java.util.ArrayList;
import java.util.List;

public class LC377 {
    public int combinationSum4(int[] nums, int target) {
        //cc
        int [] count = new int[]{0};
        if(nums == null || nums.length == 0)
            return count[0];
        combinationSum4(nums, target, count);
        return count[0];
    }

    private void combinationSum4(int[] nums, int target, int [] count){
        if(target < 0)
            return;
        if(target == 0){
            count[0] += 1;
            return;
        }
        for(int i = 0; i < nums.length; i++){
            target -= nums[i];
            combinationSum4(nums, target, count);
            target += nums[i];
        }
    }
}
