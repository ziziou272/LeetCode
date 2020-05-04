package Tree;

import com.main.TreeNode;

public class LC333 {
    private class result{
        int min, max, size;
        public result(int min, int max, int size){
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        int[] maxLen = new int[1];
        dfs(root, maxLen);
        return maxLen[0];
    }

    private result dfs(TreeNode root, int[] maxLen){
        if(root == null) return new result(0, 0, 0);
        result leftRes = dfs(root.left, maxLen);
        result rightRes = dfs(root.right, maxLen);
        if(leftRes == null || rightRes == null) return null;
        //validate
        int size = 1;
        if((leftRes.size == 0 || leftRes.max < root.val) && (rightRes.size == 0 || rightRes.min > root.val)){
            size = size + leftRes.size + rightRes.size;
        }
        else
            return null;
        maxLen[0] = Math.max(maxLen[0], size);
        int min = leftRes.size == 0 ? root.val : leftRes.min;
        int max = rightRes.size == 0 ? root.val : rightRes.max;
        return new result(min, max, size);
    }
}
