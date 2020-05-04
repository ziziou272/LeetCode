package DP;

public class LC62 {
    public int uniquePaths(int m, int n) {
        //todo:improve space usage
        if (m < 1  || n < 1 )
            return 0;
        int [][] dp = new int[n][m];
        for(int row = 0; row < n; row++){
            for(int col = 0; col < m; col++){
                if(row == 0 && col == 0)
                    dp[0][0] = 1;
                else if(row == 0){
                    dp[row][col] = dp[row][col - 1];
                }
                else if(col == 0){
                    dp[row][col] = dp[row - 1][col];
                }
                else{
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
            }
        }
        return dp[n][m];
    }
}
