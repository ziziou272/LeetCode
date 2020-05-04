package stringAndArray;

public class LC75 {
    public void sortColors(int[] nums) {
        if(nums == null) return;
        if(nums.length <= 1) return;
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while(j <= k){
            // 这三个判定语句是互斥的
            if(nums[j] == 1)
                j++;
            else if(nums[j] == 2)
            {
                swap(nums,k,j);
                k--;
            }
            else{
                swap(nums, i, j);
                i++;
                j++;
            }
        }
    }
    private void swap(int [] nums, int i, int j){
        int temp = nums [i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
