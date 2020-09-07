package intuit.VO;

import java.util.ArrayList;
import java.util.List;

public class FindRectangle {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,1,1,1},
                {1,0,0,1},
                {1,0,0,1},
                {1,1,1,0},
        };
        int[][] matrix2 = new int[][]{
                {1,1,0,0}
        };
        findRectangle(matrix);
        findRectangle(matrix2);
        findRectangles(matrix);
    }
    /*
    * [1,1,1,1]
    * [1,0,0,0]
    * [1,0,0,0]
    * [1,1,1,1]
    * top-left: [1,1]
    * bottom-right: [1,2]
    *
    *
    * */
    public static List<int[]> findRectangle(int[][] matrix){
        int row = matrix.length, col = matrix[0].length;
        List<int[]> res = new ArrayList<>();
        Search:
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    //find boundary
                    res.add(new int[]{i, j});
                    int[] end = findBoundary(matrix, i, j);
                    res.add(end);
                    break Search;
                }
            }
        }
        for(int[] arr : res){
            System.out.println(arr[0] + "," + arr[1]);
        }

        return res;
    }

    public static List<int[]> findRectangles(int[][] matrix){
        int row = matrix.length, col = matrix[0].length;
        List<int[]> res = new ArrayList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    //find boundary
                    int[] coordinate = new int[4];
                    coordinate[0] = i;
                    coordinate[1] = j;
                    int[] end = findBoundary(matrix, i, j);
                    coordinate[2] = end[0];
                    coordinate[3] = end[1];
                    res.add(coordinate);
                    i = end[0];
                    j = end[1];
                }
            }
        }
        int i = 1;
        for(int[] arr : res){
            System.out.println("Rectangle " + i + ": ");
            System.out.println("Start: " + arr[0] + "," + arr[1] + " End: " + arr[2] + "," +arr[3]);
            i++;
        }

        return res;
    }

    private static int[] findBoundary(int[][] matrix, int i, int j){
        //check bottom right
        int row = matrix.length, col = matrix[0].length;
        if(i + 1 < row && j + 1 < col && matrix[i+1][j+1] == 0 && matrix[i+1][j] == 0 && matrix[i][j+1] == 0){
            return findBoundary(matrix, i + 1, j + 1);
        }else if(j+1 < col && matrix[i][j+1] == 0)
            return findBoundary(matrix, i, j + 1);
        else if(i+1 < row && matrix[i+1][j] == 0)
            return findBoundary(matrix, i + 1, j);
        else{
            return new int[]{i, j};
        }
    }

    //q3
    static List<List<int[]>> irregular(int[][] matrix) {
        List<List<int[]>> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == 0) {
                    List<int[]> cur = new ArrayList<>();
                    dfs(matrix, i, j, row, col, cur);
                    res.add(cur);
                }
            }
        }
        for(List<int[]> r: res) {
            System.out.println("" + r);
        }
        return res;
    }

    static void dfs(int[][] matrix, int i, int j, int row, int col, List<int[]> cur) {
        int[][] dir = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        if(i<0 || i>= row || j<0 || j>=col || matrix[i][j] == 1) {
            return;
        }
        cur.add(new int[]{i,j});
        matrix[i][j] = 1;
        for(int[] k: dir) {
            int i2 = i+k[0], j2 = j+k[1];
            dfs(matrix, i2, j2, row, col, cur);
        }
    }
}
