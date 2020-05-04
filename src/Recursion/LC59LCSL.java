package Recursion;

public class LC59LCSL {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        if( n <= 0) return res;
        int counter = 0;

        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;

        while(rowStart <= rowEnd && colStart <= colEnd){

            for(int i = colStart; i <= colEnd; i++){
            res[rowStart][i] = ++counter;
        }
            rowStart++;
            for(int i = rowStart; i <= rowEnd; i++){
                res[i][colEnd] = ++counter;
            }
            colEnd--;
            for(int i = colEnd; i >= colStart; i--){
                res[rowEnd][i] = ++counter;
            }
            rowEnd--;
            for(int i = rowEnd; i>= rowStart; i--){
                res[i][colStart] = ++counter;
            }
            colStart++;}
       return res;
    }
}
