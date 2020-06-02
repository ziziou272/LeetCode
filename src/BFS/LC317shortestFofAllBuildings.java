package BFS;

import java.util.LinkedList;
import java.util.Queue;
/*
0 empty
1 buildeing
2 obstacle


1 0 2 0 1
0 0 0 0 0
0 0 1 0 0



0 1 1 0 0 0
0 0 0 0 2 2
1 0 0 1 2 0

2 1 2 1 2 2 1

1 b 2 b 0 0 b


1 b b 2 3 3
2 1 2 3 x x
b 2 3 b x x


there are k buildings

start from each buildings to mark the distance


2 2 1
1 0 2
0 1 2

*/
class Solution317 {
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return -1;
        int row = grid.length, col = grid[0].length;
        int[][] count = new int[row][col];
        int[][] directions = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    //calculate distance from each 1
                    int dis = 1;
                    boolean[][] visited = new boolean[row][col];
                    queue.offer(i * col + j);
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        while(size-- > 0){
                            int index = queue.poll();
                            int ii = index / col;
                            int jj = index % col;
                            for(int[] direction : directions){
                                int iii = ii + direction[0];
                                int jjj = jj + direction[1];
                                if(iii >= 0 && iii < row && jjj < col && jjj >= 0 && grid[iii][jjj] == 0 && !visited[iii][jjj]){
                                    queue.offer(iii * col + jjj);
                                    count[iii][jjj] += dis;
                                    visited[iii][jjj] = true;
                                }
                            }
                        }
                        dis++;
                    }
                    for(int k = 0; k < row; k++){
                        for(int l = 0; l < col; l++){
                            if(grid[k][l] == 0 && !visited[k][l])
                                grid[k][l] = 2;
                        }
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        //find smallest
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0){
                    res = Math.min(res, count[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

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
