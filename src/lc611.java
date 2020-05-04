import java.util.Arrays;

public class lc611 {
    public class Solution {
        //n^2log(n)
        public int triangleNumber(int[] nums) {
            //corner case
            if(nums == null || nums.length < 2) return 0;
            Arrays.sort(nums);
            int count = 0;
            for(int i = 0; i < nums.length - 2; i++){
                for(int j = i + 1; j < nums.length - 1; j++){
                    //binary search
                    int left = j + 1, right = nums.length - 1;
                    int sum = nums[i] + nums[j];
                    while(left <= right){
                        int mid = left + (right - left) / 2;
                        if(nums[mid] < sum){
                            left = mid + 1;
                        }
                        else{
                            right = mid - 1;
                        }
                    }
                    count += left - j - 1;
                }
            }
            return count;
        }
    }
}
class Solution{
    //n^2
    public int triangleNumber(int[] nums) {
        //corner case
        if(nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] <= 0) continue;
            int k = i + 2;
            for(int j = i + 1; j < nums.length - 1; j++){
                while(k < nums.length && nums[i] + nums[j] > nums[k]){
                    k++;
                }
                count += k - j - 1;
            }
        }
        return count;
    }
}
