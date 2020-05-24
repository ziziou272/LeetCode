package stringAndArray;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class LC15_3sum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1])
            {

            }
            else {
                int target = 0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right){
                    if(nums[left] + nums[right] == target){
                        List<Integer> level = new ArrayList<>();
                           level.add(nums[left]);
                           level.add(nums[right]);
                           level.add(nums[i]);
                           res.add(level);
                        while (left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if(nums[left] + nums[right] < target){
                            while (left < right && nums[left] == nums[left + 1]){
                                left++;
                            }
                            left++;
                    }
                    else {
                            while (left < right && nums[right] == nums[right - 1]){
                                right--;
                            }
                            right--;
                    }
                }
            }
        }
        return res;
    }
}
class SolutionLC15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums ==null || nums.length <= 2) return res;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1])
                continue;
            findTwo(res, nums[i], nums, i + 1, nums.length - 1, -nums[i]);
        }
        return res;
    }
    private void findTwo(List<List<Integer>> res, int first, int[] nums, int left, int right, int target){
        while(left < right){
            if(nums[left] + nums[right] > target){
                right--;
                while(left < right && nums[right] == nums[right + 1])
                    right--;
            }
            else{
                if(nums[left] + nums[right] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                }
                left++;
                //duplicate
                while(left < right && nums[left] == nums[left - 1])
                    left++;
            }
        }
    }
}
/*
sort

-1, -1, -1, 0, 1, 1, 2, 2
f
            s
            t

<-1, -1, 2
      0, 1

1
3 -> 2sum

1. n^3
2. n^2

*/