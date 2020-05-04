package DP;

public class LC70DFSdp {
    public int climbStairs(int n) {
        if(n == 0)
            return 0;
        int [] dp = new int[n + 1];
        climbStairs(n, dp);
        return dp[n];
    }
    private int climbStairs(int n, int [] dp){
        if(dp[n] != 0)
            return dp[n];
        if(n <= 2) {
            dp[n] = n;
            return n;
        }
        int res = 0;
        res += climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
        dp[n] = res;
        return res;
    }
}
