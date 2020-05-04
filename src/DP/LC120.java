package DP;

import java.util.List;

public class LC120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        Integer[][] dp = new Integer [m][n];
        return minimumTotal(triangle, dp, 0, 0);
    }
    private int minimumTotal(List<List<Integer>> triangle, Integer[][] dp, int level, int index){
        if(level == triangle.size()) return 0;
        if(dp[level][index] != null) return dp[level][index];
        int cur = triangle.get(level).get(index);
        int left = minimumTotal(triangle, dp, level + 1, index);
        int right = minimumTotal(triangle, dp, level + 1, index + 1);
        dp[level][index] = Math.min(left, right) + cur;
        return dp[level][index];
    }
}
