package Graph;

import java.util.*;

public class LC587 {
}
class Solution {
    public int[][] outerTrees(int[][] points) {
        if (points.length == 1) {
            return points;
        }
        int n = points.length;
        Arrays.sort(points,(a, b) -> a[1] == b[1] ? a[0]-b[0]:a[1]-b[1]);
        HashSet<ArrayList<Integer>> dup = new HashSet();
        List<int[]> res = new ArrayList<>();
        Stack<int[]> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);
        // Graham scan;
        for (int i = 2; i < n; i++) {
            int[] top = stack.pop();
            while (!stack.isEmpty() && ccw(stack.peek(), top, points[i]) < 0) {
                top = stack.pop();
            }
            stack.push(top);
            stack.push(points[i]);
        }
        for(int i = n-2;i>=0;i--) {
            int[] top = stack.pop();
            while (!stack.isEmpty() && ccw(stack.peek(), top, points[i]) < 0) {
                top = stack.pop();
            }
            stack.push(top);
            stack.push(points[i]);
        }
        for(int[] x: stack) {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(x[0]);tmp.add(x[1]);
            if(dup.contains(tmp)) continue;
            dup.add(tmp);
            res.add(x);
        }
        int[][] arr = new int[res.size()][2];
        for(int i = 0; i < res.size(); i++){
            arr[i][0] = res.get(i)[0];
            arr[i][1] = res.get(i)[1];
        }
        return arr;
    }
    public int ccw(int[] a, int[] b, int[] c) {
        double area2 = (b[0]-a[0])*(c[1]-a[1]) - (b[1]-a[1])*(c[0]-a[0]);
        if (area2 < 0) return -1;
        else if (area2 > 0) return +1;
        else return  0;
    }
}