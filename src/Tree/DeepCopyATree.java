package Tree;

import com.main.TreeNode;
import com.sun.source.tree.Tree;

public class DeepCopyATree {
    public TreeNode deepCopy(TreeNode root){
        if(root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = deepCopy(root.left);
        newRoot.right = deepCopy(root.right);
        return newRoot;
    }
}
