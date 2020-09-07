package AamazonOA2_2020;

import java.util.Arrays;
import java.util.List;

public class NumberofClusters {
    public static void main(String[] args) {
        System.out.println(clusterCount(3, Arrays.asList("aabba", "aabba", "aaacb")));
        System.out.println(clusterCount(2, Arrays.asList("aaa", "bbb")));
        System.out.println(clusterCount(2, Arrays.asList("bbbcaa", "bbbbbb")));
        System.out.println(clusterCount(3, Arrays.asList("aaa", "ccb", "aba")));
    }

    public static int clusterCount(int numOfRows, List<String> grid){
        boolean[][] visited = new boolean [numOfRows][grid.get(0).length()];
        int count = 0;
        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < grid.get(i).length(); j++){
                if(!visited[i][j]){
                    dfs(i, j, visited, grid, grid.get(i).charAt(j));
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int i, int j, boolean[][] visited, List<String> grid, char cur){
        if(visited[i][j]) return;
        visited[i][j]= true;
        int[][] directions = new int[][]{{0,1}, {1, 0}, {-1, 0}, {0, -1}};
        for(int[] direction : directions){
            int ii = i + direction[0];
            int jj = j + direction[1];
            if(ii >= 0 && ii < visited.length && jj >= 0 && jj < visited[0].length && grid.get(ii).charAt(jj) == cur){
                dfs(ii, jj, visited, grid, cur);
            }
        }
    }
}
