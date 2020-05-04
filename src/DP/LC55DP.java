package DP;
//和上课讲内部循环的方法不同，课上方法是内部去找当前节点能向右走的所有而不是所有右边的节点
//课上更优
public class LC55DP {//从右往左标true，内层是check从当前节点到尾部有没有true
    public boolean canJump(int[] nums) {
        boolean [] dp = new boolean [nums.length];
        int size = nums.length;
        dp[size - 1] = true;
        for(int i = 1; i < size ; i++){
            int index = size - i - 1;
            for(int j = index + 1; j < size; j++){
                if(nums[index] >= i  || (nums[index] >= j - index && dp[j]))
                {   dp[index] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
