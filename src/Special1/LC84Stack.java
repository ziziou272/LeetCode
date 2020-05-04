package Special1;

import java.util.Stack;

public class LC84Stack {
        public int largestRectangleArea(int[] heights) {
            if(heights == null || heights.length == 0)
                return 0;
            Stack<Integer> myStack = new Stack<>();
            //myStack.push(-1);
            int max = 0;
            int cur = 0;
            int height = 0;
            for(int i = 0; i <= heights.length; i++){
                if(i == heights.length)
                    height = 0;
                else
                    height = heights[i];
                while(!myStack.empty() && heights[myStack.peek()] > height){
                    int curIndex = myStack.pop();
                    if(myStack.empty()){
                        cur = heights[curIndex] * (i - (-1) - 1);
                    }
                    else {
                        cur = heights[curIndex] * (i - (myStack.peek()) - 1);
                    }
                    max = Math.max(max, cur);
                }
                myStack.push(i);
            }
            return max;
        }
}
