package DP.KnapsackProblem;

public class LC416knapsackSimliar {
}
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums)
            sum += num;
        if(sum % 2 != 0)
            return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = sum; j >= 1; j--) {
                if (j < num)
                    break;
                if (j >= num && dp[j - num])
                    dp[j] = true;
            }
        }
        return dp[sum];

    }
}