package DP;

public class LC55GreedyS1 {//和课上方法2一样
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length <= 1) return true;
        int size = nums.length;
        int max = nums[0];
        for(int i = 0; i < size; i++){
            if(max < i) return false;
            if(nums[i] + i >= size - 1)
                return true;
            //以下也可以写成
            //max = Math.max(nums[i] + i, max);
            if(nums[i] + i > max)
                max = nums[i] + i;
        }
        return true;
    }
}

/**
 * 2020/04/25 greedy
 */
class SolutionLC55 {
    public boolean canJump(int[] nums) {
        int farset = 0;
        for(int i = 0; i < nums.length; i++){
            if(farset < i)
                return false;
            if(farset >= nums.length - 1)
                return true;
            farset = Math.max(farset, nums[i] + i);
        }
        return farset >= nums.length - 1;
    }
}
/*
farset
3 2 1 0 1 4
3 2 3 3
*/
