package BinarySearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC668 {
}
/*
m * n board:
the values are from 1 to m *n:
to find the kth smallest: we could do binary search try values from 1 to m*n,
to find a SMALLEST value that greater or equals k numbers.
    1 2 3 4
1   1 2 3 4
2   2 4 6 8
3   3 6 9 12

1 2 3 4 5 6 7 8 9 10 11 12
l         l     l  l  r
                         l
if k = 3 -> 4
bs: 1 to 12 -> mid 6 -> o(log(m*n))
for each rows: o(m)
6 -> Math.min(6/1, n) -> 4
  -> (6/2, n) -> 3
  -> (2,n) ->2 ==> total 9 > 3
3 - 3,1,1 ->5
2 - 2,1,0 -> 3
*/
class Solution668bs {
    //
    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(count(mid, m, n) < k){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    private int count(int x, int m, int n){
        int count = 0;
        for(int i = 1; i <= m; i++){
            if(x/i == 0) break;
            count += Math.min(x/i, n);
        }
        return count;
    }
}
//memory limit exceed
class solutionMinHeap{
    public int findKthNumber(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer v1, Integer v2){
                int i1 = v1 / n + 1, j1 = v1 %n + 1;
                int i2 = v2/n + 1, j2 = v2 % n + 1;
                return i1*j1 - i2*j2;
            }
        });
        minHeap.offer(0);
        visited[0][0] = true;
        int res = 0;
        while(k-- > 0){
            int val = minHeap.poll();
            int i = val / n, j = val % n;
            res = (i+1) * (j+1);
            if(i + 1 < m && !visited[i + 1][j]){
                minHeap.offer((i + 1) * n + j);
                visited[i + 1][j] = true;
            }
            if(j + 1 < n && !visited[i][j + 1]){
                minHeap.offer(i * n + j + 1);
                visited[i][j + 1] = true;
            }
        }
        return res;
    }
}
/*
m = 5, n = 6, k 9
first <1,1>, <1,2>, <2,1>, <3,1>,<1,3>
minHeap -> override comparator ->  i * j -> integer -> i * n + j - > value
covert back: i = value / n, j = value % n.

current smallest -> push neighbor of current ->  right, down
1, 2, 2, 3, 3, 4

    1 2 3 4 5
  1 1 2 3
  2 2 4
  3 3
  4
  5
  6

*/