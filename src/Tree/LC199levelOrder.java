package Tree;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199levelOrder {
    /*
   Level order traverse to find the last one int each level
   */
    public List<Integer> rightSideView(TreeNode root) {
        //cc
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                //most right
                if(size == 0) res.add(cur.val);
            }
        }
        return res;
    }
}
