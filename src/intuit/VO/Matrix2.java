package intuit.VO;

import java.util.*;

public class Matrix2 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, -1, -1, 0, 0, 0},
                {0, 0, 0, -1, 0, 0},
                {-1, -1, -1, 0, -1, 0},
                {-1, 0, -1, 0, 0, -1},
                {0, 0, 0, 0, 0, -1}
        };
        int[][] matrix2 = new int[][]{
                {0, -1, -1, 0},
                {0, 0, 0, 0},
                {-1, 0, 0, 0},
                {-1, 0, -1, 0},
                {0, 0, 0, 0}
        };

        System.out.println(getValidCoordinates(matrix, 4, 5));
        System.out.println(getValidCoordinates(matrix, 0, 0));
        System.out.println(getValidCoordinates(matrix, 3, 1));
        System.out.println(getValidCoordinates(matrix, 2, 5));
        System.out.println(getValidCoordinates(matrix, 4, 1));
        //q2
        System.out.println(isReachable(matrix, 4, 1));
        System.out.println(isReachable(matrix2, 4, 1));
        //q3
        int[][] matrix3 = new int[][]{
                {0,  -1,  1,  0,  0,  0},
                {1,   0,  0, -1,  0,  0},
                {-1, -1, -1,  0,  0,  0},
                {-1,  0, -1,  0,  1, -1},
                {0,   0,  0,  0,  0, -1}
        };
        List<int[]> res = findShortestPath(matrix3, new int[]{0,0}, new int[]{4,4});
        List<int[]> res2 = findShortest(matrix3, new int[]{0,0}, new int[]{4,4});
        System.out.println("Q3---");
        System.out.println("BFS-----------------");
        for(int[] arr : res){
            System.out.println(arr[0] + " " + arr[1]);
        }
        System.out.println("DFS-----------------");
        for(int[] arr : res2){
            System.out.println(arr[0] + " " + arr[1]);
        }


    }
    //q2
    public static boolean isReachable(int[][] matrix, int i, int j){
        int row = matrix.length;
        int col = matrix[0].length;
        if(i < 0 || j < 0 || i >= row || j >= col) return false;
        boolean[][] visited = new boolean[row][col];
        dfs(matrix, i, j, visited);
        for(int k = 0; k < row; k++){
            for(int l = 0; l < col; l++){
                if(matrix[k][l] == 0 && !visited[k][l])
                    return false;
            }
        }
        return true;
    }
    private static void dfs(int[][] matrix, int i, int j, boolean[][] visited){
        if(visited[i][j]) return;
        visited[i][j] = true;
        List<List<Integer>> neis = getValidCoordinates(matrix, i, j);
        for(List<Integer> nei : neis){
            dfs(matrix, nei.get(0), nei.get(1), visited);
        }
    }

    public static List<List<Integer>> getValidCoordinates(int[][] matrix, int i, int j){
        List<List<Integer>> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] directions = new int[][]{
                {0,1}, {1, 0}, {-1, 0}, {0,-1}
        };
        for(int[] direction : directions){
            int ii = i + direction[0];
            int jj = j + direction[1];
            if(ii >= 0 && ii < row && jj >= 0 && jj < col && matrix[ii][jj] != -1){
                res.add(Arrays.asList(ii, jj));
            }
        }
        return res;
    }

    //dfs solution
    /*
    * dfs -> from start to end -> reach end -> if treasures == total, valid result ->  if this result's length < result -> update result
    * */
    public static List<int[]> findShortest(int[][] matrix, int[] start, int[] end){
        List<int[]> res = new ArrayList<>();
        int row = matrix.length, col = matrix[0].length;
        int total = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 1)
                    total++;
            }
        }
        List<int[]> path = new ArrayList<>();
        path.add(start);
        helper(matrix, start, end, new boolean[row][col], res, path, total, 0);
        return res;
    }

    private static void helper(int[][] matrix, int[] cur, int[] end, boolean[][] visited, List<int[]> res, List<int[]>path, int total, int count){

        if(total == count && cur[0] == end[0] && cur[1] == end[1]){
            if(res.size() == 0 || res.size() > path.size()){
                res.clear();
                res.addAll(path);
            }
            return;
        }
        if(visited[cur[0]][cur[1]]){
            return;
        }
        visited[cur[0]][cur[1]] = true;
        List<List<Integer>> neis = getValidCoordinates(matrix, cur[0], cur[1]);
        int tempCount = count;
        for(List<Integer> nei : neis){
            int i = nei.get(0);
            int j = nei.get(1);
            if(matrix[i][j] == 1)
                count++;
            int[] coordinate = new int[]{i, j} ;
            path.add(coordinate);
            helper(matrix,coordinate , end, visited, res, path, total, count);
            path.remove(path.size() - 1);
            count = tempCount;
        }
        visited[cur[0]][cur[1]] = false;
    }

    //bfs solution
    public static List<int[]> findShortestPath(int[][] matrix, int[] start, int[] end){
        //get count of treasure
        int row = matrix.length;
        int col = matrix[0].length;
        int total = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 1)
                    total++;
            }
        }
        //bfs
        Queue<List<int[]>> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{start[0], start[1]});
        queue.offer(list);
        while(!queue.isEmpty()){
            list = queue.poll();
            int[] cur = list.get(list.size() - 1);
            List<List<Integer>> neis = getValidCoordinates(matrix, cur[0], cur[1]);
            for(List<Integer> nei : neis){
                int i = nei.get(0);
                int j = nei.get(1);
                int[] coordinate = new int[]{i, j};
                List<int[]> curList = new ArrayList<>(list);
                curList.add(coordinate);
                queue.offer(curList);
                if(i == end[0] && j == end[1] && getAll(curList, matrix) == total)
                    return curList;
            }
        }
        return null;
    }

    private static int getAll(List<int[]> list, int[][] matrix){
        int count = 0;
        for(int[] arr : list){
            if(matrix[arr[0]][arr[1]] == 1)
                count++;
        }
        return count;
    }
}
