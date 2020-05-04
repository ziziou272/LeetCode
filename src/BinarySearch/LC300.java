package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int prev = Integer.MIN_VALUE;
        int[] max = new int[1];
        lengthOfLIS(nums, 0, max, prev, 0);
        return max[0];
    }

    private void lengthOfLIS(int[] nums, int index, int [] max, int prev, int count){
        if(index > nums.length - 1)
            return;
        for(int i = index; i< nums.length; i++){
            if(i == 0 || nums[i] > prev){
                count = count + 1;
                lengthOfLIS(nums, i + 1, max, nums[i], count);
                count = count - 1;
            }
        }
        max[0] = Math.max(max[0], count);
    }
}
