package Tree;

import com.main.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC95 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return dfs(1, n);
    }
    private List<TreeNode> dfs(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){ 
            res.add(null);
            return res;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> leftNodes = dfs(start, i - 1);
            List<TreeNode> rightNodes = dfs(i + 1, end);
            for(TreeNode leftNode : leftNodes){
                for(TreeNode rightNode : rightNodes){
                    TreeNode cur = new TreeNode(i);
                    cur.left = leftNode;
                    cur.right = rightNode;
                    res.add(cur);
                }
            }
        }
        return res;
    }
}
