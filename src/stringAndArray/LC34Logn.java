/*
package stringAndArray;

public class LC34Logn {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int []{-1,-1};
        if(nums == null || nums.length == 0) return result;
        int left = 0;
        int right = nums.length - 1;
        while(left  <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                //left part boundary index
                int leftBound = right;
                int rightBound = mid;
                //right boundary

                //left part
                while(){

                }
                while(leftBound > 0 && nums[leftBound - 1] == target){
                    leftBound--;
                }
                int[] res = new int [] {leftBound, rightBound};
                return res;
            }
        }

        return result;
    }
}
*/
