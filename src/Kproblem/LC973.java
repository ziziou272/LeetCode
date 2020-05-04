package Kproblem;

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
