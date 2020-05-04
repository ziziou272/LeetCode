package Stack;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC114PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        //cc
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode cur = root;
        Stack<TreeNode> treeStack = new Stack<>();
        while(cur != null || !treeStack.isEmpty()){
            if(cur != null){
                treeStack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }
            else{
                cur = treeStack.pop();
                cur = cur.right;
            }
        }
        return res;
    }
}
