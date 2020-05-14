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
class NewSolution{
    //2020/05/14
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) return null;
        TreeNode newRoot = root;
        if(root.left != null){
            newRoot = upsideDownBinaryTree(root.left);
            root.left.left = upsideDownBinaryTree(root.right);
            root.left.right = root;
        }
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
