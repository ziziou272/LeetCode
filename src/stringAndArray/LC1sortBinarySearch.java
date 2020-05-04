package stringAndArray;

import java.util.Arrays;
//todo: return index  所以不能改变这个array  所以sort的做法是错的
public class LC1sortBinarySearch {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return new int[0];
        Arrays.sort(nums);
        //binary Search
        for(int i = 0; i < nums.length - 1; i++){
            int left = i + 1;
            int right = nums.length - 1;
            int value = target - nums[i];
            while (left + 1 < right){
                int mid = left + (right - left) / 2;
                if(nums[mid] == value)
                    return new int[] {i,mid};
                if(nums[mid] < target){
                    left = mid;
                }
                else {
                    right = mid;
                }
            }
            if(nums[left] == value) return new int[] {i,left};
            if(nums[right] == value) return new int[] {i,right};
        }
        return new int[0];
    }
}
