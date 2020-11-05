package DP;

import java.util.Arrays;

public class LC674LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] lenLCIS = new int[nums.length];
        Arrays.fill(lenLCIS, 1);
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] < nums[i]){
                lenLCIS[i] += lenLCIS[i - 1];
            }
            max = Math.max(max, lenLCIS[i]);
        }
        return max;
    }
}

/*
1 3 5 4 7
1 2 3 1 2

*/