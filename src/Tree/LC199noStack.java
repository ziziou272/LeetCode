package Tree;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC199noStack {
    public List<Integer> rightSideView(TreeNode root) {
        //right boundary
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        rightView(root, res, 0);
        return res;
    }
    private void rightView(TreeNode root, List<Integer> res, int depth){
        if(root == null) return;
        if(depth == res.size()) res.add(root.val);
        rightView(root.right, res, depth + 1);
        rightView(root.left, res, depth + 1);
    }
}
