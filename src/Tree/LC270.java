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

/**
 *
 Q3 Largest Smaller Binary Search Tree Value OR largest smaller or equals
                15 (root)  19	→ 1	18
           /	        \
         5		         20
 /           \               /      \
 3	     14          18     23
 18.5
 */
class followUpSolution{
    public int largestSmaller(TreeNode root, double target){
        int res = root.val;
        while(root != null){

            if(root.val < target) {
                if (Math.abs(root.val - target) < Math.abs(res - target))
                    res = root.val;
                root = root.left;
            }
            else
                root = root.right;
        }
        return res;
    }
}
