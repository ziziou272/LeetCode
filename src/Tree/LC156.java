package Tree;

import com.main.TreeNode;

public class LC156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null)
            return null;
        if(root.left == null)
            return root;
        TreeNode cur = root;
        root = upsideDownBinaryTree(root.left);
        cur.left.right = cur;
        cur.left.left = cur.right;
        cur.left = null;
        cur.right = null;
        return root;
    }
}
