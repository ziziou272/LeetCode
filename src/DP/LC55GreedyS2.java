package DP;
//for loop里边的max会和i每次更新
public class LC55GreedyS2 {
    public boolean canJump(int[] nums) {
        //corner case clarify
        if(nums == null || nums.length < 2) return true;
        int size = nums.length;
        int max = 0;
        for(int i = 0; i <= max; i++){
            if(nums[i] + i >= size -1) return true;
            max = Math.max(nums[i] + i, max);
        }
        return false;
    }
}
