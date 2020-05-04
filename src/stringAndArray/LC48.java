package stringAndArray;

public class LC48 {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return;
        int offset = 0;
        int size = matrix.length;
        rotate(offset, size, matrix);
    }

    private void rotate(int offset, int size, int[][] matrix){
        //base case
        if(size <= 1)
            return;
        for(int i = 0; i < size - 1; i++){
            int temp = matrix[offset + i][offset];
            matrix[offset + i][offset] = matrix[offset + size - 1][offset + i];
            matrix[offset + size -1][offset + i] = matrix[offset + size - 1 - i][offset + size - 1];
            matrix[offset + size - 1 - i][offset + size - 1] = matrix[offset][offset + size - 1 - i];
            matrix[offset][offset + size - 1 - i] = temp;
        }
        rotate(offset + 1,size - 2,matrix);
    }
}
