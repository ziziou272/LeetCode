/*
package BFS;

import javax.swing.tree.TreeNode;
import java.util.*;

public class LC107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List <List<Integer>> res = new ArrayList<List<Integer>>();
        //  List <List<Integer>> res = new ArrayList <List<Integer>>();

        if (root == null)
            return res;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(! que.isEmpty())
        {
            int size = que.size();
            List<Integer> curLevel = new ArrayList<>();
            for(int i = 0;i < size;i++) {// this for loop is used to print in level order
                TreeNode pollNode = que.poll();

                curLevel.add(pollNode.val);
                if(pollNode.left != null)
                    que.offer(pollNode.left);
                if(pollNode.right != null)
                    que.offer(pollNode.right);
            }
            res.add(curLevel);
        }
        Collections.reverse(res);
        return res;
    }
}
*/
