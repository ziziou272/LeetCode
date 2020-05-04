package Tree;

import com.main.TreeNode;

public class LC285 {
    //can not deal with duplicate
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        if(root == null || p == null)
            return null;
        TreeNode cur = root;

        while(cur != null){
            if(cur.val > p.val){
                res = cur;
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
        }
        return res;
    }
}
