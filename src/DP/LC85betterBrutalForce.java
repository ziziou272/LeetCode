package DP;

public class LC85betterBrutalForce {
    /*

  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]


   1 0 1 0 0
   1 0 1 0 0

   1 0 2 1 1
   1 0 2 3 3 n^2

   3 1 3 2 2

   4 0 0 3 0

*/
    public int maximalRectangle(char[][] matrix) {
        //
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        //get the max height of the row
        int[] maxHeight = new int[col];
        int maxArea = 0;
        for(int i = 0; i < row; i++){
            //get maxHeight for each row
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '0')
                    maxHeight[j] = 0;
                else
                    maxHeight[j] += matrix[i][j] - '0';
            }
            for(int k = 0; k < col; k++){
                int height = maxHeight[k];
                int left = k - 1, right = k + 1;
                //(left, right)
                while(left >= 0){
                    if(maxHeight[left] >= height)
                        left--;
                    else
                        break;
                }
                while(right < col){
                    if(maxHeight[right] >= height)
                        right++;
                    else
                        break;
                }
                int wid = right - left - 1;
                maxArea = Math.max(maxArea, wid * height);
            }
        }
        return maxArea;
    }
}
