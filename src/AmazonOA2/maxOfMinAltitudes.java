package AmazonOA2;

public class maxOfMinAltitudes {
    private static int findMax(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return -1;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = matrix[0][0];
        for(int i = 1; i < col; i++){
            if(i - 1 != 0)
                dp[0][i] = Math.min(matrix[0][i], dp[0][i - 1]);
            else
                dp[0][i] = matrix[0][i];
        }
        for(int i = 1; i < row; i++){
            if(i - 1 != 0)
                dp[i][0] = Math.min(matrix[i][0], dp[i - 1][0]);
            else
                dp[i][0] = matrix[i][0];
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                //if(i == row - 1 && j == col - 1)
                    //dp[i][j]= Math.max(dp[i -1][j], dp[i][j - 1]);
                //else
                    dp[i][j] = Math.min(Math.max(dp[i -1][j], dp[i][j - 1]), matrix[i][j]);

            }
        }
        return dp[row - 1][col - 1];
    }
    public static void main(String[] args) {
        int[][] grid1 = new int[][] { {5, 1}};                        // 4
        int[][] grid2 = new int[][] { };                  // 4
        int[][] grid3 = new int[][] { {1, 9, 9}, {9, 9, 9}, {9, 9, 9} };       // 1 (if the first entry is not considered)
        int[][] grid4 = new int[][] { {10, 22, 3}, {12, 11, 9}, {1, 2, 8} };    // 8 (same reason)
        int[][] grid5 = new int[][] { {20, 20, 3}, {20, 3, 20}, {3, 20, 20} }; // 3
        int[][] grid6 = new int[][] { {6, 7, 1, 2, 3}, {4, 5, 8, 13, 7}, {2, 13, 2, 10, 100} }; // 3
        System.out.println("grid1: Expected: 4, Actual: " + findMax(grid1));
        System.out.println("grid2: Expected: 4, Actual: " + findMax(grid2));
        System.out.println("grid3: Expected: 1, Actual: " + findMax(grid3) + " (if the first entry is not considered)");
        System.out.println("grid4: Expected: 8, Actual: " + findMax(grid4) + " (same reason)");
        System.out.println("grid5: Expected: 3, Actual: " + findMax(grid5));
        System.out.println("grid6: Expected: 5, Actual: " + findMax(grid6));
    }
}
