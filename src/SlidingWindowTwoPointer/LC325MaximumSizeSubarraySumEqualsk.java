package SlidingWindowTwoPointer;

import java.util.HashMap;

public class LC325MaximumSizeSubarraySumEqualsk {
    /*
k = 3
         0   1  2   3  4
         1, -1, 5, -2, 3
         1   0  5   3  6

s = 8

    0 1 2  3   4  5   6 7  8   9
    5 2 6  2  -2  3  -3 2  0   8
                              i
    5 7 15 17 15 18 15 17 17 25
*/
    public int maxSubArrayLen(int[] nums, int k) {
        int maxLen = 0, sum = 0, curMax = 0;
        //sum to current index, if duplicate keep the most left one
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int targetSum = sum - k;
            if(sum == k) curMax = i + 1;
            else if(map.containsKey(targetSum))
                curMax = i - map.get(targetSum);
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
            maxLen = Math.max(maxLen, curMax);
        }
        return maxLen;
    }
}
