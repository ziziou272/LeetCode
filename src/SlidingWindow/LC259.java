package SlidingWindow;

import java.util.Arrays;
//todo: duplicate?
public class LC259 {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int tar = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] < tar){
                    count += right - left;
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return count;
    }
}
