package DP;

import java.util.Stack;

public class LC85Stack {
    /*

  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]

   1 0 1 0 0
   1 0 1 0 0

   1 0 2 1 1
   1 0 2 3 3

   to optimize use stack
index   0 1 2 3 4
        3 1 3 2 2
res     3 4 3 6 2
stack -1 1

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
            Stack<Integer> stack = new Stack<>();
            //push in index
            for(int k = 0; k <= col; k++){
                int comingHeight = k == col ? -1 : maxHeight[k];
                while(!stack.isEmpty() && maxHeight[stack.peek()] > comingHeight){
                    int index = stack.pop();
                    int leftBound;
                    if(stack.isEmpty())
                        leftBound = -1;
                    else
                        leftBound = stack.peek();
                    int height = maxHeight[index];
                    int wid = k - leftBound - 1;
                    maxArea = Math.max(height * wid, maxArea);
                }
                stack.push(k);
            }
        }
        return maxArea;
    }
}
