package SlidingWindowTwoPointer;

public class LC26 {
}
class SolutionLC26 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 1, j = 1;
        int len = 1;
        while(j < nums.length){
            if(nums[i - 1] == nums[j]){
                j++;
            }
            else{
                nums[i++] = nums[j++];
                len++;
            }
        }
        return len;
    }
}
/*

[i,j)
1 1
free space

1 2 3 4 2 2 3 3 3 4 5 6 7 8
        i
                  j


if not same j : i -1
    nums[i++] = nums[j++]
else
    j++;





*/