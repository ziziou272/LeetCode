/*
package BFS;


import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Solution958S1 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        boolean flag = false;
        while( !queue.isEmpty() ) {
            TreeNode nodePoll = queue.poll();

            if(nodePoll.left == null) {
                flag = true;
            }
            else {
                if (flag == true) return false;
                else
                    queue.offer(nodePoll.left);
            }

            if(nodePoll.right == null) {
                flag = true;
            }
            else {
                if (flag == true) return false;
                else
                    queue.offer(nodePoll.right);
            }

        }
        return true;
    }
}
*/
