package Kproblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC973 {//maxHeap
    public int[][] kClosest(int[][] points, int K) {
        //cc
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a1,a2) -> a2[0] * a2[0] + a2[1] * a2[1]  - a1[0] * a1[0] - a1[1] * a1[1]);
        for(int[] point : points){
            maxHeap.offer(point);
            if(maxHeap.size() > K) {
                maxHeap.poll();
            }
            else {
                int x = maxHeap.peek()[0];
                int y = maxHeap.peek()[1];
                int distance = x * x + y * y;
                int curDis = point[0] * point[0] + point[1] * point[1];
                if(distance > curDis){
                    maxHeap.poll();
                    maxHeap.offer(point);
                }
            }
        }
        int[][] res = new int[K][];
        int i = 0;
        while(!maxHeap.isEmpty()){
            res[i++] = maxHeap.poll();
        }
        return res;
    }
}

//sort nlogn
class Solution973 {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                double res = Math.sqrt(a[0] * a[0] + a[1]*a[1]) - Math.sqrt(b[0] * b[0] + b[1]*b[1]);
                if(res == 0) return 0;
                if(res < 0) return -1;
                return 1;
            }
        });
        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++){
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }
}

//quick selection
class Solution973QuickSlect {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k-1);
        int[][]res = new int[k][2];
        for(int i = 0; i < k; i++){
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }

    private void quickSelect(int[][] points, int left, int right, int k){
        int pivotIndex = partition(points, left, right);
        if(pivotIndex == k) return;
        if(pivotIndex < k){
            quickSelect(points, pivotIndex+1,right,k);
        }
        else{
            quickSelect(points,left,pivotIndex-1,k);
        }
    }

    private int partition(int[][] points, int left, int right){
        if(left == right) return left;
        //choose right idnex as pivot
        int i = left - 1;
        for(int j = left; j < right; j++){
            if(compareTwoDistacne(j, right, points) < 0){
                swap(points, ++i, j);
            }
        }
        swap(points, right, ++i);
        return i;
    }

    private void swap(int[][] points, int i, int j){
        if(i < 0 || j < 0 || i >= points.length || j >= points.length)
            return;
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
    private int compareTwoDistacne(int i, int j, int[][] points){
        double res = Math.sqrt(points[i][0]*points[i][0]+points[i][1]*points[i][1]) - Math.sqrt(points[j][0]*points[j][0]+points[j][1]*points[j][1]);
        if(res == 0) return 0;
        //distance i < distanc j
        if(res < 0) return -1;
        return 1;
    }
}