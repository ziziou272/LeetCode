package BinarySearch;

public class searchRangeLC34 {
    //分别找出左右边界
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if(nums == null || nums.length == 0) return res;
        res[0] = findLeft(nums, target);
        res[1] = findeRight(nums, target);
        return res;
    }
    public int findLeft(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return (left < arr.length && arr[left] == target) ? left : -1;
    }
    public int findeRight(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return (right >= 0 && arr[right] == target) ? right : -1;
    }

}
