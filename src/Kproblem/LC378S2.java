package Kproblem;

import java.util.PriorityQueue;

//把第一行push进去 保证minHeap最多k个element
public class LC378S2 {
    private class Node{
        int x, y, val;
        public Node(int val, int i, int j){
            this.val = val;
            x = i;
            y = j;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 || k == 0 || k > matrix.length * matrix[0].length)
            return -1;
        int row = matrix.length, col = matrix[0].length;
        PriorityQueue<Node> minHeap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);


        for(int j = 0; j < col && j <= k; j++){
            minHeap.offer(new Node(matrix[0][j], 0, j));
        }

        while(--k > 0){
            Node cur = minHeap.poll();

            if(cur.x + 1 < row)
                minHeap.offer(new Node(matrix[cur.x + 1][cur.y], cur.x + 1, cur.y));
        }
        return minHeap.peek().val;
    }
}
