package DP;

public class LC329 {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return 0;
        int row = matrix.length, col = matrix[0].length;
        int[][]dp = new int[row][col];
        int max = 0;
        int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(dp[i][j] == 0){
                    helper(matrix, dp, i, j, directions);
                    max = Math.max(max, dp[i][j]);
                }

            }
        }
        return max;
    }

    private int helper(int[][] matrix, int[][] dp, int i, int j, int[][] directions){
        if(dp[i][j] != 0)
            return dp[i][j];
        int row = matrix.length, col = matrix[0].length;
        int max = 1;
        for(int[] direction : directions){
            int ii = i + direction[0];
            int jj = j + direction[1];
            if(ii >= 0 && jj >= 0 && ii < row && jj < col){
                if(matrix[i][j] > matrix[ii][jj]){
                    max = Math.max(max, helper(matrix, dp, ii, jj, directions)+1);
                }
            }
        }
        dp[i][j] = max;
        return max;

    }
}
