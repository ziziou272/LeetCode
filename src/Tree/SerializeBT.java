package Tree;

import com.main.TreeNode;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeBT {
}
//dfs
class Codec {
    private void preOrder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return;
        }
        int val = root.val;
        sb.append(root.val).append(",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        //remove trailing ","
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] strs = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for(String str : strs){
            if(str.equals("#"))
                queue.add(null);
            else
                queue.add(Integer.parseInt(str));
        }
        return recover(queue);
    }

    private TreeNode recover(Queue<Integer> q){
        //if(q.size() == 0) return null;
        //"#"
        if(q.peek() == null) {
            q.poll();
            return null;
        }
        int val = q.poll();
        TreeNode root = new TreeNode(val);
        root.left = recover(q);
        root.right = recover(q);
        return root;
    }
}
class solutionBFS{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null)
                sb.append("#").append(",");
            else{
                sb.append(cur.val).append(",");
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        String[] strs = data.split(",");
        Queue<Integer> nums = new LinkedList<>();
        for(String str : strs){
            if(str.equals("#"))
                nums.add(null);
            else
                nums.add(Integer.parseInt(str));
        }
        Queue<TreeNode> q = new LinkedList<>();
        Integer num = nums.poll();
        TreeNode root = new TreeNode(num);
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            Integer leftVal = nums.poll();
            Integer rightVal = nums.poll();
            cur.left = leftVal == null ? null : new TreeNode(leftVal);
            cur.right = rightVal == null ? null : new TreeNode(rightVal);
            if(cur.left != null)
                q.offer(cur.left);
            if(cur.right != null)
                q.offer(cur.right);
        }
        return root;
    }
}











