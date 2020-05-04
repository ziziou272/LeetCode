package DP;

import java.util.Arrays;

public class LC53outSubArray {
    public int[] maxSubArrayOut(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int max = nums[0];
        int preMax = nums[0];
        int slow = 0;
        int fast = 0;
        int resultSlow = 0;
        int resultFast = 0;
        for(int i = 1; i < nums.length; i++){
            if(preMax > 0){
                preMax = preMax + nums[i];
            }
            else{
                preMax = nums[i];
            }
            fast++;
            if(nums[fast] < 0)
                if(fast + 1 < nums.length)
                    slow = fast + 1;
            if(preMax > max){
                max = preMax;
                resultSlow = slow;
                resultFast = fast;
            }
        }
        //copy nums array from index slow to fast
        int [] result = new int[resultFast - resultSlow + 1];
        System.arraycopy(nums,resultSlow,result,0, resultFast - resultSlow + 1);
        return result;
    }
}
