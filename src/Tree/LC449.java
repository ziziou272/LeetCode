package Tree;

import com.main.TreeNode;

import java.util.Stack;

public class LC449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //postOrder
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //split to charArray
        String[] dataArray = data.split("");
        //to int array
        int[] nums = new int[dataArray.length];
        for(int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(dataArray[i]);
        return buildTree(nums, 0, dataArray.length - 1);

    }
    //postOrder traverse
    private void postOrder(TreeNode root, StringBuilder sb){
        if(root == null) return;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val + ' ');
    }
    private TreeNode buildTree(int[] data, int start, int end){
        if(start > end) return null;
        //find cur root
        int rootVal = data[end];
        TreeNode root = new TreeNode(rootVal);
        //find the right side start index
        int index = findBoundary(data, rootVal, start, end - 1);
        root.left = buildTree(data, start, index - 1);
        root.right = buildTree(data, index, end);
        return root;
    }
    private int findBoundary(int[] data, int val, int start, int end){
        //find the first one greater than 8
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid - 1 >= 0 && data[mid] > val && data[mid - 1] < val)
                return mid;
            else if(data[mid] < val)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
class CodecBST {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        preOrder(root, sb);
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val).append(",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }
    /*
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        if(arr == null || arr.length == 0) return null;
        int i = arr.length - 1;
        return dfs(arr, new int []{i}, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    */

    /*
    deserialize using stack
            5
        3       8
   1      4   6   10
               7  9  12
     2                  16

5,3,1,2,4,8,6,7,10,9,12,16
        i



5

when right child is added this root/node will not be useful
    */
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        String[] arr = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        TreeNode cur = root;
        stack.push(cur);
        while(index < arr.length){
            int curVal = Integer.parseInt(arr[index++]);
            cur = new TreeNode(curVal);
            TreeNode top = stack.peek();
            if(curVal < top.val){
                top.left = cur;
                stack.push(cur);
                continue;
            }
            //
            while(!stack.isEmpty() && stack.peek().val < curVal){
                top = stack.pop();
            }
            top.right = cur;
            stack.push(cur);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;


