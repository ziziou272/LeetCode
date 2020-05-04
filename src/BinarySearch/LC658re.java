package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class LC658re {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0)
            return res;
        int left = 0, right = arr.length - 1;
        int targetIndex = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
                if(arr[mid] == x){
                    targetIndex= mid;
                    break;
                }
                else if(arr[mid] > x){
                    right = mid - 1;
                }
                else
                    left = mid + 1;
        }
        if(targetIndex == -1){
            if(left < arr.length && right >= 0){
                targetIndex = Math.abs(arr[left] - x) <= Math.abs(arr[right] - x) ? left : right;
            }
            else{
                targetIndex = right < 0 ? left : right;
            }
        }
        int start = targetIndex, end = targetIndex;
        for(int i = 0; i < k; i++){//find lo and hi
            if(start >= 0 && right < arr.length){
                if (Math.abs(arr[start] - x) <= Math.abs(arr[end] - x)) {
                    start--;
                } else {
                    end++;
                }
            }
            else{
                if (start >= 0) {
                    start--;
                } else {
                    end++;
                }
            }
        }
        for(int i = start; i <= end; i++){
            res.add(arr[i]);
        }
        return res;

    }
}
