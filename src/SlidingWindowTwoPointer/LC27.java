package SlidingWindowTwoPointer;

public class LC27 {
}
class Solution27 {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int len = 0;
        int i = -1, j = 0;
        while(j < nums.length){
            if(nums[j] == val){
                j++;
            }
            else{
                nums[++i] = nums[j++];
                len++;
            }
        }
        return len;
    }
}
/*
free space
(i,j)
-1, 0
  1 3 2 3 2 3 1 4 1 4 5 6 1 1 1 1 2
i      j


if(delete)
    j++;
else
    nums[++i] = nums[j++];


*/