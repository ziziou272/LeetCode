package Tree;

import com.main.TreeNode;

public class LC298 {
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        int[] max = new int[1];
        dfs(root, max, 0, root.val - 1);
        return max[0];
    }
    private void dfs(TreeNode root, int[] max, int count, int target){
        //base case
        if(root == null){
            if(count > max[0])
                max[0] = count;
            return;
        }
        if(root.val == target + 1)
            count++;
        else {
            if(count > max[0])
                max[0] = count;
            count = 1;
        }
        dfs(root.left, max, count, root.val);
        dfs(root.right, max, count, root.val);
    }
}
