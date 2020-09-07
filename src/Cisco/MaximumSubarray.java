package Cisco;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // corner
        if (nums == null || nums.length == 0) return 0;

        // init dp array
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        // fill
        int res = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, dp[i]);
        }

        // return
        return res;
    }
}
