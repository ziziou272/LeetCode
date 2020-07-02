package DP.KnapsackProblem;
/*
1 2 3 4       weight
2 4 4 5       value
capacity 5
1 2 3 4 5
2 4 6 8
*/
public class CompleteKnapsack {
    public int completeKnapsack(int[] w, int[] v, int cap){
        int[] dp = new int[cap + 1];
        dp[0] = 0;
        for(int i = 0; i < cap; i++){
            for(int j = 0; j < w.length; j++){
                int weight = w[j];
                int value = v[j];
                if(i - weight >= 0){
                    dp[i] = Math.max(dp[i - weight] + value, dp[i]);
                }
            }
        }
        return dp[cap];
    }
}
