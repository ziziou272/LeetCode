package Recursion;

import java.util.ArrayList;
import java.util.List;

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length ==0 ||matrix[0]==null||matrix[0].length==0) return res;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        spiralOrder(0,rowSize,colSize,res,matrix);
        return res;
    }

    private void spiralOrder(int offset, int rowSize, int colSize, List<Integer> res, int[][]matrix){
        if(colSize == 0 ||rowSize == 0)
            return;
        if(colSize == 1){
            for(int i=0;i<rowSize;i++)
            res.add(matrix[offset+i][offset]);
            return;
        }
        if(rowSize == 1){
            for(int i=0;i<colSize;i++)
                res.add(matrix[offset][offset+i]);
            return;
        }
        for(int i=0;i<colSize-1;i++){
            res.add(matrix[offset][offset+i]);
        }
        for(int i=0;i<rowSize-1;i++){
            res.add(matrix[offset+i][offset+colSize-1]);
        }
        for(int i=0;i<colSize-1;i++){
            res.add(matrix[offset+rowSize-1][offset+colSize-1-i]);
        }
        for(int i=0;i<rowSize-1;i++){
            res.add(matrix[offset+rowSize-1-i][offset]);
        }

        spiralOrder(offset + 1, rowSize - 2, colSize - 2, res, matrix);
    }
}
