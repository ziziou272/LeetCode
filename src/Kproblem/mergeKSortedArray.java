package Kproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class mergeKSortedArray {
    public static List<Integer> mergeK(int[][] matrix){
        /*
        * [1,2,3,4]
        * s
        * [2,3,4,9]
        * s
        * [1,5,7]
        *  s
        * minHeap size row: []
        * 1 1 2 2 3 3 4 4 5 7 9
        * */
        //cc
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return res;
        int row = matrix.length, col = matrix[0].length;
        //store the index so that when we pop out we will know where it from
        //i * row + col   i = index/col  j= index%col
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> matrix[a/col][a%col] - matrix[b/col][b%col]);
        //push first element
        for(int i = 0; i < row; i++){
            minHeap.offer(i * row);
        }
        while(!minHeap.isEmpty()){
            int index = minHeap.poll();
            int ii = index / col;
            int jj = index % col;
            int value = matrix[ii][jj];
            res.add(value);
            //check is inside the array
            if(jj < col - 1) {
                int nextIndex = ii * row + jj + 1;
                minHeap.offer(nextIndex);
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,2,3},{1,3,5},{2,5,7}};
        System.out.println(mergeK(matrix).toString());
    }
}
