package DP;

public class LC304 {

}
class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
        int row = matrix.length;
        int col = matrix[0].length;
        dp = new int[row + 1][col + 1];
        for(int i = 0; i <= row; i++){
            for(int j = 0; j <= col; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(dp == null || dp.length == 0 || dp[0] == null || dp[0].length == 0) return 0;
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1 - 1 + 1] - dp[row1 - 1 + 1][col2 + 1] + dp[row1 - 1 + 1] [col1 -1 + 1];
    }
}