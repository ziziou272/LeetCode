package DP;

import java.util.Arrays;

public class LC132dpMemoDfs {
    public int minCut(String s) {
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        boolean[][] dp = palindromeBox(s);
        return dfs(s, 0, s.length() - 1, memo, dp);
    }
    private int dfs(String s, int start, int end, int[] memo, boolean[][] dp){
        if(start == end) return 0;
        if(end == s.length() || start > end) return -1;
        if(memo[start] != -1) return memo[start];
        int min = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++){
            if(dp[start][i]){
                int cur = dfs(s, i + 1, end, memo, dp) + 1;
                min = Math.min(cur, min);
            }
        }
        memo[start] = min;
        return min;
    }

    /**
     *
     * this is the table to check from index i to j
     * if it can be formed a palindrome return true
     * o(n^2)
     *
     */
    public boolean[][] palindromeBox(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int len = s.length();
        for(int i = len - 1; i >= 0; i--){
            for(int j = i; j < len; j++){
                int size = j - i + 1;
                if(s.charAt(i) == s.charAt(j) && (size <= 2 || dp[i + 1][j - 1])){
                    dp[i][j] = true;
                }
            }
        }
        return dp;
    }
}
