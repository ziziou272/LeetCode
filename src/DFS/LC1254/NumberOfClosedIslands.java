package DFS.LC1254;

public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        //mark non totally island to 1
        int row = grid.length, col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0 && (i == 0 || j == 0 || i == row - 1 || j == col - 1)){
                    mark(i, j, grid);
                }
            }
        }
        //count
        int count = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0){
                    mark(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void mark(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }
        if(grid[i][j] == 1) return;
        grid[i][j] = 1;
        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0, -1}};
        for(int[] direction : directions){
            int ii = i + direction[0];
            int jj = j + direction[1];
            mark(ii, jj, grid);
        }
    }
}
/*
1 1 1 1 1
1 1 0 0 1
1 0 1 1 1
1 1 1 1 1


1. mark all non totally island to 1
2. count totally island
*/