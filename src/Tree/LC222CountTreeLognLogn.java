package Tree;

import com.main.TreeNode;
/*
            1
           / \
          2   3
         / \  /\
        4  5 6  7
       /\ /\ /
      8 9 101112

1. brutal force: o(n)
    traverse if root != null count++;
2. log n? getHieght logn
    lh == rh go right
    lh > rh go left
*/
public class LC222CountTreeLognLogn {
    //log^2
    public int countNodes(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode root){
        if(root == null) return 0;
        //logn
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if(leftHeight == rightHeight){//left must be complete tree, so go right
            return 1 + (int) Math.pow(2, leftHeight) - 1 + dfs(root.right);
        }
        else if(leftHeight == rightHeight + 1){//right must be complete tree, go left
            return 1 + (int) Math.pow(2, rightHeight) - 1 + dfs(root.left);
        }
        else{
            throw new IllegalArgumentException("It's not a complete tree");
        }
    }
    private int getHeight(TreeNode root){
        TreeNode cur = root;
        int count = 0;
        while(cur!= null){
            count++;
            cur = cur.left;
        }
        return count;
    }
}