package Tree;

import com.main.TreeNode;

public class LC235LCAonBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
        when we going fro top down
        first q/p <root.val < p/q
        a. 2 9
            6
        b. 3 5 left
        c. 7 8
         6 go right find 8
        */
        if(root == null) return null;
        if(root.val <= p.val && root.val >= q.val) return root;
        if(root.val <= q.val && root.val >= p.val) return root;
        if(root.val < p.val)
            return lowestCommonAncestor(root.right, p, q);
        return lowestCommonAncestor(root.left, p, q);
    }
}
