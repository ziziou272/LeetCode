package Tree;

import com.main.TreeNode;

public class LC114nonStack {
    public void flatten(TreeNode root) {
        /*
                root
                    rightNode
            lefNode         rightNode
             1
          2     3
         3    4    5
             4  4 4  4

        */
        //cc
        if(root == null) return;
        TreeNode cur = root;
        while(cur != null){
            //check if have left child
            if(cur.left != null){
                moveToRight(cur, cur.left);
                cur.left = null;
            }
            cur = cur.right;
        }
    }
    private void moveToRight(TreeNode cur, TreeNode left){
        if(cur.right == null){
            cur.right = left;
        }
        else{
            TreeNode temp = cur.right;
            cur.right = left;
            TreeNode mostRight = left;
            while(mostRight.right != null){
                mostRight = mostRight.right;
            }
            mostRight.right = temp;
        }
    }
}
