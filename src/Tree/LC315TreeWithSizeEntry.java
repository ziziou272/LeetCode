package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC315TreeWithSizeEntry {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> counts = new ArrayList<>();
        if(nums.length == 0) return counts;
        TreeNode root = new TreeNode(nums[len-1]);
        counts.add(0);
        for(int i = len - 2; i >= 0; i--){
            TreeNode cur = root;
            TreeNode prev = null;
            int count = 0;
            while(cur != null){
                //go left
                if(nums[i] <= cur.val){
                    cur.size++;
                    prev = cur;
                    cur = cur.left;
                    if(cur == null)
                        prev.left = new TreeNode(nums[i]);
                }else{
                    count += cur.size;
                    prev = cur;
                    cur = cur.right;
                    if(cur == null)
                        prev.right = new TreeNode(nums[i]);
                }
            }
            counts.add(count);
        }
        Collections.reverse(counts);
        return counts;
    }

    class TreeNode{
        private int val;
        private int size;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val){
            this.val = val;
            size = 1;
        }
    }
}
