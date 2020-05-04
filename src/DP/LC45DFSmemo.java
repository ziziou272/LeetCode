package DP;

import java.util.Arrays;

public class LC45DFSmemo {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, memo, 0);
    }
    private int dfs(int[] nums, int[] memo, int index){
        if(index >= nums.length - 1) return 0;
        if(memo[index] != -1) return memo[index];
        int distance = nums[index];
        int min = nums.length + 1;
        for(int i = 1; i <= distance; i++){
            min = Math.min(min, dfs(nums, memo, index + i) + 1);
        }
        memo[index] = min;
        return min;
    }
    /*



0 1 2   3 4
2 3 0   1 4
    max                0
                1       2
              2 3 4     3
            0            4




 0 1 2 3 4
 2 3 1 1 4
                    start
                 1           2
             2  3  4         1
           3    4            1
        4                    4





*/
}
