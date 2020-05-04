package Tree;

import java.util.Stack;

public class LC255 {
    public boolean verifyPreorder(int[] preorder) {
        int[] index = new int[1];
        helper(preorder, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return index[0] >= preorder.length;
    }
    private void helper(int[] arr, int[] index, int min, int max){
        if(index[0] >= arr.length)
            return;
        int curVal = arr[index[0]];
        if(curVal < min || curVal > max)
            return;
        index[0]++;
        helper(arr, index, min, curVal);
        helper(arr, index, curVal, max);
    }
}
class iterativeSolutionLC255{
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int lowerBound = Integer.MIN_VALUE;
        for(int i = 0; i < preorder.length; i++){
            int cur = preorder[i];
            if(cur < lowerBound)
                return false;
            while(!stack.isEmpty() && cur > stack.peek()){
                lowerBound = stack.pop();
            }
            stack.push(cur);
        }
        return true;
    }
}

