package DP;

import java.util.Arrays;

public class LC132dfsMemo {
    public int minCut(String s) {
        int[][] memo = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(s, 0, s.length() - 1, memo);
    }
    private int dfs(String s, int start, int end, int[][] memo){
        if(start == end) return 0;
        if(end == s.length() || start > end) return -1;
        if(memo[start][end] != -1) return memo[start][end];
        int min = Integer.MAX_VALUE;
        for(int i = start; i <= end; i++){
            if(isPali(s, start, i)){
                int cur = dfs(s, i + 1, end, memo) + 1;
                min = Math.min(cur, min);
            }
        }
        memo[start][end] = min;
        return min;
    }

    private boolean isPali(String s, int start, int end){
        if(start == end) return true;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
/*
    0 1 2 3 4 5
    a b c d a d

          a                                                ab  abc
        b             bc bcb bcba bcbad
      c          cb cba cbad
    d da dad
  a ad
d

5,5  4,5    3,5
1     2
*/
