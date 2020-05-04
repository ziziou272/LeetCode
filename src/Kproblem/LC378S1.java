package Kproblem;

import java.util.HashSet;
import java.util.PriorityQueue;

public class LC378S1 {
    private class Cell{
        int val;
        int x;
        int y;
        public Cell(int val, int i, int j){
            this.val = val;
            x = i;
            y = j;
        }

        @Override
        public int hashCode(){
            return  x + 31 * y;
        }
        @Override
        public boolean equals(Object o){
            if(o instanceof Cell)
            {
                Cell that = (Cell) o;
                return this.x == that.x && this.y == that.y;
            }
            else
                return false;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 || k == 0 || k > matrix.length * matrix[0].length)
            return -1;
        int row = matrix.length, col = matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((c1, c2) -> matrix[c1.x][c1.y] - matrix[c2.x][c2.y]);
        HashSet<Cell> mySet = new HashSet<>();

        Cell cur = new Cell(matrix[0][0], 0, 0);
        minHeap.offer(cur);
        mySet.add(cur);

        while(--k > 0){
            //heap will not empty
            cur = minHeap.poll();
            if(cur.x + 1 < col){
                Cell c1 = new Cell(matrix[cur.x + 1][cur.y], cur.x + 1, cur.y);
                if(!mySet.contains(c1)){
                    mySet.add(c1);
                    minHeap.offer(c1);
                }
            }
            if(cur.y + 1 < row){
                Cell c2 = new Cell(matrix[cur.x][cur.y + 1], cur.x, cur.y + 1);
                if(!mySet.contains(c2)){
                    mySet.add(c2);
                    minHeap.offer(c2);
                }
            }

        }
        return minHeap.peek().val;
    }
}
