package Tree;

import com.main.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LC272maxHeap {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        //PriorityQueue<TreeNode> maxHeap = new PriorityQueue<>((a1,a2) -> (int)(Math.abs(a1.val - target) - Math.abs(a2.val - target)));
        PriorityQueue<TreeNode> maxHeap = new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode t1, TreeNode t2) {
                return (int)(Math.abs(t1.val - target) - Math.abs(t2.val - target));
            }
        });
        closetKValues(root, target, k, res, maxHeap);
        while(maxHeap.size() > 0){
            res.add(maxHeap.poll().val);
        }
        return res;
    }

    private void closetKValues(TreeNode root, double target, int k, List<Integer> res, PriorityQueue<TreeNode> maxHeap){
        if(root == null) return;
        if(maxHeap.size() < k){
            maxHeap.offer(root);
        }
        else{
            if(Math.abs(maxHeap.peek().val - target) > Math.abs(root.val - target)){
                maxHeap.poll();
                maxHeap.offer(root);
            }
        }
        closetKValues(root.left, target, k , res, maxHeap);
        closetKValues(root.right, target, k, res, maxHeap);
    }
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            line = in.readLine();
            double target = Double.parseDouble(line);
            line = in.readLine();
            int k = Integer.parseInt(line);

            List<Integer> ret = new LC272maxHeap().closestKValues(root, target, k);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
