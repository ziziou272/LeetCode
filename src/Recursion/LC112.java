package Recursion;

import com.main.TreeNode;
//empty tree sum = 0 return false
public class LC112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum = sum - root.val;
        //leaf node means no children
        if(root.left == null && root.right == null)
            return (sum == 0);
        return hasPathSum(root.left,sum) || hasPathSum(root.right,sum);
    }

}
