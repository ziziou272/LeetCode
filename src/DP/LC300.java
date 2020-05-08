package DP;

public class LC300 {

}
class SolutionLC300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int max = 0;
            int cur = nums[i];
            for(int j = 0; j < i; j++){
                if(nums[j] < cur){
                    max = Math.max(memo[j], max);
                }
            }
            memo[i] = max + 1;
            res = Math.max(res, memo[i]);
        }
        return res;
    }
}
/*

        5 2 8 6 3 6 9 7 1 2 3 100 102
        1 1 2 2 2 3 3 4 1 2 3  5  6
1. for each index/node go left to find the all node smaller than curretn value
2. and find the longest from these nodes and put this max to memo

*/