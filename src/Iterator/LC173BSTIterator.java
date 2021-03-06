package Iterator;

import com.main.TreeNode;

import java.util.Iterator;
import java.util.Stack;

public class LC173BSTIterator {
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = stack.pop();
        TreeNode cur = res.right;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        return res.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();

    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */