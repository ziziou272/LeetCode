package Tree;

import com.main.TreeNode;

public class LC98 {// binary tree definition
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidBST(null, null, root);
    }
    private boolean isValidBST(Integer left, Integer right, TreeNode root){
        if(root == null) return true;
        if(right != null && root.val >= right || left != null && root.val <= left) return false;
        return isValidBST(left, root.val, root.left) && isValidBST(root.val, right, root.right);
    }
}
class solutionUsingLong{
    public boolean isValidBST(TreeNode root) {
        long lowerBound = Long.MIN_VALUE;
        long upperBound = Long.MAX_VALUE;
        return dfs(root, lowerBound, upperBound);
    }
    private boolean dfs(TreeNode root, long low, long up){
        if(root == null) return true;
        if(root.val <= low || root.val >= up) return false;
        return dfs(root.left, low, root.val) && dfs(root.right, root.val, up);
    }
}
