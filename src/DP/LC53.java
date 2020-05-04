package DP;

//基本思路：从左到右扫一遍， 2,7,-7,3,-8,90    如果前边的为负数就不用,全负数也是可以
//                      2 9 -2 3 -5 90
public class LC53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int preMax = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(preMax > 0){
                preMax = preMax + nums[i];
            }
            else
                preMax = nums[i];
            max = Math.max(preMax, max);
        }
        return max;
    }

}
