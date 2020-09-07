package AamazonOA2_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EmployeeNode{
    public int value;
    public ArrayList<EmployeeNode> subEmployeeNode;
    public EmployeeNode(){
        subEmployeeNode = new ArrayList<>();
    }
    public EmployeeNode(int tenure){
        value = tenure;
        subEmployeeNode = new ArrayList<>();
    }
}
public class BusinessNode {
    public static EmployeeNode getBusinessNode(EmployeeNode president){
        if(president == null) return null;
        EmployeeNode[] manager = new EmployeeNode[1];
        int[]max = new int[1];
        helper(president, manager, max);
        return manager[0];
    }

    //int[]{count, sum}
    private static int[] helper(EmployeeNode cur, EmployeeNode[] manager, int[]max){
        if(cur == null || cur.subEmployeeNode.size() == 0) return new int[]{0, 0};
        int count = 0, sum = 0;
        for (EmployeeNode employee : cur.subEmployeeNode){
            count += helper(employee, manager, max)[0];
            sum += helper(employee, manager, max)[1];
        }
        int curValue = (sum + cur.value) / (count + 1);
        if(curValue > max[0]){
            max[0] = curValue;
            manager[0] = cur;
        }
        return new int[]{count, sum};
    }

    public static void main(String[] args) {
        System.out.println("Test case 1");
        EmployeeNode president1 = new EmployeeNode(4);
        EmployeeNode em1 = new EmployeeNode(3);
        EmployeeNode em2 = new EmployeeNode(6);
        president1.subEmployeeNode.add(em1);
        president1.subEmployeeNode.add(em2);
        EmployeeNode em3 = new EmployeeNode(2);
        EmployeeNode em4 = new EmployeeNode(4);
        em1.subEmployeeNode.add(em3);
        em1.subEmployeeNode.add(em4);
        EmployeeNode em5 = new EmployeeNode(5);
        EmployeeNode em6 = new EmployeeNode(8);
        EmployeeNode em7 = new EmployeeNode(1);
        em2.subEmployeeNode.add(em5);
        em2.subEmployeeNode.add(em6);
        em2.subEmployeeNode.add(em7);
        System.out.println(getBusinessNode(president1).value);

        System.out.println("Test case 2");
        EmployeeNode president2 = new EmployeeNode(12);
        EmployeeNode em1_1 = new EmployeeNode(0);
        EmployeeNode em1_2 = new EmployeeNode(10);
        EmployeeNode em1_3 = new EmployeeNode(9);
        president1.subEmployeeNode.add(em1_1);
        president1.subEmployeeNode.add(em1_2);
        em1_2.subEmployeeNode.add(em1_3);
        System.out.println(getBusinessNode(president1).value);

        System.out.println("Test case 3");
        EmployeeNode president3 = new EmployeeNode(20);
        EmployeeNode em2_1 = new EmployeeNode(12);
        EmployeeNode em2_2 = new EmployeeNode(18);
        president1.subEmployeeNode.add(em2_1);
        president1.subEmployeeNode.add(em2_2);
        EmployeeNode em2_3 = new EmployeeNode(11);
        EmployeeNode em2_4 = new EmployeeNode(2);
        EmployeeNode em2_5 = new EmployeeNode(3);
        em2_1.subEmployeeNode.add(em2_3);
        em2_1.subEmployeeNode.add(em2_4);
        em2_1.subEmployeeNode.add(em2_5);
        EmployeeNode em2_6 = new EmployeeNode(15);
        EmployeeNode em2_7 = new EmployeeNode(8);
        em2_2.subEmployeeNode.add(em2_6);
        em2_2.subEmployeeNode.add(em2_7);
        System.out.println(getBusinessNode(president1).value);

    }
}
class Test5 {
    double maxAvg;
    TreeNode maxNode;
    public TreeNode getMaximumAverage(TreeNode root) {
        maxAvg = Double.MIN_VALUE;
        maxNode = null;
        findMinAvg(root);
        return maxNode;
    }

    private double[] findMinAvg(TreeNode root) {
        if (root == null) {
            return new double[]{0, 0}; //sum, nodes
        }
        double nodes = 1;
        double curSum = root.val;
        if (root.children != null) {
            for (TreeNode node : root.children) {
                double[] curPair = findMinAvg(node);
                curSum += curPair[0];
                nodes += curPair[1];
            }
        }

        double avg = curSum / nodes;
        if (avg > maxAvg && nodes > 1) {
            maxAvg = avg;
            maxNode = root;
        }
        return new double[]{curSum, nodes};
    }

    static class TreeNode {
        public int val;
        public List<TreeNode> children;
        public TreeNode() {}
        public TreeNode(int _val) { val = _val; }
        public TreeNode(int _val, List<TreeNode> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        // Input:
        //              20
        //            /   \
        //          12     18
        //       /  |  \   / \
        //     11   2   3 15  8
        TreeNode left = new TreeNode(12);
        left.children = Arrays.asList(new TreeNode(11), new TreeNode(2), new TreeNode(3));

        TreeNode right = new TreeNode(18);
        right.children = Arrays.asList(new TreeNode(15), new TreeNode(8));

        TreeNode root = new TreeNode(20);
        root.children = Arrays.asList(left, right);

        test(root); // output: 18
    }

    private static void test(TreeNode root) {
        TreeNode maxTreeNode = new Test5().getMaximumAverage(root);
        System.out.println("Max Average: " + maxTreeNode.val);
    }
}