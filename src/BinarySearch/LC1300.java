package BinarySearch;

public class LC1300 {
}
//Binary Search
class Solution1300 {
    public int findBestValue(int[] arr, int target) {
        if(arr == null || arr.length == 0) return -1;
        int left = 0, right = 0;
        for(int i = 0; i < arr.length; i++){
            right = Math.max(arr[i], right);
        }
        //binary search
        while(left <= right){
            int mid = left + (right - left) / 2;
            int sum = getSum(arr, mid);
            if(sum == target)
                return mid;
            else if(sum < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return Math.abs(target - getSum(arr,left)) < Math.abs(target - getSum(arr,right)) ?
                left : right;
    }

    private int getSum(int[]arr, int value){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += Math.min(value, arr[i]);
        }
        return sum;
    }
}
//sort