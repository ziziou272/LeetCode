package Tree;

import com.main.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LC653HashSet {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> mySet = new HashSet<>();
        return dfs(root, k , mySet);
    }
    private boolean dfs(TreeNode root, int k, Set<Integer> mySet){
        if(root == null) return false;
        if(mySet.contains(k - root.val))
            return true;
        mySet.add(root.val);
        return (dfs(root.left, k , mySet) || dfs(root.right, k, mySet));
    }
}
