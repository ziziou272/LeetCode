package BinarySearch;

public class LC334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;
        int rightBoundary = 0;
        for(int i = 0; i < nums.length; i++){
            int index = getIndex(nums, rightBoundary, nums[i]);
            if(index == rightBoundary + 1){
                nums[index] = nums[i];
                if(++rightBoundary >= 2)
                    return true;
            }
            else
                nums[index] = nums[i];
        }
        return false;
    }

    private int getIndex(int[] nums, int boundary, int target){
        int left = 0, right = boundary;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
