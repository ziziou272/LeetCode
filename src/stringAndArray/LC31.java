package stringAndArray;
class Solution31 {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0)
            return;
        //last peak number
        int index = -1, left = -1;
        int smaller = nums[0], greater = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                left = i - 1;
                index = i;
                smaller = nums[i - 1];
                greater = nums[i];
            }
            else if(nums[i] > smaller && nums[i] <= greater){
                greater = nums[i];
                index = i;
            }
        }
        if(index == -1)
            reverse(nums, 0, nums.length - 1);
        else{
            //swap peak with left
            swap(nums, index, left);
            //revers nums at right hand
            reverse(nums, left+1, nums.length - 1);
        }
    }
    private void swap(int[]nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
/*
2 9 8 7 6 4 3 2 1 1 ->
i
              j
4 5 3 3 2 1

1 3 2

after find the point

nums at right must are decreasing
reverse and insert the num at left of the point

swap
reverse nums at right
put num into right positon

debug:
smaller 2
greater 3
2 3 1 3 3
    i
      j

*/
public class LC31 {
}
