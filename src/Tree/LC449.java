package Tree;

import com.main.TreeNode;

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
