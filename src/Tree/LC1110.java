package Tree;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : to_delete){
            set.add(val);
        }
        List<TreeNode> res = new ArrayList<>();
        helper(root, set, res, true);
        return res;
    }

    private void helper(TreeNode root, HashSet<Integer> set, List<TreeNode> res, boolean isRoot){
        if(root == null) return;
        //dont't delete this node
        if(!set.contains(root.val)){
            if(isRoot)
                res.add(root);
            helper(root.left, set, res, false);
            helper(root.right, set, res, false);
            //remove pointer to children
            if(root.left != null && set.contains(root.left.val)){
                root.left = null;
            }
            if(root.right != null && set.contains(root.right.val)){
                root.right = null;
            }

        }
        else{
            helper(root.left, set, res, true);
            helper(root.right, set, res, true);
            root.left = null;
            root.right = null;
        }

    }
}
