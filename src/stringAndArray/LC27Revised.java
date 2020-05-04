package stringAndArray;
//if else 太多，不make sense
public class LC27Revised {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length;
        while(left < right){
        if(nums[left] == val){
            if(nums[right - 1] != val){
                nums[left++] = nums[right--];
            }
            else
            {right--;}
        }
        else{left++;}
    }
        return right;
    }
}