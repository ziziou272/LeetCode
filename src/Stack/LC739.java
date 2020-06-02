package Stack;

import java.util.Stack;

public class LC739 {
}
class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        if(T == null || T.length == 0)
            return new int[0];
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            if(stack.isEmpty() || T[stack.peek()] >= T[i]){
                stack.push(i);
            }
            else{
                //pop until find greater than cur val
                int cur = T[i];
                while(!stack.isEmpty() && cur > T[stack.peek()]){
                    int index = stack.pop();
                    res[index] = i - index;
                }
                stack.push(i);
            }
        }
        return res;
    }
}
/*
0  1   2  3  4  5  6 7  8  9
91 70 69 65 72 80 66 63 64 81
   3   2  1  1  4  3   1  1

decreasing stack
91 80 80 65
0

1. n^2
2.
*/