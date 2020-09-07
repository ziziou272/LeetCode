package AamazonOA2_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquaredShortestPath {
    public static void main(String[] args) {

    }

    static class Point {
        public long x;
        public long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    public static long squaredDistance(int numRobots, List<Integer> positionX, List<Integer> positionY) {
        Point[] points = new Point[numRobots];
        for (int i = 0; i < numRobots; i++) {
            points[i] = new Point(positionX.get(i), positionY.get(i));
        }
        //pre-processing:基于x坐标排序
        Arrays.sort(points, (a, b) -> Long.compare(a.x, b.x));
        return divide(0, numRobots - 1, points);
    }

    public static long divide(int left, int right, Point[] points) {
        long curMinDis = Integer.MAX_VALUE;
        //如果只有一个点，返回无穷大
        if (left == right) {
            return curMinDis;
        }
        //如果只有两个点，直接求解
        if (left + 1 == right) {
            return distance(points[left], points[right]);
        }
        // 分治法：第一步：分区，并求取左右分区最小两点距离
        // 对区域进行合理的划分，使得左右两边保持大致相等个数点
        int middle = left + (right - left) / 2;
        long leftMinDis = divide(left, middle, points);
        long rightMinDis = divide(middle, right, points);

        curMinDis = Math.min(leftMinDis, rightMinDis);

        // 分治法：第二步：假设距离最近的两点分别在左右分区中
        // 关键代码，距离最近的两个点，一个位于左边区域，一个位于右边区域，x轴搜索范围[middle-curMinDis, middle+curMinDis]
        // 记录搜索区间内的点的索引，便于进一步计算最小距离
        List<Integer> validPointIndex = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (Math.abs(points[middle].x - points[i].x) <= curMinDis) {
                validPointIndex.add(i);
            }
        }
        // 基于索引，进一步计算区间内最小两点距离
        for (int i = 0; i < validPointIndex.size() - 1; i++) {
            for (int j = i + 1; j < validPointIndex.size(); j++) {
                // 如果区间内的两点y轴距离大于curMinDis，则没必要计算了，因为，它们的距离肯定大于curMinDis
                if (Math.abs(points[validPointIndex.get(i)].y - points[validPointIndex.get(j)].y) > curMinDis) {
                    continue;
                }
                long tempDis = distance(points[validPointIndex.get(i)], points[validPointIndex.get(j)]);
                curMinDis = Math.min(tempDis, curMinDis);
            }
        }
        return curMinDis;
    }
    public static long distance(Point p1, Point p2) {
        return (p2.y - p1.y) * (p2.y - p1.y) + (p2.x - p1.x) * (p2.x - p1.x);
    }
}
