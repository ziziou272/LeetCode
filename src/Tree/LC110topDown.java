package Tree;

import com.main.TreeNode;

public class LC110topDown {//注意时间复杂度 是 nlogn
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (Math.abs(left - right) <= 1)
            return isBalanced(root.left) && isBalanced(root.right);
        else
            return false;
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        return Math.max(left, right) + 1;
    }
}
