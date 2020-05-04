package DP;

public class LC221 {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return max;
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length;col++){
                if(matrix[row][col] == '0' || row == 0 || col == 0)
                {
                    dp[row][col] = matrix[row][col] - '0';
                }
                else
                {
                    dp[row][col] = Math.min(Math.min(dp[row - 1][col],dp[row][col - 1]),dp[row - 1][col - 1]) + 1;
                }
                    max = Math.max(dp[row][col], max);
            }
        }
        return max * max;
    }
}
