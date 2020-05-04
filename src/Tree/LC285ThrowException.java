/*
package Tree;

import com.main.TreeNode;

//if there is no target p in the tree, throw exception
//not finished 不知道啥exception
public class LC285ThrowException {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null)
            return null;
        TreeNode res = null;
        TreeNode cur = root;

        while (cur != null){
            if(cur.val > p.val){
                res = cur;
                cur = cur.left;
            }
            else if(cur.val == p.val){
                if(cur == p)
                {}
                else
                    throw new Runtime(System.out.println("No p  in the tree"));
            }

        }

    }

}
*/
