package Tree;

import com.main.TreeNode;

public class LC222CountCompleteTreeNodesBrutalForce {
    private int count;
    public int countNodes(TreeNode root) {
        inOrder(root);
        return count;
    }
    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        count++;
        inOrder(root.right);
    }
}
