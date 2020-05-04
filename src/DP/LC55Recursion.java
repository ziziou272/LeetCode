package DP;
//time limit exceeded
public class LC55Recursion {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        return canJump(nums, 0);
    }
    private boolean canJump(int [] nums, int index){
        if (nums[index] >= nums.length - index - 1) return true;
        int jump = nums[index] + index;
        for(int i = index + 1;i <= jump; i++)
            if(canJump(nums, i))
                return true;
        return false;
    }
}
