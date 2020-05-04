package BinarySearch;

public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int x = mid / col;
            int y = mid % col;
            if(matrix[x][y] == target)
                return true;
            else if(matrix[x][y] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return false;
    }
}
