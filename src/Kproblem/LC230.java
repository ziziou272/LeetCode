package Kproblem;

import com.main.TreeNode;

import java.util.PriorityQueue;
//minHeap o(n)
public class LC230 {

    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
            return -1;
        PriorityQueue<TreeNode> minHeap = new PriorityQueue<>((c1, c2) -> c1.val - c2.val);
        dfs(minHeap, root);
        while(--k > 0){
            minHeap.poll();
        }

        return minHeap.peek().val;

    }

    private void dfs(PriorityQueue minHeap, TreeNode root){
        if(root == null)
            return;
        dfs(minHeap, root.left);
        dfs(minHeap, root.right);
        minHeap.offer(root);
    }
}
