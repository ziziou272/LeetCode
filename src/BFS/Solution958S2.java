/*
package BFS;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *//*

public class Solution958S2 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        boolean flag = false;
        while (!que.isEmpty()) {
            TreeNode pollNode = que.poll();
            if (pollNode != null && flag == true) return false;
            if (pollNode == null) {flag = true;}
            //System.out.println(pollNode.value); //visit
            else
            {
                que.offer(pollNode.left);
                que.offer(pollNode.right);
            }
        }
        return true;
    }
}
*/
