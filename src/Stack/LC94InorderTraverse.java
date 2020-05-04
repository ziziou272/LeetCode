package Stack;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC94InorderTraverse {
    public List<Integer> inorderTraversal(TreeNode root) {
        //cc
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode cur = root;
        Stack<TreeNode> treeStack = new Stack<>();
        while(cur != null || !treeStack.isEmpty()){
            if(cur != null){
                treeStack.push(cur);
                cur = cur.left;
            }
            else{
                cur = treeStack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
