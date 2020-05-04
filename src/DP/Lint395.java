package DP;

public class Lint395 {
}
class DFSMemo{
    /**
     * @param values: a vector of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        return dfs(values, 0, new Integer[values.length]) >= 0;
    }
    private int dfs(int[] values, int index, Integer[] memo){
        if(index >= values.length)
            return 0;
        if(memo[index] != null)
            return memo[index];
        int one = values[index] - dfs(values, index + 1, memo);
        int two = Integer.MIN_VALUE;
        if(index + 1 < values.length)
            two = values[index] + values[index + 1] - dfs(values, index + 2, memo);
        memo[index] = Math.max(one, two);
        return memo[index];
    }
}
class dp{
    public boolean firstWillWin(int[] values) {
        // write your code here
        //cc
        int[] dp = new int[values.length + 2];
        for(int i = values.length - 1; i >= 0; i--){
            int one = values[i] - dp[i + 1];
            int two = Integer.MIN_VALUE;
            if(i + 1 < values.length)
                two = values[i] + values[i + 1] - dp[i + 2];
            dp[i] = Math.max(one, two);
        }
        return dp[0] >= 0;
    }
}
