package Recursion;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        int curSum = 0;
        List<Integer> level = new ArrayList<>();
        pathSum(root,sum,curSum,res,level);
        return res;
    }
    private void pathSum(TreeNode root, int sum, int curSum, List<List<Integer>> res, List<Integer> level){
        curSum += root.val;
        level.add(root.val);
        if(root.left == null && root.right == null){
            if (curSum == sum){
                res.add(new ArrayList<>(level));
            }
/*            level.remove(level.size() - 1);
            curSum = curSum - root.val;*/
            return;
        }
        if(root.left != null){
            //level.add(root.left.val);
            pathSum(root.left,sum,curSum,res,level);
            level.remove(level.size() - 1);
        }
        if(root.right != null){
            //level.add(root.right.val);
            pathSum(root.right,sum,curSum,res,level);
            level.remove(level.size() - 1);
        }
    }
}
