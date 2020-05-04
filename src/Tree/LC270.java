package Tree;

import com.main.TreeNode;

public class LC270 {
    public int closestValue(TreeNode root, double target) {
        int min = root.val;
        return closestValue(root,target,min);
    }

    private int closestValue(TreeNode root, double target, int min){
        if(root == null)
            return min;
        if(Math.abs(root.val - target) < Math.abs(min - target))
            min = root.val;
        if (root.val < target)
           return closestValue(root.right, target, min);
        else
            return closestValue(root.left, target, min);
    }
}
