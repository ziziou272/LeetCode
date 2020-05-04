package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class LC239ArrayQueue {
    public int[] maxSlidingWindow(int[] nums, int k) {//每个元素进出一次o(n)
        //cc
        if(nums == null || nums.length == 0 ||nums.length < k) return new int[0];
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            //pop out the item that not in sliding item
            if(!stack.isEmpty() && i - k == stack.peekFirst())
                stack.pollFirst();
            //keep an decreasing stack, first is the biggest
            while(!stack.isEmpty() && nums[i] > nums[stack.peekLast()]){//o(k)
                stack.pollLast();
            }
            //offer index
            stack.offerLast(i);
            //add result
            if(i - k + 1 >= 0) res[i - k + 1] = nums[stack.peekFirst()];
        }
        return res;
    }
}
