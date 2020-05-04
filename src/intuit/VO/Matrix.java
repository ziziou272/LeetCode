package intuit.VO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Matrix {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 0, 0, 0, -1},
                {0, -1, -1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, -1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] board2 = new int[][]{
                {0, -1, 0, 0, -1},
                {0, -1, -1, 0, -1},
                {-1, -1, 0, 0, 0},
                {-1, 0, -1, 0, 0},
                {-1, 0, -1, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, -1, -1, 0, 0},
                {0, -1, 0, -1, 0},
                {-1, 0, 0, -1, 0},
                {0, -1, -1, 0, 0},
                {0, 0, 0, 0, 0},
        };
        int[][] board4 = new int[][]{
                {1, 0, 0, 0, 0},
                {0, -1, -1, 0, 0},
                {0, -1, 0, 1, 0},
                {-1, 0, 0, 0, 0},
                {0, 1, -1, 0, 0},
                {0, 0, 0, 0, 0},
        };


        int[] start = new int[]{5, 0};
        int[] end = new int[]{0, 4};

        solutionMatrix solution = new solutionMatrix();
        //Q1
        List<List<Integer>> res1 = solution.findLegalMoves(board, start);
        System.out.println(res1);
        //test for Q2
        System.out.println(solution.isReachable(board, start));
        System.out.println(solution.isReachable(board, end));
        System.out.println(solution.isReachable(board2, start));
        System.out.println(solution.isReachable(board2, end));
        System.out.println(solution.isReachable(board3, start));
        System.out.println(solution.isReachable(board3, end));
        //test for Q3
        System.out.println("~~~~~~~~~~~~~~~~~~");
        System.out.println(solution.findLegalMoves(board4, new int[]{5, 2}));
        System.out.println(solution.findShortest(board4, new int[]{5, 2},
                new int[]{2, 0}));

    }
}
class solutionMatrix{

    /** q1:
     *  input: 2d matrix? and int[] location?
     *  output: List<int[]> ?
     *  1. check the location given is inside the board
     *  2. check up down left right, check if is valid
     *  o(1)
     */
    public List<List<Integer>> findLegalMoves(int[][] matrix,
                                              int[] location){//o(1)
        int i = location[0], j = location[1];
        List<List<Integer>> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        //check if the location is valid
        if(i < 0 || j < 0 || i >= row || j >= col)
            return res;
        int[][] directions = new int[][]{
                {-1, 0},{1, 0},{0, -1}, {0, 1}
        };
        for(int[] di : directions){
            int ii = i + di[0], jj = j + di[1];
            if(ii >= 0 && ii < row && jj >= 0 &&
                    jj < col && matrix[ii][jj] != -1){
                res.add(new ArrayList<>());
                res.get(res.size() - 1).add(ii);
                res.get(res.size() - 1).add(jj);
            }
        }
        return res;
    }

    /** q2:
     *  1. so it's same as start from the end point and check
     *  if it can reach all 0 points
     *  2. count how many zeros that we have
     *  3. traverse from the end point, once meet a 0, increment 1
     *  and set it visited to avoid visit one position multiple time
     *  4. after travers check if the count is equals to
     *  the number of 0s that we have
     *  if equals return tru otherwise return false
     */
    public boolean isReachable(int[][]board, int[] end){//o(m * n)
        int[] count0 = new int[1];
        int row = board.length, col = board[0].length;
        dfs(board, end, count0, new boolean[row][col]);
        int total = 0;
        for(int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if(board[i][j] == 0)
                    total++;
            }
        }
        return total == count0[0];
    }
    //helper function
    private void dfs(int[][] board, int[] position, int[] count0,
                     boolean[][] visited){
        List<List<Integer>> nextLocations = findLegalMoves(board, position);
        for(List<Integer> nextLocation : nextLocations){
            int i = nextLocation.get(0), j = nextLocation.get(1);
            if(visited[i][j]) continue;
            int[] next = new int[]{i, j};
            count0[0]++;
            visited[i][j] = true;
            dfs(board, next, count0, visited);
        }
    }

    /**  q3:
     *   1. count how many treasure are there
     *   2. use depth first search start from start to end
     *   (when reach end and collected all the treasures,
     *   means we find a potential results,
     *   if it's length is shorter than previous result or it is first result
     *   update the result)
     *   3.if no available result return empty list?
     */
    public List<List<Integer>> findShortest(int[][] board,
                                            int[] start, int[] end){
        //Time complexity : O(4^{m+n})
        // For every move, we have at most 4 options.
        //Space complexity : O(m+n) Recursion of depth m+n
        List<List<Integer>> res = new ArrayList<>();
        int total = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 1)
                    total++;
            }
        }
        List<List<Integer>> cur = new ArrayList<>();
        cur.add(new ArrayList<>());
        cur.get(0).add(start[0]);
        cur.get(0).add(start[1]);
        shortestPathDfs(board, start, end, res, cur,
                new boolean[board.length][board[0].length], total, new int[1]);
        return res;
    }
    private void shortestPathDfs(int[][] board, int[] start, int[] end,
                                 List<List<Integer>> res,
                                 List<List<Integer>> cur, boolean[][] visited,
                                 int count, int[] num){
        List<List<Integer>> nextLocations = findLegalMoves(board, start);
        for(List<Integer> nextLocation : nextLocations){
            int i = nextLocation.get(0), j = nextLocation.get(1);
            if(visited[i][j]) continue;
            int temp = num[0];
            if(board[i][j] == 1) num[0]++;
            cur.add(new ArrayList<>());
            cur.get(cur.size() - 1).add(i);
            cur.get(cur.size() - 1).add(j);
            if(i == end[0] && j == end[1] && count == num[0]
                    && (res.size() == 0 || cur.size() < res.size())){
                res.clear();
                res.addAll(cur);
                return;
            }
            //backtracking
            visited[i][j] = true;
            int[] next = new int[]{i, j};
            shortestPathDfs(board, next, end, res, cur, visited, count, num);
            cur.remove(cur.size() - 1);
            visited[i][j] = false;
            num[0] = temp;
        }
    }
    //todo: too complicated BFS
    private List<List<Integer>> shortestPathBFS(int[][] board,
                                                int[] start, int[] end){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        queue.offer(start);
        int count1 = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            List<List<Integer>> nextPositions = findLegalMoves(board, start);
            for(List<Integer> nextPosition: nextPositions){
                int i = nextPosition.get(0), j = nextPosition.get(1);
                if(!visited[i][j]){
                    queue.offer(new int[]{i, j});
                    if(board[i][j] == 1)
                        count1++;
                }
            }
        }
        return null;
    }
}
