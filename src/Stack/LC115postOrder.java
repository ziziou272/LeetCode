package Stack;

import com.main.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC115postOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> treeStack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        treeStack.push(cur);
        while(!treeStack.isEmpty()){
            cur = treeStack.peek();
            // status 1
            if(prev == null || prev.left == cur || prev.right == cur){
                if(cur.left != null){
                    treeStack.push(cur.left);
                }
                else if(cur.right != null){
                    treeStack.push(cur.right);
                }
                else{
                    res.add(cur.val);
                    treeStack.pop();
                }
            }
            else if(prev == cur.left){
                if(cur.right != null){
                    treeStack.push(cur.right);
                }
                else{
                    res.add(cur.val);
                    treeStack.pop();
                }
            }
            else{
                res.add(cur.val);
                treeStack.pop();
            }
            prev = cur;
        }
        return res;
    }
}
