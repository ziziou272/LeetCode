package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
*/
public class LC417pacificAtlantic {//o(2 * m * n)
    private static final int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null) return res;
        int row = matrix.length, col = matrix[0].length;
        boolean[][] canFlowP = new boolean[row][col];
        boolean[][] canFlowA = new boolean[row][col];
        Queue<Integer> myQ = new LinkedList<>();
        //check pacific
        //add edge
        for(int i = 0, j = 0; j < col; j++){
            myQ.offer(i * col + j);
            canFlowP[i][j] = true;
            //visited[i][j]= true;
        }
        for(int i = 1, j = 0; i< row; i++) {
            myQ.offer(i * col + j);
            canFlowP[i][j] = true;
        }
        bfs(matrix, canFlowP,myQ);
        //check atlantic
        //add edge
        for(int i = row - 1, j = 0; j < col; j++){
            myQ.offer(i * col + j);
            canFlowA[i][j] = true;
        }
        for(int j = col - 1, i = 0; i < row - 1; i++){
            myQ.offer(i * col + j);
            canFlowA[i][j] = true;
        }
        bfs(matrix, canFlowA, myQ);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(canFlowA[i][j] && canFlowP[i][j]){
                    List<Integer> level = new ArrayList<>();
                    level.add(i);
                    level.add(j);
                    res.add(new ArrayList<>(level));
                }
            }
        }
        return res;
    }
    private void bfs(int[][] matrix, boolean[][] canFlow, Queue<Integer> myQ){
        int row = matrix.length, col = matrix[0].length;
        while (!myQ.isEmpty()){
                int index = myQ.poll();
                int i = index / col;
                int j = index % col;
                int val = matrix[i][j];
                for(int[] direct : directions){
                    int ii = i + direct[0];
                    int jj = j + direct[1];
                    if(ii >= 0 && ii < row && jj >=0 && jj < col && matrix[ii][jj] >= val && !canFlow[ii][jj]){
                        myQ.offer(ii * col + jj);
                        canFlow[ii][jj] = true;
                    }
                }
        }
    }
}
