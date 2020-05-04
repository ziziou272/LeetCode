package DP;

import java.util.Arrays;

public class LC64dfsMemo {
    public static void main(String[] args){
        LC64dfsMemoSolution solution = new LC64dfsMemoSolution();
        solution.minPathSum(new int[][]{{1,3,9,1,1,1},{1,5,1,1,100,1},{4,2,1,99,99,99}});
    }

}
class LC64dfsMemoSolution{
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] memo = new int[row][col];
        for(int i = 0; i < row; i++)
            Arrays.fill(memo[i], -1);
        return dfs(grid, 0, 0, row, col, new int[row][col]);
    }
    private int dfs(int[][] grid, int i, int j, int row, int col, int[][] memo){
        if(memo[i][j] != -1) return memo[i][j];
        if(i == row - 1 && j == col - 1){
            memo[i][j] = grid[i][j];
            return grid[i][j];
        }
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(i + 1 < row)
            down = dfs(grid, i + 1, j, row, col, memo);
        if(j + 1 < col)
            right = dfs(grid, i, j + 1, row, col, memo);
        memo[i][j] = Math.min(down, right) + grid[i][j];
        return memo[i][j];
    }
}
