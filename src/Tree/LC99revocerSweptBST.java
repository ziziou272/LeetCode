package Tree;

import com.main.TreeNode;

public class LC99revocerSweptBST {
}
/*
    3
1       4
      2

 1 3 2 4

       1
   5        9
7    6    8   11

how to identify where is swapped

prev: min

    7 5 6 1 8 9 11

    two times: first prev, second cur
    change value

1 3 2 4 5 6 7 8 9
*/
class SolutionLC99 {
    TreeNode prev = null;
    TreeNode nodeOne = null, nodeTwo = null;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = nodeOne.val;
        nodeOne.val = nodeTwo.val;
        nodeTwo.val = temp;
    }
    private void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(prev != null && root.val < prev.val){
            //first time
            if(nodeOne == null){
                nodeOne = prev;
                //this is to deal with 相邻两个交换
                nodeTwo = root;
            }
            else
                nodeTwo = root;
        }
        prev = root;
        inOrder(root.right);
    }
}
