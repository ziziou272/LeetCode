package Tree;

import com.main.TreeNode;

public class LC98validBSTinOrder {
    public boolean isValidBST(TreeNode root) {
        long[] prev = new long[]{Long.MIN_VALUE};
        return inOrder(root, prev);
    }
    private boolean inOrder(TreeNode cur, long[] prev){
        if(cur == null) return true;
        if(!inOrder(cur.left, prev))
            return false;
        if(prev[0] >= cur.val)
            return false;
        prev[0] = cur.val;
        if(!inOrder(cur.right, prev))
            return false;
        return true;
    }
}
class solution2{
    public boolean isValidBST(TreeNode root) {
        Integer[] prev = new Integer[1];
        return inOrder(root, prev);
    }
    private boolean inOrder(TreeNode root, Integer[] prev){
        if(root == null) return true;
        if(!inOrder(root.left, prev))
            return false;
        if(prev[0] != null && prev[0] >= root.val)
            return false;
        prev[0] = root.val;
        return inOrder(root.right, prev);
    }
}
