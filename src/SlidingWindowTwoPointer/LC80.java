package SlidingWindowTwoPointer;
class Solution80 {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int i = 0, j = 1, k = 1;
        while(k < nums.length){
            if(nums[i] == nums[k]){
                if(j - i < 2){
                    nums[j++] = nums[k++];
                }
                else{
                    k++;
                }
            }else{
                i = j;
                nums[j++] = nums[k++];
            }
        }
        return j;

    }
}
/*
[i,j) current
 0 1
[j,k) free space
 1 1
1 1 2 2 3 4 3 4 5 5 5 6 7
          i
          j
              k

if nums[i] ==num[k]
    if j - i < 2
        nums[j++] = nums[k]
        k++;
    else
        k++
else
    i = j
    nums[j++] = nums[k++]
*/
public class LC80 {
}
