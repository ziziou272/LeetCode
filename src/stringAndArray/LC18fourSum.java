package stringAndArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 4; i++){
            if(i - 1 >= 0 && nums[i - 1] == nums[i])
                continue;
            for(int j = i + 1; j <= nums.length - 3; j++){
                if(j - 1 >= i + 1 && nums[j - 1] == nums[j])
                    continue;
                twoSum(nums, target - nums[i] - nums[j], j + 1, nums[i], nums[j], res);
            }

        }
        return res;
    }
    private void twoSum(int[] nums, int target, int offset, int num1, int num2, List<List<Integer>> res){
        int start = offset, end = nums.length - 1;
        while(start < end){
            if(nums[start] + nums[end] == target){
                List<Integer> path = new ArrayList<>();
                path.add(num1);
                path.add(num2);
                path.add(nums[start]);
                path.add(nums[end]);
                res.add(path);
                start++;
                end--;
                while(start < end && nums[start - 1] == nums[start]) start++;
                while(start < end && nums[end + 1] == nums[end]) end--;
            }
            else if(nums[start] + nums[end] < target){
                start++;
            }
            else
                end--;
        }
    }
}
