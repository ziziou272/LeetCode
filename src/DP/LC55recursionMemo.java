package DP;

public class LC55recursionMemo {
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        if(nums[0] == 0) return false;
        Boolean[] memo = new Boolean[nums.length];
        return dfs(nums, memo, 0);
    }
    private boolean dfs(int[] nums, Boolean[] memo, int index){
        //base case
        if(index >= memo.length - 1) return true;
        if(memo[index] != null) return memo[index];
        int distance = nums[index];
        for(int i = 1; i <= distance; i++){
            if(dfs(nums, memo, index + i)){
                memo[index] = true;
                return true;
            }
        }
        memo[index] = false;
        return false;
    }
}
