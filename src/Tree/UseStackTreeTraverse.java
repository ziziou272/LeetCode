package Tree;

import com.main.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Stack;

public class UseStackTreeTraverse {
    private void getFromLS(Stack<TreeNode> ls){
        TreeNode top = ls.pop();
        TreeNode cur = top.right;
        while(cur != null){
            ls.push(cur);
            cur = cur.left;
        }
    }

    private void getFromRS(Stack<TreeNode> rs){
        TreeNode top = rs.pop();
        TreeNode cur = top.left;
        while(cur != null){
            rs.push(cur);
            cur = cur.right;
        }
    }

    private boolean stackTravers(TreeNode root, int target){
        Stack<TreeNode> ls = new Stack<>();
        Stack<TreeNode> rs = new Stack<>();

        //Initialize ls
        TreeNode cur = root;
        while(cur != null){
            ls.push(cur);
            cur = cur.left;
        }

        //initialize rs
        cur = root;
        while(cur != null){
            rs.push(cur);
            cur = cur.right;
        }

        while(!ls.isEmpty() && !rs.isEmpty()){
            TreeNode left = ls.peek();
            TreeNode right = rs.peek();
            if(left.val + right.val == target)
                return true;
            else if(left.val + right.val < target)
                getFromLS(ls);
            else if(left.val + right.val > target)
                getFromRS(rs);
        }
        return false;
    }

}
