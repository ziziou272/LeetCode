package Kproblem;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC230inorder {
    //inorder traverse the kth is the result
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;
        int[] res = new int[]{0};
        List<Integer> myList = new ArrayList<>();
        inorder(myList, root, k);
        return myList.get(k - 1);
    }

    private void inorder(List myList, TreeNode root, int k){
        if(myList.size() == k || root == null)
            return;
        inorder(myList, root.left, k);
        myList.add(root.val);
        inorder(myList, root.right, k);
    }
}
