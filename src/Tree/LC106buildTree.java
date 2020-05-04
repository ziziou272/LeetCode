package Tree;

import com.main.TreeNode;

public class LC106buildTree {
    /*
          left       right
        inorder = [9        15,20,7]
        postorder = [9, 15,7,20]
        find root
        3
*/
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int pStart,int pEnd){
        if(inStart > inEnd) return null;
        int rootVal = postorder[pEnd];
        //find the value in inorder
        int i = inStart;
        for(; i < inEnd; i++){
            if(inorder[i] == rootVal) break;
        }
        //build root
        TreeNode root = new TreeNode(rootVal);
        //divide to left and right
        root.left = build(inorder, inStart, i - 1, postorder, pStart, pStart + i - 1 -inStart);
        root.right = build(inorder,i + 1, inEnd, postorder, pStart + i - inStart, pEnd - 1);
        return root;
    }
}
