package DFS;

import java.util.HashSet;

public class LC694 {
    public int numDistinctIslands(int[][] grid) {
        //cc
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;
        int row = grid.length, col = grid[0].length;
        HashSet<String> set = new HashSet<>();
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    StringBuilder path = new StringBuilder();
                    dfs(grid, i , j, visited, path,'s');
                    set.add(path.toString());
                }
            }
        }
        return set.size();

    }
    private void dfs(int[][] grid, int i, int j, boolean[][] visited, StringBuilder path, char direct){
        //base case
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) return;
        //set visited
        visited[i][j] = true;
        //to be used to check same
        path.append(direct);

        dfs(grid, i, j + 1, visited, path, 'r');
        dfs(grid, i + 1, j, visited, path, 'd');
        dfs(grid, i, j - 1, visited, path, 'l');
        dfs(grid, i - 1, j, visited, path,'u');
        path.append('x');
    }
}