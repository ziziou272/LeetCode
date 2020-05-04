package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class LC542_01Matrix_suanFage {
    private static final int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
        //todo: cc
        int row = matrix.length;
        int col = matrix[0]. length;
        int [][] res = new int[row][col];
        Queue<Integer> myQ = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    myQ.offer(i * col + j);
                }
            }
        }
        int distance = 0;
        while(!myQ.isEmpty()){
            int size = myQ.size();
            for(int k = 0; k < size; k++){
                int index = myQ.poll();
                int i = index / col;
                int j = index % col;
                for(int[] direct : direction){
                    int ii = i + direct[0];
                    int jj = j + direct[1];
                    if(ii >=0 && ii < row && jj >= 0 && jj < col && res[ii][jj] == 0 && matrix[ii][jj] == 1){
                        myQ.offer(ii * col + jj);
                        res[ii][jj] = distance + 1;
                    }
                }
            }
            distance++;
        }
        return res;
    }
}
