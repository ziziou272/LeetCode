package DP;

/*
* greedy:
    0 1 2 3 4 5  6 7 8 9
    2 3 3 1 1 5  1 0 0 4
res 0 1 1 2 2 2  3
      4 5 5 5 10 10

res 1

*
* */
public class LC45Greedy {
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        int res = 1;
        int range = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i > range){
                res++;
                range = max;
            }
            max = Math.max(max, nums[i] + i);
        }
        return res;
    }
}
