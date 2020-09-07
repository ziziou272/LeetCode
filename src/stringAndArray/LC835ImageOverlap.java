package stringAndArray;

public class LC835ImageOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        int max = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                //shit up
                max = Math.max(max, shiftAndCount(i, j, A, B));
                //shift down
                max = Math.max(max, shiftAndCount(i, j, B, A));
            }
        }
        return max;
    }

    private int shiftAndCount(int yShift, int xShift, int[][] arr, int[][] target){
        int count = 0;
        int x = 0;
        for(int i = yShift; i < arr.length; i++){
            int y = 0;
            for(int j = xShift; j < arr[0].length; j++){
                if(arr[i][j] == target[x][y] && arr[i][j] == 1){
                    count++;
                }
                y++;
            }
            x++;
        }
        return count;
    }
}
