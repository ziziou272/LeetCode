package DP;

public class LC152 {
    /*
            2 3 -2   4
            2 6 -2   4
            2 3 -12  -48
        [-2, 3, -3, 4,   -1  ,2,   4,         -500,     4]

dp  +   [-2, 3, 18, 72  36   72    288       144*2000
    -   [-2,-6, -9,-36  -72  -144  -144*4    -500*288

*/
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        //因为有正有负，所以每次把最大值最小值更新（preMax和preMin），更新max，以防后边遇到一个负数，负负得正
        int preMax ;
        int preMin ;
        int max = nums[0];
        preMax = max;
        preMin = nums[0];
        int curMax, curMin;
        for(int i = 1; i < nums.length; i++){
            int temp1 = nums[i] * preMax;
            int temp2 = nums[i] * preMin;
            curMax = Math.max(Math.max(temp1, nums[i]), temp2);
            curMin = Math.min(Math.min(temp1,temp2), nums[i]);
            if(max < curMax)
                max = curMax;
            preMax = curMax;
            preMin = curMin;
        }
        return max;
    }
}
