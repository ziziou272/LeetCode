package BinarySearch;

public class LC33 {
    /*

  start              end
  [5,6,7,8,9,0,1, 2]
             p
         m
  l
                    r

1. == return mid
2. mid < end   right part
   a. if target < end {
        binary search
   }
   b. target > end go left
3. mid > start left part
   a.  mid < target && target > end
        left
    b. right
*/
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int end = nums[nums.length - 1];
        int start = nums[0];
        //if target smaller than end check right part
        if(target < end){
            int left = 0, right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] > target && nums[mid] <= end)
                    right = mid - 1;
                else if (nums[mid] == target)
                    return mid;
                else
                    left = mid + 1;
            }
        }
        else if(target == end)
            return nums.length - 1;
        else{//left part  target > end
            int left = 0, right = nums.length - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(nums[mid] < target && nums[mid] >= start){
                    left = mid + 1;
                }
                else if(nums[mid] == target){
                    return mid;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
