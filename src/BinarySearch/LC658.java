package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class LC658 {
    //可以用left + 1 和 right来解
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length == 0)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == x)
            {
                left = mid;
                right= mid - 1;
                break;
            }
            else if (arr[mid] < x){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        for(int i = 0; i < k; i++){
            //since k  is smaller than arr.length so 左右不会同时越界
            if(left >= arr.length || right >= 0 && (Math.abs(arr[right] - x) <= Math.abs(arr[left] - x))){
                right--;
            }
            else
                left++;
        }
        int start = Math.max(0, right + 1);
        for(int i = start; i < k + start; i++){
            res.add(arr[i]);
        }
        return res;
    }
}
