package Tree;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC114flatternBT {
}

class SolutionPreOrder {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        //2
        if(root == null) return;
        if(prev != null)
            prev.right = root;
        prev = root;
        TreeNode temp = root.right;
        flatten(root.left);
        flatten(temp);
        root.left = null;
    }
}
class SolutionRecursion{
    /**
     * this one have no global variable
     */
    public void flatten(TreeNode root) {
        helper(root);
    }
    private TreeNode helper(TreeNode root){
        if(root == null) return null;
        if(root.left == null && root.right == null)
            return root;
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        if(left != null){
            left.right = root.right;
            left.left = null;
            root.right = root.left;
        }
        root.left = null;
        return right == null ? left : right;
    }
}
class SolutionIterative{
    public void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode cur = null, prev = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            cur = stack.pop();
            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
            if(prev != null){
                prev.left = null;
                prev.right = cur;
            }
            prev = cur;
        }
    }
}