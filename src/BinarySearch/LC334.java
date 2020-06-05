package BinarySearch;

import java.util.Arrays;

class Solution334touJi {
    public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3)
            return false;
        int[] tri = new int[3];
        Arrays.fill(tri, Integer.MAX_VALUE);
        for(int i = 0; i < nums.length; i++){
            //put currret number to right position
            int cur = nums[i];
            if(cur <= tri[0])
                tri[0] = cur;
            else if(cur <= tri[1])
                tri[1] = cur;
            else if(cur <= tri[2] ){
                return true;
            }
        }
        return false;
    }
}
/*
0 1 2 3 4 5 6 7 8
7 8 6 3 3 7 5 8 2
i
      j
7 8 3 9
7 8 3 4 5

1: 3
2: 5
3: 8
debug:
1 1 1 3 4 5
[0,4,2,1,0,-1,-3]
1: -1
2: 1
3:

debug
5 4 3 2 1
1
2
3
*/
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
