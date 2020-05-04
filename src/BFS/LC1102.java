package BFS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC1102 {
    public int maximumMinimumPath(int[][] a) {
        //todo: corner case
        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0, -1}};
        int row = a.length, col = a[0].length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<>(){
            @Override
            public int compare(Integer f, Integer s){
                return a[s / col][s % col] - a[f / col][f % col];
            }
        });
        maxHeap.offer(0);
        int[] visited = new int[row * col];
        visited[0] = -1;
        int max = a[0][0];
        while(!maxHeap.isEmpty()){
            int cur = maxHeap.poll();
            int i = cur / col, j = cur % col;
            max = Math.min(max, a[i][j]);
            if(i == row - 1 && j == col - 1) return max;
            for(int[] direction : directions){
                int ii = direction[0] + i;
                int jj = direction[1] + j;
                if(ii >= 0 && ii < row && jj >= 0 && jj < col && visited[ii * col + jj] != -1){
                    maxHeap.offer(ii * col + jj);
                    visited[ii * col + jj] = -1;
                }
            }
        }
        return max;
    }
}
