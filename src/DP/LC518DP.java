package DP;

public class LC518DP {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        if(coins == null) return 0;
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j >= coins[i]){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
