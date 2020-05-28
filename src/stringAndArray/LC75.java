package stringAndArray;

/**
 * 第一个方法和课上的3way partition一样
 */
class Solution75 {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        for(int i = -1, j = -1, k = 0; k < nums.length; k++){
            if(nums[k] == 0){
                swap(nums, i+1, j+1, k);
                i++;
                j++;
            }
            else if(nums[k] == 1){
                swap(nums, j+1, k);
                j++;
            }
        }
    }
    private void swap(int[] nums, int i, int j, int k){
        int temp = nums[k];
        nums[k] = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
/*
  0 2 2 1 1 0
i
j
    k

red white blue
 0  1     2

one pass + constant space
i=-1,j=-1,k=0

  0 0 1 1 2 2 0 1 2 2 1 0
  i
      j
            k

[0,i]: 0   swap(i+1,k), swap(j+1,k), i++, j++,k++
(i,j]: 1  swap(j+1,k) j++,k++
(j,k)  2  k++
[k,]   unchecked
*/
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
