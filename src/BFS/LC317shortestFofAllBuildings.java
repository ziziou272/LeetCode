package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC317shortestFofAllBuildings {
    private static final int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return -1;
        Queue<Integer> myQ = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int[][] cost = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    myQ.offer(i * col + j);
                    bfs(grid, cost, myQ);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0 && min > cost[i][j])
                    min = cost[i][j];
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private void bfs(int[][] grid, int[][] cost, Queue<Integer> myQ){
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int distance = 0;
        while (!myQ.isEmpty()){
            int size = myQ.size();
            while(size-- > 0){
                int index = myQ.poll();
                int i = index / col;
                int j = index % col;
                cost[i][j] += distance;
                for(int[] direct : directions){
                    int ii = i + direct[0];
                    int jj = j + direct[1];
                    if(ii >= 0 && ii < row && jj >= 0 && jj < col && grid[ii][jj] == 0 && !visited[ii][jj]){
                        myQ.offer(ii * col + jj);
                        visited[ii][jj] = true;
                    }
                }
            }
            distance++;
        }
        //check if there any 0 can't be accessed
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0 && !visited[i][j])
                    grid[i][j] = 2;
            }
        }
    }
}
