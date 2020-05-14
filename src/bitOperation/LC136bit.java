package bitOperation;

public class LC136bit {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int res = 0;
        for(int i : nums){
            res = i ^ res;
        }
        return res;
    }

}
