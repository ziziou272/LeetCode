package UnionFind;

public class LC200dfsReview {
    public int numIslands(char[][] grid) {
        //cc
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, boolean[][] visited, int x, int y){
        if(x <0 || x > grid.length - 1  || y < 0 || y > grid[0].length - 1 || grid[x][y] == '0') return;
        visited[x][y] = true;
        //必须要4个方向吗？只走右和下可以吗
        //不可以：
        // 000000
        // 000100
        // 111100
        dfs(grid, visited,x + 1, y);
        dfs(grid, visited,x - 1 , y);
        dfs(grid, visited, x, y - 1);
        dfs(grid, visited,x , y + 1);
    }
}
