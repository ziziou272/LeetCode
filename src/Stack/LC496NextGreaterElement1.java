package Stack;

import java.util.*;

public class LC496NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }
        for(int i = 0; i < nums2.length; i++){
            int val = nums2[i];
            while(!stack.isEmpty() && val > stack.peek()){
                int index = map.get(stack.pop());
                res[index] = val;
            }
            if(map.containsKey(val)){
                stack.push(val);
            }
        }
        return res;
    }
}
