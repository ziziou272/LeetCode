package Tree;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC272Revised {

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
        while(res.size() < k) {
            double left;
            double right;
            if (!ls.isEmpty() && !rs.isEmpty()){
                left = Math.abs(ls.peek().val - target);
                right = Math.abs(rs.peek().val - target);
                if(left > right)
                    res.add(getNextRight(rs));
                else {
                    res.add(getNextLeft(ls));
                }
            }
            else if(rs.isEmpty()){
                res.add(getNextLeft(ls));
            }
            else{
                res.add(getNextRight(rs));
            }
        }
        return res;
    }
}

/**
 * 2020/04/24 submit, pay attention to empty stack and while(k-- > 0) 2 times problem
 */
class SolutionLC272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        while(root != null){
            if(root.val < target){
                leftStack.push(root);
                root = root.right;
            }
            else{
                rightStack.push(root);
                root = root.left;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(k> 0 && !rightStack.isEmpty() && !leftStack.isEmpty() ){
            k--;
            TreeNode leftNode = leftStack.peek();
            TreeNode rightNode = rightStack.peek();
            if(Math.abs(leftNode.val - target) < Math.abs(rightNode.val - target)){
                res.add(leftNode.val);
                popLeft(leftNode, leftStack);
            }else{
                res.add(rightNode.val);
                popRight(rightNode, rightStack);
            }
        }
        while(k-- > 0){
            if(!leftStack.isEmpty()){
                TreeNode leftNode = leftStack.peek();
                res.add(leftNode.val);
                popLeft(leftNode, leftStack);
            } else if(!rightStack.isEmpty()){
                TreeNode rightNode = rightStack.peek();
                res.add(rightNode.val);
                popRight(rightNode, rightStack);
            }else
                return res;
        }
        return res;
    }
    private void popLeft(TreeNode root, Stack<TreeNode> stack){
        stack.pop();
        root = root.left;
        while(root != null){
            stack.push(root);
            root = root.right;
        }
    }
    private void popRight(TreeNode root, Stack<TreeNode> stack){
        stack.pop();
        root = root.right;
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
}
/*
solution1:
n  k log(k)
minHeap smaller than target       maxHeap greater than target  total = k

s2:

1 2 3 4 5
    r l    do it as a array

left stack(smaller than target)         right stack (larger than target)
                3
                2                            4
               /                             \
              1                               5
*/

/**
 * 1. since we need k closet values, so we need some data structure to store and update these k values
 * 2. we could use a maxHeap(sort by difference) update during traverse o(n) * log(k)
 * 3. if it is an array:  1 2 3 4 5
 *                              t
 *             log(n) + k
 * 4. so for the tree, we could divide the tree by the closet target ->
 * smaller and greater ->get closet each time
 * 5/ to do that, I need 2 stacks to store the left and right part of the trees
 *
 * Input: root = [4,2,5,1,3], target = 2.414286, and k = 2
 *
 *                2                  3
 *     4         /                     \
 *    / \                              4
 *   2   5
 *   \
 *  / \
 * 1   3         left(smaller)           right
 *   2.5 3.5
 */
class solutionCleaner272{
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null || k == 0) return res;
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        //divide to 2 parts
        while(root != null){
            if(root.val <= target){
                //push to left stack
                leftStack.push(root);
                root = root.right;
            }else{
                rightStack.push(root);
                root = root.left;
            }
        }
        //add k res
        while(!leftStack.isEmpty() && !rightStack.isEmpty() && res.size() < k){
            int leftPeek = leftStack.peek().val, rightPeek = rightStack.peek().val;
            if(Math.abs(leftPeek - target) < Math.abs(rightPeek - target)){
                //pop left
                res.add(leftPeek);
                //todo:
                popLeft(leftStack);
            }else{
                res.add(rightPeek);
                //todo:
                popRight(rightStack);
            }
        }
        while(res.size() < k){
            if(!leftStack.isEmpty()){
                res.add(leftStack.peek().val);
                popLeft(leftStack);
            }else{
                res.add(rightStack.peek().val);
                popRight(rightStack);
            }
        }
        return res;
    }
    private void popLeft(Stack<TreeNode> leftStack){
        TreeNode cur = leftStack.pop();
        cur = cur.left;
        while(cur != null){
            leftStack.push(cur);
            cur = cur.right;
        }
    }
    private void popRight(Stack<TreeNode> rightStack){
        TreeNode cur = rightStack.pop();
        cur = cur.right;
        while(cur != null){
            rightStack.push(cur);
            cur = cur.left;
        }
    }
}