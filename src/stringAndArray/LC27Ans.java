package stringAndArray;

public class LC27Ans {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0 ) return 0;
        int i = 0;
        int size = nums.length;
        for(int j = 0; j< size; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
