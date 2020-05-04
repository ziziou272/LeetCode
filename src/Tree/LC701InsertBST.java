package Tree;

import com.main.TreeNode;

public class LC701InsertBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
        {
            root = new TreeNode(val);
            return root;
        }
        if(val > root.val){
            root.right = insertIntoBST(root.right,val);
        }
        else
            root.left = insertIntoBST(root.left,val);
        return root;

    }
}
