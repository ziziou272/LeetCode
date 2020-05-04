package Tree;
import com.main.TreeNode;

import java.util.*;


public class preOrderIterative {
}
class SolutionLC144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res =  new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur == null){
                cur = stack.pop();
                cur = cur.right;
            }else{
                stack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }
        }
        return res;
    }
}