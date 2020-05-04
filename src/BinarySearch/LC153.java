package BinarySearch;

public class LC153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid - 1 >= 0 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            else if(nums[mid] >= nums[0])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return nums[0];
    }

    public static void main(String[] args) {

    }
}
