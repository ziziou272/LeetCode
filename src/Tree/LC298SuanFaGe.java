package Tree;

import com.main.TreeNode;

public class LC298SuanFaGe {
    //o(n)
    public int longestConsecutive(TreeNode root) {
        int[] max = new int[1];
        dfs(root, max);
        return max[0];
    }
    private int dfs(TreeNode root, int[] max){
        if(root == null) return 0;
        int leftRes = dfs(root.left, max);
        int rightRes = dfs(root.right, max);
        int localLen = 1;
        if(leftRes != 0 && root.left.val == root.val + 1)
            localLen = leftRes + 1;
        if(rightRes != 0 && root.right.val == root.val + 1)
            localLen = Math.max(rightRes + 1, localLen);
        if(localLen > max[0]) max[0] = localLen;
        return localLen;
    }
}
