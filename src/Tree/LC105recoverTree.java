package Tree;

import com.main.TreeNode;

public class LC105recoverTree {
}
class SolutionLC105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int index, int left, int right){
        if(left > right) return null;
        TreeNode cur = new TreeNode(preorder[index]);
        //get index from inorder
        int i = getIndex(inorder, cur.val);
        cur.left = helper(preorder, inorder, index + 1, left, i - 1);
        cur.right = helper(preorder, inorder, i + index - left + 1, i + 1, right);
        return cur;
    }
    private int getIndex(int[] inorder, int val){
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == val)
                return i;
        }
        return -1;
    }
}
/*

preorder find root node, get root node position at inorder array
left side is left children right side is right children

            3
        9      20
             15   7



*/