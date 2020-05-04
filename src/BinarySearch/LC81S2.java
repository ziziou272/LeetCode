package BinarySearch;
//最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
public class LC81S2 {
    public boolean search(int[] nums, int target) {
        //cc
        if (nums == null || nums.length == 0)
            return false;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return true;
            else if (nums[mid] < nums[left]) {
                if (target <= nums[right] && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if(nums[mid] > nums[left]){
                if (nums[mid] > target && target >= nums[left] ) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            else{
                left++;
            }
        }
        return false;
    }

}
