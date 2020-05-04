package Tree;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class treeInorderIterative {
}
class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res =  new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!= null || !stack.isEmpty()){
            //add cur to stack and go left
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            else{
                //add res
                cur = stack.pop();
                res.add(cur.val);
                //go right
                cur = cur.right;
            }
        }
        return res;
    }
}