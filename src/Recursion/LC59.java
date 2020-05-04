package Recursion;

public class LC59 {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        if(n == 0) return res;
        int counter = 0;
        generateMatrix(n, res, 0, counter);
        return res;
    }
    private void generateMatrix(int n, int[][] res, int offset, int counter){
        if(n == 0) return;
        if(n == 1)
        {
            res[offset][offset] = ++counter;
            return;
        }

        for(int i = 0; i < n - 1; i++){
            res[offset][offset + i] = ++counter;
        }

        for(int i = 0; i < n - 1; i++){
            res[offset + i][offset + n - 1] = ++counter;
        }

        for(int i = 0; i < n - 1;i++){
            res[offset + n - 1][offset + n - 1 - i] = ++counter;
        }

        for(int i = 0; i< n - 1; i++){
            res[offset + n - 1 - i][offset] = ++counter;
        }

        generateMatrix(n - 2, res, offset + 1, counter);
    }
}
