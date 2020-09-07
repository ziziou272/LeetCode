package AamazonOA2_2020;

import com.main.TreeNode;

public class MaximumAverage {
    public static void main(String[] args) {

    }
    public double maximumAverageSubtree(TreeNode root) {
        if(root == null) return 0.0;
        double[] max = new double[1];
        helper(root, max);
        return max[0];
    }
    //return value: [total, count]
    private double[] helper(TreeNode root, double[] max){
        if(root == null) return new double[]{0, 0};
        double[] leftRes = helper(root.left, max);
        double[] rightRes = helper(root.right, max);
        double sum = leftRes[0] + rightRes[0] + root.val;
        double count = 1 + rightRes[1] + leftRes[1];
        double average = sum / count;
        max[0] = Math.max(max[0], average);
        return new double[]{sum, count};
    }
}
