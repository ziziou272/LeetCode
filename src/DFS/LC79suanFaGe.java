package DFS;

import java.util.List;

public class LC79suanFaGe {
    //时间复杂度：(4^k + m*n)*m*n
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) return false;
        if(word == null || word.length() == 0) return true;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, word, i, j, 0, visited))
                    return true;
            }
        }
        return false;
    }
    //不是 all possible solution 的话 return你结果 否则无法优化
    private boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited){
        if(index == word.length()) return true;
        if( x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] || word.charAt(index) != board[x][y])
            return false;
        visited[x][y] = true;
        if(dfs(board, word, x + 1, y, index + 1, visited))
            return true;
        if(dfs(board, word, x - 1, y, index + 1, visited))
            return true;
        if(dfs(board, word, x, y + 1, index + 1, visited))
            return true;
        if(dfs(board, word, x, y - 1, index + 1, visited))
            return true;
        visited[x][y] = false;
        return false;
    }
}
