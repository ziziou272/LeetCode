package Tree;

import com.main.TreeNode;

public class LC250 {
    public int countUnivalSubtrees(TreeNode root) {
        //O(n)
        int[] count = new int[1];
        dfs(root, 0, count);
        return count[0];
    }
    private boolean dfs(TreeNode root, int target, int[] count){
        //base case
        if(root == null) return true;
        boolean leftRes = dfs(root.left, root.val, count);
        boolean rightRes = dfs(root.right, root.val, count);
        if(leftRes && rightRes){
            count[0]++;
            return root.val == target;
        }
        return false;
    }
}
class SolutionLC250 {
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        int[] count = new int[1];
        check(root, count);
        return count[0];
    }
    private boolean check(TreeNode root, int[] count){
        if(root == null) return true;
        boolean leftRes = check(root.left, count);
        boolean rightRes = check(root.right, count);
        if(root.left == null && root.right == null){
            count[0]++;
            return true;
        }
        if(leftRes && rightRes){
            if(root.left != null && root.right != null){
                if(root.right.val == root.val && root.left.val == root.val)
                    count[0]++;
                return true;
            }else if(root.right != null && root.right.val == root.val){
                count[0]++;
                return true;
            }else if(root.left != null && root.left.val == root.val){
                count[0]++;
                return true;
            }
        }
        return false;
    }
}
