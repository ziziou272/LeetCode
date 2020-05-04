package DFS;

//time limit exceeded
public class LC377DFSwithReturn {
    public int combinationSum4(int[] nums, int target) {
        //cc
        if(nums == null || nums.length == 0)
            return 0;
        return dfs(nums, target);
    }
    private int dfs(int[] nums, int target){
        if(target == 0)
            return 1;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(target >= nums[i])
                res = res + dfs(nums, target - nums[i]);
        }
        return res;
    }
}
