package AmazonOA2;

public class FindPath {
    public static int findPath(int[][] matrix, int target){
        //cc
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        if(dfs(matrix, visited, target, 0, 0)) return 1;
        return -1;
    }
    private static boolean dfs(int[][] matrix, boolean[][] visited, int target, int x, int y){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || visited[x][y] || matrix[x][y] == 0) return false;
        if(matrix[x][y] == target) return true;
        visited[x][y] = true;
        if(dfs(matrix, visited, target,x - 1, y)) return true;
        if(dfs(matrix, visited, target, x + 1, y)) return true;
        if(dfs(matrix, visited, target, x, y - 1)) return true;
        if(dfs(matrix, visited, target, x, y + 1)) return true;
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = new int[][]{{1,1,1,1},{0,1,1,1},{0,1,0,1},{1,1,9,1},{0,0,1,1}};
        System.out.println(findPath(matrix, 9));
    }
}
