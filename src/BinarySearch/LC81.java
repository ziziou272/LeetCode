/*
package BinarySearch;

public class LC81 {
    public boolean search(int[] nums, int target) {
        //cc
        if(nums == null || nums.length == 0)
            return false;
        int left = 0, right = nums.length - 1;
        //todo:find the boundary
        //如果mid left right 都是重复就很难找出rotated 的 index
        int boundary = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid - 1 >= 0 && nums[mid] < nums[mid - 1]){
                boundary = mid;
                break;
            }
            else if (nums[mid] > nums[0]){
                left = mid + 1;
            }
            else if(nums[mid] == nums[0]){
                if(nums[left] == nums[0])
                    l
            }
            else{
                right = mid - 1;
            }
        }
    }
}
*/
