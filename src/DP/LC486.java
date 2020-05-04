package DP;

public class LC486 {
    public static void main(String[] args){


        int[] nums = new int[]{1,5,2,4,6};
        DFSMemorization sol = new DFSMemorization();
        sol.PredictTheWinner(nums);
        System.out.println();

    }
    public boolean PredictTheWinner(int[] nums) {
        return game(nums, true, 0, nums.length - 1) >= 0;
    }
    private int game(int[] nums, boolean ifFirstPlayer, int left, int right){
        //base case
        //if positive, first player win
        if(left == right)
            return ifFirstPlayer ? nums[left] : -1 * nums[left];
        int factor = ifFirstPlayer ? 1 : -1;
        int choiceOne = game(nums, !ifFirstPlayer, left + 1, right) + factor * nums[left];
        int choiceTwo = game(nums, !ifFirstPlayer, left, right - 1) + factor * nums[right];
        return ifFirstPlayer ? Math.max(choiceOne, choiceTwo) : Math.min(choiceOne, choiceTwo);
    }
    /*
        [9, 1, 5, 11, 8]
    1          9                  8
    2     1         8            9        11
    1   5   8    1    11      1    11     9   5
    2 11 8  5 11 5 11  1 5   5  11  1 5   1 5 9 1
    1 8  11
*/
}
class DP{
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = nums.length - 1; i >= 0; i--){
            dp[i][i] = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                int one = nums[i] - dp[i + 1][j];
                int two = nums[j] - dp[i][j - 1];
                dp[i][j] = Math.max(one, two);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}
class revisedBrutalForce{
    public boolean PredictTheWinner(int[] nums) {
        return game(nums, 0, nums.length - 1) >= 0;
    }
    private int game(int[] nums, int left, int right){
        //base case
        //always return current biggest value
        if(left == right)
            return nums[left];

        int choiceOne = nums[left] - game(nums, left + 1, right);
        int choiceTwo = nums[right] - game(nums, left, right - 1);
        return Math.max(choiceOne, choiceTwo);
    }
}
class DFSMemorization{
    public boolean PredictTheWinner(int[] nums) {
         Integer[][] memo = new Integer[nums.length][nums.length];
         boolean res = game(nums, 0, nums.length - 1, memo) >= 0;
         return res;
    }
    private int game(int[] nums, int left, int right, Integer[][] memo){
        //base case
        //always return current biggest value
        if(left == right)
            return nums[left];
        if(memo[left][right] != null)
            return memo[left][right];
        int choiceOne = nums[left] - game(nums, left + 1, right, memo);
        int choiceTwo = nums[right] - game(nums, left, right - 1, memo);
        memo[left][right] = Math.max(choiceOne, choiceTwo);
        return memo[left][right];
    }
}
