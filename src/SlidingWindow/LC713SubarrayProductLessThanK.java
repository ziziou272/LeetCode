package SlidingWindow;

public class LC713SubarrayProductLessThanK {
}
class solution2{
    //binary search

}
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        if(k <= 1) return 0;
        int count = 0, s = 0, f = 0;
        int sum = 1;
        for(int i = 0; i < nums.length; i++){
            sum *= nums[i];
            while(sum >= k){
                sum /= nums[s++];
            }
            count += (i - s + 1);
        }
        return count;
    }
}
/*
 positive
 k = 20

    1 1 1 1 1 1 5 1 1 1 5
    s
        f

f++
sum = 1

*/
