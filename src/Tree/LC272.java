package Tree;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*


    4        t = 3.7           k = 3                      3
   / \                                                    1,2                               5
 2   5                 3 4     5
 / \                                                    stack1                          stack2
1   3                                                   smaller than target              greater

            res:4, 3, 5
            [1 2 3 4 5]
               l     r



        */
public class LC272 {

    private int getNextLeft(Stack<TreeNode> ls){
        TreeNode top = ls.pop();
        int val = top.val;
        TreeNode cur = top.left;
        while(cur != null){
            ls.push(cur);
            cur = cur.right;
        }
        return val;
    }

    private int getNextRight(Stack<TreeNode> rs){
        TreeNode top = rs.pop();
        int val = top.val;
        TreeNode cur= top.right;
        while(cur != null)
        {
            rs.push(cur);
            cur = cur.left;
        }
        return val;
    }
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        //You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
        //todo:cc
        if(root == null)
            return res;

        //initialize 2 stacks
        Stack<TreeNode> ls = new Stack<>();
        Stack<TreeNode> rs = new Stack<>();

        TreeNode cur = root;
        //push node to right stack and left stack
        while(cur != null){
            if(cur.val < target){
                ls.push(cur);
                cur = cur.right;
            }
            else {
                rs.push(cur);
                cur = cur.left;
            }
        }
        //ls or rs not empty
        while(res.size()< k && (!ls.isEmpty() || !rs.isEmpty())){
            double left;
            double right;
            if(!ls.isEmpty())
                left = Math.abs(ls.peek().val - target);
            else {
                left = Double.MAX_VALUE;
            }
            if(!rs.isEmpty()){
                right = Math.abs(rs.peek().val - target);
            }
            else
                right = Double.MAX_VALUE;

            if(left > right){
                //right++
                res.add(getNextRight(rs));
            }
            else {
                //todo:get next left
                res.add(getNextLeft(ls));
            }
        }
        return res;
    }
}
