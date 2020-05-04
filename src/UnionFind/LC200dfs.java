package UnionFind;

public class LC200dfs {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;
        int max = 0;
        int row = grid.length, col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    max += 1;
                    dfs(grid, i, j);
                }
            }
        }
        return max;
    }

    private void dfs(char[][] grid, int i, int j){
        int row = grid.length, col = grid[0].length;
        if(i < 0 || i >= row || j >= col || j < 0 || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
