package Tree;

import com.main.TreeNode;

import java.util.Stack;

public class LC653twoStack {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        Stack<TreeNode> as = new Stack<>();
        Stack<TreeNode> des = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            as.push(cur);
            cur = cur.left;
        }
        cur = root;
        while(cur != null){
            des.push(cur);
            cur = cur.right;
        }
        int left = getLeft(as).val;
        int right = getRight(des).val;
        while(left != right){
            if(left + right == k)
                return true;
            if(left + right < k){
                left = getLeft(as).val;
            }
            else{
                right = getRight(des).val;
            }
        }
        return false;
    }

    private TreeNode getLeft(Stack<TreeNode> as){
        TreeNode temp = as.pop();
        TreeNode cur = temp.right;
        while(cur != null){
            as.push(cur);
            cur = cur.left;
        }
        return temp;
    }
    private TreeNode getRight(Stack<TreeNode> des){
        TreeNode temp = des.pop();
        TreeNode cur = temp.left;
        while(cur != null){
            des.push(cur);
            cur = cur.right;
        }
        return temp;
    }
}
