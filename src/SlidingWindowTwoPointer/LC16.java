package SlidingWindowTwoPointer;

import java.util.Arrays;

public class LC16 {
}
class SolutionLC16Clean {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1, right = nums.length - 1;
            int newTarget = target - nums[i];
            while(left < right){
                int curSum = nums[left] + nums[right];
                if(curSum == newTarget)
                    return target;
                else if(curSum > newTarget)
                    right--;
                else
                    left++;
                if(res == Integer.MAX_VALUE || Math.abs(target - res) > Math.abs(curSum + nums[i] - target))
                    res = curSum + nums[i];
            }
        }
        return res;
    }
}

/*

target = 6
10
res 5
 -4 -1 -1 2 3 4 5
        i   j
              k

2.4 2.6
2 3 4 5
  l
r

2 3
  l
r

2 3 4
  l
r

2
  l
r






 */
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length <= 2) return -1;
        Arrays.sort(nums);
        Long res = null;
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1])
                continue;
            long cur = (long)(nums[i] + findTwo(nums, i + 1, nums.length - 1, target - nums[i]));
            if(res == null || Math.abs(res - target) > Math.abs(cur - target))
                res = cur;
        }
        return Math.toIntExact(res);
    }
    private long findTwo(int[] nums, int left, int right, int target){
        Long sum = null;
        while(left < right){
            long cur = nums[left] + nums[right];
            if(sum == null || Math.abs(sum - target) > Math.abs(cur - target))
                sum =cur;
            if(nums[left] + nums[right] > target){
                right--;
            }
            else{
                if(nums[left] + nums[right] == target){
                    return nums[left] + nums[right];
                }
                left++;
                //duplicate
                while(left < right && nums[left] == nums[left - 1])
                    left++;
            }
        }
        return sum;

    }
}