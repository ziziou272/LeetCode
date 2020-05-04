package BinarySearch;

public class LC240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;
        //start from up right corner
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0;
        int y = col - 1;
        while(x >= 0 && x < row && y >= 0 && y < col){
            if(matrix[x][y] == target)
                return true;
            else if(matrix[x][y] < target)
                x++;
            else
                y--;
        }
        return false;
    }
}
