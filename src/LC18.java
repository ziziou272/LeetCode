import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length - 4; i++){
            twoSum(nums, target - nums[i] - nums[i + 1], i + 1, nums[i], nums[i + 1], res);
        }
        return res;
    }
    private void twoSum(int[] nums, int target, int offset, int num1, int num2, List<List<Integer>> res){
        int start = offset + 1, end = nums.length - 1;
        while(start < end){
            if(nums[start] + nums[end] == target){
                List<Integer> path = new ArrayList<>();
                path.add(num1);
                path.add(num2);
                path.add(nums[start]);
                path.add(nums[end]);
                res.add(path);
                return;
            }
            else if(nums[start] + nums[end] < target){
                start++;
            }
            else
                end--;
        }
    }
}
