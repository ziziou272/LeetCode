package Tree;

import com.main.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LC549 {
    public int longestConsecutive(TreeNode root) {
        int[] max = new int[1];
        dfs(root, max);
        return max[0];
    }
    //index 0: increasing index1: dec
    private int[] dfs(TreeNode root, int[] max){
        if(root == null) return new int[2];
        int[] res = new int[]{1, 1};
        int[] leftRes = dfs(root.left, max);
        int[] rightRes = dfs(root.right, max);
        if(root.left != null){
            //increasing
            if(root.left.val == root.val - 1){
                res[0] = leftRes[0] + 1;
            }
            else if(root.left.val == root.val + 1)
                res[1] = leftRes[1] + 1;
        }
        if(root.right != null){
            //increasing
            if(root.right.val == root.val - 1){
                res[0] = Math.max(rightRes[0] + 1, res[0]);
            }
            else if(root.right.val == root.val + 1)
                res[1] = Math.max(rightRes[1] + 1, res[1]);
        }
        max[0] = Math.max(res[0] + res[1] - 1, max[0]);
        return res;
    }
    //for debug
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new LC549().longestConsecutive(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
