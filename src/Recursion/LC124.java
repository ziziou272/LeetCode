package Recursion;

import com.main.TreeNode;
import com.sun.source.tree.Tree;

public class LC124 {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int [] max = new int [1];
        max[0] = root.val;

        maxPathSum(root,max);
        return max[0];
    }


    private int maxPathSum(TreeNode root,int[]max){

        if(root == null) return 0;

        int left = maxPathSum(root.left,max);
        int right = maxPathSum(root.right,max);

        max[0] = Math.max(max[0],Math.max(0,left) + root.val + Math.max(0,right));

        return  Math.max(0,Math.max(left,right)) + root.val;

    }
}
