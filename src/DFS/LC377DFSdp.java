package DFS;

import java.util.Arrays;

public class LC377DFSdp {
    public int combinationSum4(int[] nums, int target) {
        //cc
        if(nums == null || nums.length == 0)
            return 0;
        int [] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return dfs(nums, target, dp);
    }
    private int dfs(int[] nums, int target, int [] dp){
        if(dp[target] != -1){
            return dp[target];
        }
        if(target == 0)
            return 1;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(target >= nums[i]){
                res += dfs(nums, target - nums[i], dp);
            }
        }
        dp[target] = res;
        return dp[target];
    }
}
