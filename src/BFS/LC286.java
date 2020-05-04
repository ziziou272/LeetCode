package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC286 {
    private static final int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public void wallsAndGates(int[][] rooms) {
        //cc
        if(rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) return;
        Queue<Integer> myQ = new LinkedList<>();
        int row = rooms.length;
        int col = rooms[0].length;
        //find gate and put to q
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(rooms[i][j] == 0)
                    myQ.offer(i * col + j);
            }
        }
        int level = 0;
        while(!myQ.isEmpty()){
            int size = myQ.size();
            while(size-- > 0){
                int index = myQ.poll();
                int i = index / col;
                int j = index % col;
                for(int[] direct : directions){
                    int ii = i + direct[0];
                    int jj = j + direct[1];
                    if(ii >= 0 && ii < row && jj < col && jj >=0 && rooms[ii][jj] == Integer.MAX_VALUE){
                        myQ.offer(ii * col + jj);
                        rooms[ii][jj] = level + 1;
                    }
                }
            }
            level++;
        }
    }
}
class DFSSolution{
    public void wallsAndGates(int[][] rooms) {
        // corner
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        // dfs
        int rows = rooms.length, cols = rooms[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == 0) {
                    dfs(rooms, row, col, visited, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int row, int col, boolean[][] visited, int distance) {
        // base case
        if (!valid(rooms, row, col) || visited[row][col] || rooms[row][col] == -1 || distance > rooms[row][col]) return;

        // mark visited as true
        visited[row][col] = true;


        // fill in curr with min distance (when the curr grid is not 0)
        if (rooms[row][col] != 0) rooms[row][col] = Math.min(rooms[row][col], distance);

        // dfs visit neighbors
        dfs(rooms, row - 1, col, visited, distance + 1);
        dfs(rooms, row + 1, col, visited, distance + 1);
        dfs(rooms, row, col - 1, visited, distance + 1);
        dfs(rooms, row, col + 1, visited, distance + 1);
        visited[row][col] = false;
    }

    private boolean valid(int[][] rooms, int row, int col) {
        if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length) return false;
        return true;
    }
}
class DFSSolutionBetter{
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) dfs(i, j, 0, rooms);
            }
        }
    }

    private void dfs(int i, int j, int count, int[][] rooms) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || count > rooms[i][j]) return;

        rooms[i][j] = count;

        dfs(i + 1, j, count + 1, rooms);
        dfs(i - 1, j, count + 1, rooms);
        dfs(i, j + 1, count + 1, rooms);
        dfs(i, j - 1, count + 1, rooms);
    }
}
