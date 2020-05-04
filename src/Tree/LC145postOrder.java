package Tree;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145postOrder {
}
class SolutionLC145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res =  new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null, prev = null;
        stack.push(root);
        while(!stack.isEmpty()){
            cur = stack.peek();
            if(prev == null || cur == prev.left || cur == prev.right){
                if(cur.left != null){
                    stack.push(cur.left);
                } else if(cur.right != null){
                    stack.push(cur.right);
                } else{
                    res.add(stack.pop().val);
                }
            }
            else if(prev == cur.left){
                if(cur.right != null){
                    stack.push(cur.right);
                } else{
                    res.add(stack.pop().val);
                }
            }
            else{
                res.add(stack.pop().val);
            }
            prev = cur;
        }
        return res;
    }
}
